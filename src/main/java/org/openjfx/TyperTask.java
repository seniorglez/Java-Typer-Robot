package org.openjfx;
import javafx.concurrent.Task;
import java.awt.*;


public class TyperTask extends Task {
    private static TyperTask tt = null;
    private String text;
    private Robot robot;

    private TyperTask()  {//forgive me xD
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public static TyperTask getInstance(){
        if(tt==null){
            tt = new TyperTask();
        }
        return tt;
    }

    @Override
    protected Object call() throws Exception {
        Thread.sleep(5000);
        System.out.println("Starting to type: "+ text);
        type(text);
        Thread.sleep(10000);
        System.exit(0);
        return null;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void type(int i)
    {
        robot.delay(100);
        robot.keyPress(i);
        robot.delay(100);
        robot.keyRelease(i);
    }

    private void type(String s)
    {
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32;
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }
}
