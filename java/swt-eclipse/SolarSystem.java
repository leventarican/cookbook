import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SolarSystem {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1200;

    private Display display;
    private Shell shell;
    private Canvas canvas;

    private List<CelestialBody> bodies = new ArrayList<>();
    private List<Point> stars = new ArrayList<>();
    private float zoomFactor = 0.5f;
    private Color turquoise;

    private static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    private class CelestialBody {
        String name;
        Color color;
        int radius;
        int orbitRadius;
        double speed;
        double angle = 0;
        CelestialBody orbits;
        boolean isAsteroid = false;

        CelestialBody(String name, Color color, int radius, int orbitRadius, double speed, CelestialBody orbits) {
            this.name = name;
            this.color = color;
            this.radius = radius;
            this.orbitRadius = orbitRadius;
            this.speed = speed;
            this.orbits = orbits;
            this.angle = new Random().nextDouble() * 2 * Math.PI; // Start at a random angle
        }

        void update() {
            angle += speed;
        }

        Point getPosition() {
            int centerX = 0; // Origin for drawing
            int centerY = 0;
            if (orbits != null) {
                Point parentPos = orbits.getPosition();
                centerX = parentPos.x;
                centerY = parentPos.y;
            }
            int x = (int) (centerX + orbitRadius * Math.cos(angle));
            int y = (int) (centerY + orbitRadius * Math.sin(angle));
            return new Point(x, y);
        }

        void draw(GC gc) {
            Point pos = getPosition();
            gc.setBackground(color);
            gc.fillOval(pos.x - radius, pos.y - radius, radius * 2, radius * 2);

            if ("Saturn".equals(name)) {
                gc.setForeground(display.getSystemColor(SWT.COLOR_GRAY));
                gc.drawOval(pos.x - (radius + 5), pos.y - (radius + 5), (radius + 5) * 2, (radius + 5) * 2);
                gc.drawOval(pos.x - (radius + 10), pos.y - (radius + 10), (radius + 10) * 2, (radius + 10) * 2);
            }

            if (!isAsteroid) {
                gc.setForeground(turquoise);
                gc.drawString(name, pos.x + radius + 5, pos.y - radius - 5);
            }
        }

        void drawOrbit(GC gc) {
            if (orbits != null) {
                gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
                gc.drawOval(orbits.getPosition().x - orbitRadius, orbits.getPosition().y - orbitRadius, orbitRadius * 2, orbitRadius * 2);
            }
        }
    }

    public static void main(String[] args) {
        new SolarSystem().run();
    }

    private void run() {
        display = new Display();
        shell = new Shell(display);
        shell.setText("Solar System");
        shell.setSize(WIDTH, HEIGHT);

        turquoise = new Color(display, 64, 224, 208);
        createSolarSystem();
        createStars();
        createAsteroidBelt();

        canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
        canvas.setSize(WIDTH, HEIGHT);

        canvas.addPaintListener(e -> {
            GC gc = e.gc;
            gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
            gc.fillRectangle(0, 0, WIDTH, HEIGHT);

            drawStars(gc);

            Transform t = new Transform(display);
            t.translate(WIDTH / 2, HEIGHT / 2);
            t.scale(zoomFactor, zoomFactor);
            gc.setTransform(t);

            for (CelestialBody body : bodies) {
                body.drawOrbit(gc);
            }
            for (CelestialBody body : bodies) {
                body.draw(gc);
            }

            gc.setTransform(null); // Reset transform to draw UI elements
            gc.setForeground(turquoise);
            gc.drawString(String.format("Zoom: %.0f%%", zoomFactor * 100), 10, 10);

            t.dispose();
        });

        canvas.addListener(SWT.MouseWheel, event -> {
            if (event.count > 0) {
                zoomFactor *= 1.1f;
            } else {
                zoomFactor /= 1.1f;
            }
            canvas.redraw();
        });

        // Animation loop
        display.timerExec(20, new Runnable() {
            @Override
            public void run() {
                if (!shell.isDisposed()) {
                    for (CelestialBody body : bodies) {
                        body.update();
                    }
                    canvas.redraw();
                    display.timerExec(20, this);
                }
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        disposeColors();
        turquoise.dispose();
        display.dispose();
    }

    private void createSolarSystem() {
        // Colors
        Color sunColor = new Color(display, 255, 223, 0);
        Color mercuryColor = new Color(display, 169, 169, 169);
        Color venusColor = new Color(display, 255, 239, 191);
        Color earthColor = new Color(display, 0, 128, 255);
        Color marsColor = new Color(display, 192, 64, 0);
        Color jupiterColor = new Color(display, 210, 180, 140);
        Color saturnColor = new Color(display, 238, 221, 130);
        Color uranusColor = new Color(display, 173, 216, 230);
        Color neptuneColor = new Color(display, 65, 105, 225);
        Color moonColor = new Color(display, 200, 200, 200);

        // Bodies
        CelestialBody sun = new CelestialBody("Sun", sunColor, 50, 0, 0, null);
        CelestialBody mercury = new CelestialBody("Mercury", mercuryColor, 4, 80, 0.04, sun);
        CelestialBody venus = new CelestialBody("Venus", venusColor, 8, 120, 0.025, sun);
        CelestialBody earth = new CelestialBody("Earth", earthColor, 10, 180, 0.01, sun);
        CelestialBody moon = new CelestialBody("Moon", moonColor, 3, 30, 0.1, earth);
        CelestialBody mars = new CelestialBody("Mars", marsColor, 7, 250, 0.008, sun);
        CelestialBody jupiter = new CelestialBody("Jupiter", jupiterColor, 25, 350, 0.005, sun);
        CelestialBody saturn = new CelestialBody("Saturn", saturnColor, 22, 450, 0.003, sun);
        CelestialBody uranus = new CelestialBody("Uranus", uranusColor, 18, 550, 0.002, sun);
        CelestialBody neptune = new CelestialBody("Neptune", neptuneColor, 17, 650, 0.001, sun);

        bodies.add(sun);
        bodies.add(mercury);
        bodies.add(venus);
        bodies.add(earth);
        bodies.add(moon);
        bodies.add(mars);
        bodies.add(jupiter);
        bodies.add(saturn);
        bodies.add(uranus);
        bodies.add(neptune);
    }

    private void createAsteroidBelt() {
        Random rand = new Random();
        Color asteroidColor = new Color(display, 139, 139, 131);
        CelestialBody sun = bodies.get(0); // Asteroids orbit the sun
        for (int i = 0; i < 300; i++) {
            int orbitRadius = 280 + rand.nextInt(40);
            double speed = 0.006 + rand.nextDouble() * 0.002;
            int radius = 1 + rand.nextInt(2);
            CelestialBody asteroid = new CelestialBody("", asteroidColor, radius, orbitRadius, speed, sun);
            asteroid.isAsteroid = true;
            bodies.add(asteroid);
        }
    }

    private void createStars() {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            stars.add(new Point(rand.nextInt(WIDTH), rand.nextInt(HEIGHT)));
        }
    }

    private void drawStars(GC gc) {
        gc.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
        for (Point star : stars) {
            gc.drawPoint(star.x, star.y);
        }
    }

    private void disposeColors() {
        for (CelestialBody body : bodies) {
            if(body.color != null) body.color.dispose();
        }
    }
}
