import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Window {
	private static JFrame frame = new JFrame("Fractal Viewer");
	
	private static JPanel rootView = new JPanel();
	private static JPanel optionsView = new JPanel();
	private static FractalPanel panel = new FractalPanel();
	private static int width = 400;
	private static int height = 400;

	private static JButton magnificationPlus = new JButton("in");
	private static JButton magnificationMinus = new JButton("out");
	private static JTextField inputField = new JTextField("C^3+0C+0.1+.1+4");
	private static JButton switchMode = new JButton("S");

	/**
	 * Initialize the program
	 * @param args unused.
	 */
	public static void main(String[] args) {
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		rootView.setLayout(new BorderLayout(2,1));
		rootView.add(optionsView);
		rootView.add(panel);
		frame.add(rootView);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//optionsView.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
		optionsView.setSize(new Dimension(width,60));
		optionsView.setLayout( new GridLayout(1,8));
		optionsView.add(magnificationPlus);
		optionsView.add(magnificationMinus);
		optionsView.add(switchMode);
		
		ButtonListener listener = new ButtonListener();
		switchMode.addActionListener(listener);
		magnificationMinus.addActionListener(listener);
		magnificationPlus.addActionListener(listener);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == switchMode){
				FractalPanel.nextMode();
				panel.repaint();
			}

			else if (e.getSource() == magnificationMinus){
				FractalPanel.setMag(FractalPanel.getMag() - 100);
				panel.repaint();
			}
			else if (e.getSource() == magnificationPlus){
				FractalPanel.setMag(FractalPanel.getMag() + 100);
				panel.repaint();
			}
		}


	}
}