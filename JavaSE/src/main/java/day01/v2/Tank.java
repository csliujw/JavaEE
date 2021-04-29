package day01.v2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private static final int SPEED = 5;

    private int x;
    private int y;
    private Dir dir;

    public Tank() {
        this(50, 50, Dir.D);
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }

    public void move() {
        switch (dir) {
            case D:
                y += SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case L:
                x -= SPEED;
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                dir = Dir.L;
                break;
            case KeyEvent.VK_RIGHT:
                dir = Dir.R;
                break;
            case KeyEvent.VK_UP:
                dir = Dir.U;
                break;
            case KeyEvent.VK_DOWN:
                dir = Dir.D;
                break;
        }
        move();
    }

    public void keyReleased(KeyEvent e) {

    }
}
