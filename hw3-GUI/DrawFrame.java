import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;

public class DrawFrame extends JFrame
{
	private final JLabel statusLabel;
	private DrawPanel panel;
	
	private final JButton undo;
	private final JButton clear;
	
	private final JComboBox<String> colorComboBox;
	private final JComboBox<String> shapeComboBox;
	private final JCheckBox fillCheckBox;
	
	private static final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
	private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	private static final String[] shapeNames = {"Line", "Rectangle", "Oval"};
	
	private final JPanel buttonJPanel;
	
	public DrawFrame()
	{
		super("Java Drawings");
		
		statusLabel = new JLabel("");
		
		panel = new DrawPanel(statusLabel);
		
		undo = new JButton("Undo");
		clear = new JButton("Clear");
		
		colorComboBox = new JComboBox<String>(colorNames);
		colorComboBox.setMaximumRowCount(5);
		shapeComboBox = new JComboBox<String>(shapeNames);
		colorComboBox.setMaximumRowCount(3);
		fillCheckBox = new JCheckBox("Filled");
		
		buttonJPanel = new JPanel();
		buttonJPanel.setLayout(new GridLayout(1, 5));
		
		buttonJPanel.add(undo);
		buttonJPanel.add(clear);
		buttonJPanel.add(colorComboBox);
		buttonJPanel.add(shapeComboBox);
		buttonJPanel.add(fillCheckBox);
		
		add(buttonJPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
		
		ButtonHandler buttonHandler = new ButtonHandler();
		undo.addActionListener(buttonHandler);
		clear.addActionListener(buttonHandler);
		
		ItemListenerHandler handler = new ItemListenerHandler();
		colorComboBox.addItemListener(handler);
		shapeComboBox.addItemListener(handler);
		fillCheckBox.addItemListener(handler);
	}
	
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == undo)
			{
				panel.clearLastShape();
			}
			else
			{
				panel.clearDrawing();
			}
		}
	}
	
	private class ItemListenerHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event)
		{
			if (event.getItem() == fillCheckBox)
			{
				if (fillCheckBox.isSelected())
					panel.setFilledShape(true);
				else
					panel.setFilledShape(false);
			}
			
			if (event.getSource() == colorComboBox)
			{
				if (event.getStateChange() == ItemEvent.SELECTED)
					panel.setCurrentColor(colors[colorComboBox.getSelectedIndex()]);
			}
			
			if (event.getSource() == shapeComboBox)
			{
				if (event.getStateChange() == ItemEvent.SELECTED)
					panel.setShapeType(shapeComboBox.getSelectedIndex());
			}
		}
	}
}
