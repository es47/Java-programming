import java.security.SecureRandom;
import java.awt.Color;


public class BouncingBall
{
	private static final SecureRandom generator = new SecureRandom();
	private Color colors;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int length;
	
	public BouncingBall(int width, int height)
	{
		this.colors = new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255));
		this.length = 20;
		this.x = generator.nextInt(width - length);
		this.y = generator.nextInt(height - length);
		this.dx = generator.nextInt(10);
		this.dy = generator.nextInt(10);
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setDx(int dx)
	{
		this.dx = dx;
	}
	
	public void setDy(int dy)
	{
		this.dy = dy;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getDx()
	{
		return dx;
	}
	
	public int getDy()
	{
		return dy;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public Color getColor()
	{
		return colors;
	}

	public void ballMove(int width, int height)
	{
		if (x + dx < 0)
		{
			x = 0;
			dx = -dx;
		}
		else if (x + dx + length > width)
		{
			dx = -dx;
			x = width- length;
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
		else if (y + dy + length > height)
		{
			y = height - length;
			dy = -dy;
		}
		else
		{
			y += dy;
		}
	}
}