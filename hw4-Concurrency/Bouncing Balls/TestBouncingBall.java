import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TestBouncingBall
{
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Bouncing Ball");
		BallPanel panel = new BallPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(panel);

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(panel);
		
		executorService.shutdown();
	}
}