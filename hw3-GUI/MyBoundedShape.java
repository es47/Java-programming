import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape extends MyShape
{
	private boolean fill;
	
	public MyBoundedShape()
	{
		super();
		setFill(false);
	}
	
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean fill)
	{
		super(x1, y1, x2, y2, color);
		setFill(fill);
	}
	
	public void setFill(boolean fill)
	{
		this.fill = fill;
	}
	
	public boolean getFill()
	{
		return fill;
	}
	
	public int getUpperLeftX(int x1, int x2)
	{
		if (getX1() <= getX2())
			return x1;
		else
			return x2;
	}
	
	public int getUpperLeftY(int y1, int y2)
	{
		if (getY1() <= getY2())
			return y1;
		else
			return y2;
	}
	
	public int getWidth(int x1, int x2)
	{
		return (Math.abs(getX1() - getX2()));
	}
	
	public int getHeight(int y1, int y2)
	{
		return (Math.abs(getY1() - getY2()));
	}
	
	@Override
	public abstract void draw(Graphics g);
}