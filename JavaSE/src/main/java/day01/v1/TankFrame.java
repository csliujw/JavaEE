package day01.v1;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    private static final int SPEED = 5;
    int x = 100;
    int y = 100;

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
        // g.setColor(Color.BLUE); 在绘制之前设置颜色。就是不同的颜色了。
        g.fillRect(x, y, 50, 50);
    }

    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    x += SPEED;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += SPEED;
                    break;
                case KeyEvent.VK_UP:
                    y -= SPEED;
                    break;
                case KeyEvent.VK_DOWN:
                    y += SPEED;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
