import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.applet.Applet;

public class Bug
{
	private BufferedImage fly_1 = null;
	private BufferedImage fly_2 = null;
	private BufferedImage fly_3 = null;
	private BufferedImage fly_4 = null;
	private BufferedImage fly_5 = null;
	double x;
	double y = (int)(Math.random()*550);
	double xa = 1;
	double ya = 1;
	private Game game;
	
	public Bug(Game game, int startingX)
	{
		this.game = game;
		x = startingX;
		try {
			fly_1 = ImageIO.read(getClass().getResourceAsStream("/fly_1.png"));
			fly_2 = ImageIO.read(getClass().getResourceAsStream("/fly_2.png"));
			fly_3 = ImageIO.read(getClass().getResourceAsStream("/fly_3.png"));
			fly_4 = ImageIO.read(getClass().getResourceAsStream("/fly_4.png"));
			fly_5 = ImageIO.read(getClass().getResourceAsStream("/fly_5.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void move()
	{
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - *BUG_WIDTH*)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - 550 - *BUG_HEIGHT*)
			ya = -game.speed;
		else
			changeDirection = false;
			
		x += xa;
		y += ya;
	}
	
	public void paint(Graphics g, int x, int y, int z) {
		double scale = 0.3;
		
		if (z == 1) {
			g.drawImage(fly_1, x, y, (int)(fly_1.getWidth() * scale), (int)(fly_1.getHeight() * scale), null);
		}
		else if (z == 2) {
			g.drawImage(fly_2, x, y, (int)(fly_2.getWidth() * scale), (int)(fly_2.getHeight() * scale), null);
		}
		else if (z == 3) {
			g.drawImage(fly_3, x, y, (int)(fly_3.getWidth() * scale), (int)(fly_3.getHeight() * scale), null);
		}
		else if (z == 4) {
			g.drawImage(fly_4, x, y, (int)(fly_4.getWidth() * scale), (int)(fly_4.getHeight() * scale), null);
		}
		else if (z == 5) {
			g.drawImage(fly_5, x, y, (int)(fly_5.getWidth() * scale), (int)(fly_5.getHeight() * scale), null);
		}
	}
}