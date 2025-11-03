import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Kata1 {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Multiple Moving Balls");
        shell.setLayout(new FillLayout());
        
        Canvas canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
        
        // Ball properties
        int[][] ballPositions = {{50, 50}, {100, 100}, {200, 200}};
        int[] ballRadii = {20, 30, 15};
        int[][] velocities = {{5, 5}, {-4, 4}, {3, -3}};
        Color[] ballColors = {
            display.getSystemColor(SWT.COLOR_GREEN),
            display.getSystemColor(SWT.COLOR_RED),
            display.getSystemColor(SWT.COLOR_BLUE)
        };
        
        canvas.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                for (int i = 0; i < ballPositions.length; i++) {
                    e.gc.setBackground(ballColors[i]);
                    e.gc.fillOval(
                        ballPositions[i][0], 
                        ballPositions[i][1], 
                        ballRadii[i] * 2, 
                        ballRadii[i] * 2
                    );
                }
            }
        });
        
        shell.setSize(400, 300);
        shell.open();
        
        // Animation loop
        Runnable animator = new Runnable() {
            public void run() {
                if (!canvas.isDisposed()) {
                    // Update ball positions
                    for (int i = 0; i < ballPositions.length; i++) {
                        ballPositions[i][0] += velocities[i][0];
                        ballPositions[i][1] += velocities[i][1];
                        
                        // Bounce off walls
                        if (ballPositions[i][0] + ballRadii[i] * 2 > canvas.getSize().x || ballPositions[i][0] < 0) {
                            velocities[i][0] = -velocities[i][0];
                        }
                        if (ballPositions[i][1] + ballRadii[i] * 2 > canvas.getSize().y || ballPositions[i][1] < 0) {
                            velocities[i][1] = -velocities[i][1];
                        }
                    }
                    
                    // Redraw canvas
                    canvas.redraw();
                    display.timerExec(50, this);
                }
            }
        };
        
        display.timerExec(50, animator);
        
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}

