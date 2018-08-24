import java.awt.Color;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

public class DrawPanel extends JPanel
{
	//private SecureRandom randomNumbers = new SecureRandom();
	private MyShape[] shapes;
	private int shapeCount;
	private int shapeType;
	private MyShape currentShape;
	private Color currentColor;
	private boolean filledShape;
	
	JLabel statusLabel;
	
	public DrawPanel(JLabel statusLabel)
	{
		this.statusLabel = statusLabel;
		shapes = new MyShape[100];
		shapeCount = 0;
		shapeType = 0;
		currentShape = null;
		currentColor = Color.BLACK;
		
		setBackground(Color.WHITE);
		
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(int count = 0; count < shapeCount; count++)
			shapes[count].draw(g);
		
		if (currentShape != null)
			currentShape.draw(g);
	}
	
	public void setShapeType(int shapeType)
	{
		this.shapeType = shapeType;
	}
	
	public void setCurrentColor(Color currentColor)
	{
		this.currentColor = currentColor;
	}
	
	public void setFilledShape(boolean filledShape)
	{
		this.filledShape = filledShape;
	}
	
	public void clearLastShape()
	{
		if (shapeCount > 0)
		{
			shapeCount--;
			repaint();
		}
	}
	
	public void clearDrawing()
	{
		shapeCount = 0;
		repaint();
	}
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener
	{
		@Override
		public void mousePressed(MouseEvent event)
		{
			if (shapeType == 0)
			{
				currentShape = new MyLine(event.getX(), event.getY(), event.getX(), event.getY(), currentColor);
			}
			else if (shapeType == 1)
			{
				currentShape = new MyRectangle(event.getX(), event.getY(), event.getX(), event.getY(), currentColor, filledShape);
			}
			else if (shapeType == 2)
			{
				currentShape = new MyOval(event.getX(), event.getY(), event.getX(), event.getY(), currentColor, filledShape);
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent event)
		{
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
			
			shapes[shapeCount] = currentShape;
			shapeCount++;
			currentShape = null;
			
			repaint();
		}
		
		@Override
		public void mouseMoved(MouseEvent event)
		{
			statusLabel.setText(String.format("(%d, %d)", event.getX(), event.getY()));
		}
		
		@Override
		public void mouseDragged(MouseEvent event)
		{
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
			
			repaint();
			statusLabel.setText(String.format("(%d, %d)", event.getX(), event.getY()));
		}
	}
}