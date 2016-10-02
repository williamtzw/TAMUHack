import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class Tongue {

    private Debug game;
    int y = 600;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 67;
    int xa = 0;
    int ya = 0;

    private BufferedImage img = null;


    public Tongue(Debug game) {
        this.game = game;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("Tongue2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
        if (y + ya > 0 && y + ya < game.getHeight()- HEIGHT)
            y = y+ya;
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            ya = 8;
    }

    public void paint(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -8;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 8;
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            ya = -8;
    }
}
