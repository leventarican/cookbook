import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * a green ball that moves in window
 * when frame reached then it changes direction (collision detection)
 */
public class Kata0 {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Moving Green Ball");
        shell.setLayout(new FillLayout());
        
        Canvas canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
        
        // Ball properties
        int[] ballPosition = {50, 50};
        int ballRadius = 20;
        int[] velocity = {5, 5};
        
        canvas.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                Color green = display.getSystemColor(SWT.COLOR_GREEN);
                e.gc.setBackground(green);
                e.gc.fillOval(ballPosition[0], ballPosition[1], ballRadius * 2, ballRadius * 2);
            }
        });
        
        shell.setSize(400, 300);
        shell.open();
        
        // Animation loop
        Runnable animator = new Runnable() {
            public void run() {
                if (!canvas.isDisposed()) {
                    // Update ball position
                    ballPosition[0] += velocity[0];
                    ballPosition[1] += velocity[1];
                    
                    // Bounce off walls
                    if (ballPosition[0] + ballRadius * 2 > canvas.getSize().x || ballPosition[0] < 0) {
                        velocity[0] = -velocity[0];
                    }
                    if (ballPosition[1] + ballRadius * 2 > canvas.getSize().y || ballPosition[1] < 0) {
                        velocity[1] = -velocity[1];
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

