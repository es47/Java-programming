import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape
{
	private boolean fill;
	
	public MyOval()
	{
		super();
	}
	
	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean fill)
	{
		super(x1, y1, x2, y2, color, fill);
	}

	public void draw(Graphics g)
	{
		g.setColor(getColor());
		
		if (getFill() == true)
			g.fillOval(getUpperLeftX(getX1(), getX2()), getUpperLeftY(getY1(), getY2()), getWidth(getX1(), getX2()), getHeight(getY1(), getY2()));
		else
			g.drawOval(getUpperLeftX(getX1(), getX2()), getUpperLeftY(getY1(), getY2()), getWidth(getX1(), getX2()), getHeight(getY1(), getY2()));
	}
}