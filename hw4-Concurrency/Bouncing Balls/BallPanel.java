import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.security.SecureRandom;

public class BallPanel extends JPanel implements Runnable
{
	List<BouncingBall> balls = new ArrayList<BouncingBall>(30);
	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime;
	
	public BallPanel()
	{
		setBackground(Color.WHITE);
		
		sleepTime = generator.nextInt(10);
		
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener
	{
		@Override
		public void mousePressed(MouseEvent event)
		{
			BouncingBall ball = new BouncingBall(getWidth(), getHeight());

			balls.add(ball);
		}
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
			
			for (BouncingBall bb : balls)
				bb.ballMove(getWidth(), getHeight());
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (BouncingBall bb : balls)
		{
			g.setColor(bb.getColor());
			g.fillOval(bb.getX(), bb.getY(), bb.getLength(), bb.getLength());
		}
	}
}
