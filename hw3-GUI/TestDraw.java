import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class TestDraw
{
	public static void main(String[] args)
	{
		DrawFrame frame = new DrawFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}