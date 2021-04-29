package day01.v1;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void Oral() {
        Frame frame = new Frame("tank war");
        frame.setLocation(500, 500);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public static void TankFrameDemo1() {
        TankFrame tankFrame = new TankFrame();
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(25);
                tankFrame.x += 1;
                // repaint内部会调用update方法，update调用paint
                tankFrame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void TankFrameDemo2() {
        TankFrame tankFrame = new TankFrame();
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(25);
                // repaint内部会调用update方法，update调用paint
                tankFrame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TankFrameDemo2();
    }
}
