package day01.v2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {
    private static final int SPEED = 5;
    Tank tank = new Tank();

    public TankFrame() {
        this.setTitle("tank war");
        this.setLocation(400, 200);
        this.setSize(500, 500);
        this.setVisible(true);
        // 内部类，就自己用。高内聚，低耦合
        this.addKeyListener(new TankKeyListener());
    }

    // Paints the container
    @Override
    public void paint(Graphics g) {
        tank.paint(g);
    }

    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            tank.keyReleased(e);
        }
    }
}
