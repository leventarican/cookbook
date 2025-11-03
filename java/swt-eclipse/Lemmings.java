import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class Lemmings {

    private static final int WORLD_WIDTH = 80;
    private static final int WORLD_HEIGHT = 60;
    private static final int BLOCK_SIZE = 10;
    private static final int UI_HEIGHT = 40;
    private static final int MAX_FALL_DISTANCE = 100;

    private Display display;
    private Shell shell;
    private Canvas canvas;

    private int[][] world = new int[WORLD_HEIGHT][WORLD_WIDTH];
    private List<Lemming> lemmings = new ArrayList<>();
    private int lemmingsToSpawn = 5;
    private int lemmingsSpawned = 0;
    private int lemmingsSaved = 0;

    private Rectangle target;
    private boolean gameOver = false;
    private String gameOverMessage = "";

    private enum LemmingState {WALKING, FALLING, DIGGING, SLIDING, DEAD, SAVED}
    private enum SelectedSkill {NONE, DIG, UMBRELLA}
    private SelectedSkill selectedSkill = SelectedSkill.NONE;

    private class Lemming {
        float x, y, vx, vy;
        LemmingState state = LemmingState.FALLING;
        float fallStartY = 0;
        boolean isDead = false;

        Lemming(float x, float y) {
            this.x = x;
            this.y = y;
            this.vx = 1; // Start by moving right
            this.fallStartY = y;
        }

        void update() {
            if (isDead || state == LemmingState.SAVED) return;

            if (target.contains((int)x, (int)y)){
                state = LemmingState.SAVED;
                lemmingsSaved++;
                return;
            }

            switch (state) {
                case WALKING:
                    if (!isGround((int) ((x + vx) / BLOCK_SIZE), (int) (y / BLOCK_SIZE) + 1)) {
                        state = LemmingState.FALLING;
                        fallStartY = y;
                        vy = 1;
                    } else if (isWall((int) ((x + vx) / BLOCK_SIZE), (int) (y / BLOCK_SIZE))) {
                        vx = -vx;
                    }
                    x += vx;
                    break;
                case FALLING:
                    y += vy;
                    if (isGround((int) (x / BLOCK_SIZE), (int) (y / BLOCK_SIZE) + 1)) {
                        if (y - fallStartY > MAX_FALL_DISTANCE) {
                            isDead = true;
                            state = LemmingState.DEAD;
                            gameOver = true;
                            gameOverMessage = "Game Over: A lemming died!";
                        } else {
                            state = LemmingState.WALKING;
                            y = ((int) (y / BLOCK_SIZE)) * BLOCK_SIZE;
                        }
                    }
                    break;
                case DIGGING:
                    int digX = (int) (x / BLOCK_SIZE);
                    int digY = (int) (y / BLOCK_SIZE) + 1;
                    if (digY < WORLD_HEIGHT && world[digY][digX] == 1) {
                        world[digY][digX] = 0;
                        y += BLOCK_SIZE; // Move down a block
                    } else {
                        state = LemmingState.FALLING;
                        fallStartY = y;
                    }
                    break;
                case SLIDING:
                    vy = 0.5f; // Slower fall speed
                    y += vy;
                    if (isGround((int) (x / BLOCK_SIZE), (int) (y / BLOCK_SIZE) + 1)) {
                        state = LemmingState.WALKING;
                        y = ((int) (y / BLOCK_SIZE)) * BLOCK_SIZE;
                    }
                    break;
            }
        }

        void draw(GC gc) {
            if (state == LemmingState.SAVED) return;

            if (isDead) {
                gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
            } else {
                gc.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
            }
            gc.fillOval((int) x, (int) y, BLOCK_SIZE, BLOCK_SIZE);

            if (state == LemmingState.SLIDING) {
                gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
                gc.fillArc((int) x - BLOCK_SIZE / 2, (int) y - BLOCK_SIZE, BLOCK_SIZE * 2, BLOCK_SIZE * 2, 0, 180);
            }
        }
    }

    public static void main(String[] args) {
        new Lemmings().run();
    }

    private void run() {
        display = new Display();
        shell = new Shell(display);
        shell.setText("Lemmings");
        shell.setSize(WORLD_WIDTH * BLOCK_SIZE, WORLD_HEIGHT * BLOCK_SIZE + UI_HEIGHT);

        createWorld();

        canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
        canvas.setSize(WORLD_WIDTH * BLOCK_SIZE, WORLD_HEIGHT * BLOCK_SIZE + UI_HEIGHT);
        canvas.addPaintListener(e -> {
            GC gc = e.gc;
            drawWorld(gc);
            for (Lemming l : lemmings) {
                l.draw(gc);
            }
            drawUI(gc);
            if (gameOver) {
                gc.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
                gc.drawString(gameOverMessage, WORLD_WIDTH * BLOCK_SIZE / 2 - 100, WORLD_HEIGHT * BLOCK_SIZE / 2);
            }
        });

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                if (gameOver) return;
                if (e.y >= WORLD_HEIGHT * BLOCK_SIZE) {
                    // UI click
                    if (e.x > 10 && e.x < 50) selectedSkill = SelectedSkill.DIG;
                    else if (e.x > 60 && e.x < 130) selectedSkill = SelectedSkill.UMBRELLA;
                    else selectedSkill = SelectedSkill.NONE;
                } else {
                    // Game world click
                    applySkillToLemming(e.x, e.y);
                }
            }
        });

        // Lemming spawner
        display.timerExec(2000, new Runnable() {
            @Override
            public void run() {
                if (!shell.isDisposed() && lemmingsSpawned < lemmingsToSpawn) {
                    lemmings.add(new Lemming(10 * BLOCK_SIZE, 5 * BLOCK_SIZE));
                    lemmingsSpawned++;
                    display.timerExec(2000, this);
                }
            }
        });

        // Game loop
        display.timerExec(50, new Runnable() {
            @Override
            public void run() {
                if (!shell.isDisposed() && !gameOver) {
                    for (Lemming l : lemmings) {
                        l.update();
                    }
                    if (lemmingsSaved == lemmingsToSpawn) {
                        gameOver = true;
                        gameOverMessage = "You Win!";
                    }
                    canvas.redraw();
                    display.timerExec(50, this);
                }
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private void createWorld() {
        // Create some platforms
        for (int i = 10; i < 15; i++) {
            for (int j = 5; j < WORLD_WIDTH - 5; j++) {
                world[i][j] = 1;
            }
        }
        for (int i = 25; i < 30; i++) {
            for (int j = 0; j < WORLD_WIDTH - 10; j++) {
                world[i][j] = 1;
            }
        }
        for (int i = 40; i < 45; i++) {
            for (int j = 10; j < WORLD_WIDTH; j++) {
                world[i][j] = 1;
            }
        }
        // Target
        target = new Rectangle((WORLD_WIDTH - 15) * BLOCK_SIZE, 50 * BLOCK_SIZE, BLOCK_SIZE * 2, BLOCK_SIZE * 2);
        for (int i = 50; i < 52; i++) {
            for (int j = WORLD_WIDTH - 15; j < WORLD_WIDTH - 13; j++) {
                world[i][j] = 2; // Target block type
            }
        }
    }

    private void drawWorld(GC gc) {
        gc.setBackground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
        gc.fillRectangle(0, 0, WORLD_WIDTH * BLOCK_SIZE, WORLD_HEIGHT * BLOCK_SIZE);
        Color dirtColor = new Color(display, 139, 69, 19); // Brown
        gc.setBackground(dirtColor);
        for (int i = 0; i < WORLD_HEIGHT; i++) {
            for (int j = 0; j < WORLD_WIDTH; j++) {
                if (world[i][j] == 1) {
                    gc.fillRectangle(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
        gc.setBackground(display.getSystemColor(SWT.COLOR_DARK_GREEN));
        gc.fillRectangle(target);
        dirtColor.dispose();
    }

    private void drawUI(GC gc) {
        gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
        gc.fillRectangle(0, WORLD_HEIGHT * BLOCK_SIZE, WORLD_WIDTH * BLOCK_SIZE, UI_HEIGHT);

        gc.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
        gc.drawString("DIG", 10, WORLD_HEIGHT * BLOCK_SIZE + 10);
        gc.drawString("UMBRELLA", 60, WORLD_HEIGHT * BLOCK_SIZE + 10);

        if (selectedSkill != SelectedSkill.NONE) {
            gc.setForeground(display.getSystemColor(SWT.COLOR_YELLOW));
            if (selectedSkill == SelectedSkill.DIG) gc.drawRectangle(8, WORLD_HEIGHT * BLOCK_SIZE + 8, 30, 20);
            if (selectedSkill == SelectedSkill.UMBRELLA) gc.drawRectangle(58, WORLD_HEIGHT * BLOCK_SIZE + 8, 70, 20);
        }
    }

    private boolean isGround(int x, int y) {
        if (x < 0 || x >= WORLD_WIDTH || y < 0 || y >= WORLD_HEIGHT) return false;
        return world[y][x] == 1;
    }

    private boolean isWall(int x, int y) {
        if (x < 0 || x >= WORLD_WIDTH || y < 0 || y >= WORLD_HEIGHT) return true;
        return world[y][x] == 1;
    }

    private void applySkillToLemming(int mx, int my) {
        Lemming clickedLemming = null;
        double min_dist = Double.MAX_VALUE;
        for (Lemming l : lemmings) {
            double dist = Math.sqrt(Math.pow(l.x - mx, 2) + Math.pow(l.y - my, 2));
            if (dist < min_dist) {
                min_dist = dist;
                clickedLemming = l;
            }
        }

        if (clickedLemming != null && min_dist < BLOCK_SIZE) {
            if (selectedSkill == SelectedSkill.DIG) {
                clickedLemming.state = LemmingState.DIGGING;
            } else if (selectedSkill == SelectedSkill.UMBRELLA) {
                if (clickedLemming.state == LemmingState.FALLING) {
                    clickedLemming.state = LemmingState.SLIDING;
                }
            }
            selectedSkill = SelectedSkill.NONE; // Reset skill after applying
        }
    }
}
