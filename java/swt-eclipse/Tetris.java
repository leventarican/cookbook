
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tetris {

    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 20;
    private static final int BLOCK_SIZE = 30;

    private Display display;
    private Shell shell;
    private Canvas canvas;

    private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
    private final Point[][][] pieces = {
            // I-shape
            {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)}},
            // J-shape
            {{new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)}},
            // L-shape
            {{new Point(2, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)}},
            // O-shape
            {{new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)}},
            // S-shape
            {{new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)}},
            // T-shape
            {{new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)}},
            // Z-shape
            {{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)}}
    };

    private Color[] pastelColors;
    private Point currentPiecePosition;
    private Point[] currentPiece;
    private int currentPieceIndex;
    private int rotation;
    private int score = 0;

    private List<Particle> particles = new ArrayList<>();
    private Random random = new Random();

    public static void main(String[] args) {
        Kata2 tetris = new Kata2();
        tetris.run();
    }

    public void run() {
        display = new Display();
        shell = new Shell(display);
        shell.setText("Tetris");
        shell.setSize(BOARD_WIDTH * BLOCK_SIZE + 17, BOARD_HEIGHT * BLOCK_SIZE + 40);

        initColors();

        canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
        canvas.setSize(BOARD_WIDTH * BLOCK_SIZE, BOARD_HEIGHT * BLOCK_SIZE);

        newPiece();

        canvas.addPaintListener(e -> {
            e.gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
            e.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);

            // Draw board
            for (int i = 0; i < BOARD_HEIGHT; i++) {
                for (int j = 0; j < BOARD_WIDTH; j++) {
                    if (board[i][j] != 0) {
                        drawBlock(e.gc, j, i, board[i][j]);
                    }
                }
            }

            // Draw current piece
            for (Point p : currentPiece) {
                drawBlock(e.gc, currentPiecePosition.x + p.x, currentPiecePosition.y + p.y, currentPieceIndex + 1);
            }

            // Draw particles
            for (Particle p : particles) {
                p.draw(e.gc);
            }

            // Draw score
            e.gc.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
            e.gc.drawString("Score: " + score, 10, 10);
        });

        shell.addListener(SWT.KeyDown, e -> {
            switch (e.keyCode) {
                case SWT.ARROW_LEFT:
                    move(-1, 0);
                    break;
                case SWT.ARROW_RIGHT:
                    move(1, 0);
                    break;
                case SWT.ARROW_DOWN:
                    move(0, 1);
                    break;
                case SWT.ARROW_UP:
                    rotate();
                    break;
            }
        });

        display.timerExec(50, new Runnable() {
            @Override
            public void run() {
                if (!shell.isDisposed()) {
                    updateParticles();
                    canvas.redraw();
                    display.timerExec(50, this);
                }
            }
        });

        display.timerExec(500, new Runnable() {
            @Override
            public void run() {
                if (!shell.isDisposed()) {
                    move(0, 1);
                    display.timerExec(500, this);
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
        display.dispose();
    }

    private void initColors() {
        pastelColors = new Color[]{
                new Color(display, 255, 179, 186), // I
                new Color(display, 255, 223, 186), // J
                new Color(display, 255, 255, 186), // L
                new Color(display, 186, 255, 201), // O
                new Color(display, 186, 225, 255), // S
                new Color(display, 204, 204, 255), // T
                new Color(display, 230, 186, 255)  // Z
        };
    }

    private void disposeColors() {
        for (Color color : pastelColors) {
            color.dispose();
        }
    }

    private void drawBlock(org.eclipse.swt.graphics.GC gc, int x, int y, int colorIndex) {
        Color color = pastelColors[colorIndex - 1];
        gc.setBackground(color);
        gc.fillRectangle(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        gc.setForeground(display.getSystemColor(SWT.COLOR_GRAY));
        gc.drawRectangle(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }

    private void newPiece() {
        currentPieceIndex = random.nextInt(pieces.length);
        currentPiece = pieces[currentPieceIndex][0];
        rotation = 0;
        currentPiecePosition = new Point(BOARD_WIDTH / 2 - 1, 0);
        if (collides()) {
            // Game over
            System.out.println("Game Over. Final Score: " + score);
            shell.dispose();
        }
    }

    private void move(int dx, int dy) {
        currentPiecePosition.x += dx;
        currentPiecePosition.y += dy;
        if (collides()) {
            currentPiecePosition.x -= dx;
            currentPiecePosition.y -= dy;
            if (dy == 1) {
                placePiece();
            }
        }
        canvas.redraw();
    }

    private void rotate() {
        Point[] rotated = new Point[4];
        for (int i = 0; i < currentPiece.length; i++) {
            rotated[i] = new Point(-currentPiece[i].y, currentPiece[i].x);
        }
        Point[] original = currentPiece;
        currentPiece = rotated;
        if (collides()) {
            currentPiece = original;
        }
        canvas.redraw();
    }

    private boolean collides() {
        for (Point p : currentPiece) {
            int x = currentPiecePosition.x + p.x;
            int y = currentPiecePosition.y + p.y;
            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT || board[y][x] != 0) {
                return true;
            }
        }
        return false;
    }

    private void placePiece() {
        for (Point p : currentPiece) {
            board[currentPiecePosition.y + p.y][currentPiecePosition.x + p.x] = currentPieceIndex + 1;
        }
        clearLines();
        newPiece();
    }

    private void clearLines() {
        int linesCleared = 0;
        for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
            boolean lineFull = true;
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (board[i][j] == 0) {
                    lineFull = false;
                    break;
                }
            }
            if (lineFull) {
                linesCleared++;
                createExplosion(i);
                for (int k = i; k > 0; k--) {
                    board[k] = board[k - 1];
                }
                board[0] = new int[BOARD_WIDTH];
                i++; // Check the same line again
            }
        }
        if (linesCleared > 0) {
            score += linesCleared * 100;
        }
    }

    private void createExplosion(int y) {
        for (int j = 0; j < BOARD_WIDTH; j++) {
            for (int i = 0; i < 10; i++) {
                particles.add(new Particle(j * BLOCK_SIZE + BLOCK_SIZE / 2, y * BLOCK_SIZE + BLOCK_SIZE / 2, pastelColors[board[y][j] - 1]));
            }
        }
    }

    private void updateParticles() {
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            p.update();
            if (p.isDead()) {
                particles.remove(i);
            }
        }
    }

    private class Particle {
        float x, y, vx, vy;
        int lifespan;
        Color color;

        Particle(float x, float y, Color color) {
            this.x = x;
            this.y = y;
            this.vx = (float) (random.nextFloat() * 4 - 2);
            this.vy = (float) (random.nextFloat() * 4 - 2);
            this.lifespan = 30;
            this.color = color;
        }

        void update() {
            x += vx;
            y += vy;
            lifespan--;
        }

        boolean isDead() {
            return lifespan <= 0;
        }

        void draw(org.eclipse.swt.graphics.GC gc) {
            gc.setBackground(color);
            gc.setAlpha(lifespan * 255 / 30);
            gc.fillOval((int) x, (int) y, 5, 5);
            gc.setAlpha(255);
        }
    }
}
