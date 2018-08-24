import java.security.SecureRandom;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;


public class BouncingBall extends JPanel implements Runnable
{
	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime;
	private Color colors;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int length;
	
	public BouncingBall(int dx, int dy)
	{
		setBackground(Color.WHITE);
		this.colors = Color.BLUE;
		this.x = 0;
		this.y = 0;
		this.dx = dx;
		this.dy = dy;
		this.length = 20;
		sleepTime = generator.nextInt(10);
	}
	
	public void run()
	{
		
		while(true)
		{
			try
			{
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException exception)
			{
				exception.printStackTrace();
				Thread.currentThread().interrupt();
			}
			
			ballMove();
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(colors);
		g.fillOval(x, y, 20, 20);
	}
	
	public void ballMove()
	{
		if (x + dx < 0)
		{
			x = 0;
			dx = -dx;
		}
		else if (x + dx + length > getWidth())
		{
			dx = -dx;
			x = getWidth()- length;
		}
		else
		{
			x += dx;
		}
		
		if (y + dy < 0)
		{
			y = 0;
			dy = -dy;
		}
		else if (y + dy + length > getHeight())
		{
			y = getHeight() - length;
			dy = -dy;
		}
		else
		{
			y += dy;
		}
		
		repaint();
	}
}
