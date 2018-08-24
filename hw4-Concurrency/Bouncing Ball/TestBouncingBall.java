import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;


public class TestBouncingBall
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Bouncing Ball");
		BouncingBall ball = new BouncingBall(2, 3);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(ball, BorderLayout.CENTER);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		frame.addMouseListener( new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent event)
			{
				executorService.execute(ball);
				
				executorService.shutdown();
			}
		} );
	}
}