import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Debug extends JPanel implements ActionListener{


    private Timer time;
    double speed = 1;
    int flies = 0;
    double hunger = 50;
    Frog frog = new Frog(this);
    Tongue tongue = new Tongue(this);
    BufferedImage lake;
    public Debug(){
        time = new Timer(15, this);
        time.start();
        addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){}
            public void keyReleased(KeyEvent e){
                frog.keyReleased(e);
                tongue.keyReleased(e);
            }

            public void keyPressed(KeyEvent e) {
                frog.keyPressed(e);
                tongue.keyPressed(e);
            }

        });

        setFocusable(true);
    }

    private int getScore(){ return flies;}

    public void gameOver(){
        JOptionPane.showMessageDialog(this, "You ate " + getScore() + " flies.", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    private void move(){
        frog.move();
        tongue.move();
    }

    public void actionPerformed(ActionEvent e)
    {
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);


            try {
                lake = ImageIO.read(getClass().getResourceAsStream("lake1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        g.drawImage(lake, 0, 540, null);
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, 600, 800);
        tongue.paint((Graphics2D) g);
        g.setColor(Color.BLUE);
       // g.fillRect(0, 600, 600, 100);

        frog.paint((Graphics2D)g);




    }



    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("Feed Mr. Frog");

        Debug game = new Debug();
        frame.add(new JLabel(new ImageIcon("sky.png")));
        frame.add(game);
        frame.setSize(600, 800);
        //frame.add(new JLabel(new ImageIcon("sky.png")));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        while(true){
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }



}
