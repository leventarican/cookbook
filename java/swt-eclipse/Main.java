import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(400, 400);
        shell.setText("SWT Ball Drawing");

        shell.addPaintListener(e -> {
            GC gc = e.gc;
            
            // Set ball color
            Color ballColor = new Color(display, 0, 0, 255); // Blue
            gc.setBackground(ballColor);
            
            // Draw filled circle/ball
            gc.fillOval(150, 150, 100, 100);
            
            // Dispose color to prevent resource leak
            ballColor.dispose();
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}

