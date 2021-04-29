package day01.v2;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
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
}
