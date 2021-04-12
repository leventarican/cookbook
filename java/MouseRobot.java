import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MouseRobot {
  Robot robot = new Robot();

  private void click() {
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.delay(200);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    robot.delay(200);
  }

  public MouseRobot() throws AWTException {
    robot.setAutoDelay(40);
    robot.setAutoWaitForIdle(true);
    
    robot.delay(500);
    robot.mouseMove(1600, 800);
    robot.delay(500);


  }

  public static void main(String[] args) throws AWTException {
    new MouseRobot();
  }
}