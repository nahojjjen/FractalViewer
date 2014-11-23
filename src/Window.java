import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Window {
	private static JFrame frame = new JFrame();
	private static FractalPanel panel = new FractalPanel();
	private static int width =400;
	private static int height = 400;

	private static JFrame optionsFrame = new JFrame();
	private static JButton magnificationPlus = new JButton("zoom in");
	private static JButton magnificationMinus = new JButton("zoom out");
	private static JButton constantPlus = new JButton("constant +");
	private static JButton constantMinus = new JButton("constant -");
	private static JButton constantIPlus = new JButton("I constant +");
	private static JButton constantIMinus = new JButton("I constant -");

	/**
	 * Initialize the program
	 * @param args unused.
	 */
	public static void main(String[] args) {
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		optionsFrame.setSize(500, 500);
		optionsFrame.setLayout( new GridLayout(3,2));
		optionsFrame.add(magnificationPlus);
		optionsFrame.add(magnificationMinus);
		optionsFrame.add(constantPlus);
		optionsFrame.add(constantMinus);
		optionsFrame.add(constantIPlus);
		optionsFrame.add(constantIMinus);
		
		ButtonListener listener = new ButtonListener();
		constantPlus.addActionListener(listener);
		constantMinus.addActionListener(listener);
		constantIPlus.addActionListener(listener);
		constantIMinus.addActionListener(listener);
		magnificationMinus.addActionListener(listener);
		magnificationPlus.addActionListener(listener);


		optionsFrame.setLocationRelativeTo(null);
		optionsFrame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == constantPlus){
				ImaginaryNumber k = FractalPanel.getIm();
				k.setC(k.getC()+0.01);
				panel.repaint();
			}
			else if (e.getSource() == constantMinus){
				ImaginaryNumber k = FractalPanel.getIm();
				k.setC(k.getC()-0.01);
				panel.repaint();
			}
			if (e.getSource() == constantIPlus){
				ImaginaryNumber k = FractalPanel.getIm();
				k.setCI(k.getCI()+0.01);
				panel.repaint();
			}
			else if (e.getSource() == constantIMinus){
				ImaginaryNumber k = FractalPanel.getIm();
				k.setCI(k.getCI()-0.01);
				panel.repaint();
			}

			else if (e.getSource() == magnificationMinus){
				ImaginaryNumber k = FractalPanel.getIm();
				FractalPanel.setMag(FractalPanel.getMag() - 100);
				panel.repaint();
			}
			else if (e.getSource() == magnificationPlus){
				ImaginaryNumber k = FractalPanel.getIm();
				FractalPanel.setMag(FractalPanel.getMag() + 100);
				panel.repaint();
			}
		}


	}
}