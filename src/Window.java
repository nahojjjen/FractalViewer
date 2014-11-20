import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window {
	private static JFrame frame = new JFrame();
	private static FractalPanel panel = new FractalPanel();
	private static int width = 3000;
	private static int height = 1600;
	private static int iterationCount = 250;
	private static ImaginaryNumber imNum = new ImaginaryNumber();
	private static int escapeTime = 0; 
	//smaller number, more zoomed  in
	private static double zoomLevel = 0.002;
	

	/**
	 * Initialize the program
	 * @param args unused.
	 */
	public static void main(String[] args) {
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.setVisible(true);
	}

	/**
	 * A program to view fractals in a 2d plane.
	 * @author Johan Swanberg
	 *
	 */
	private static class FractalPanel extends JPanel{
		public void paintComponent (Graphics g){
			for (int i = 1; i<width;i++){
				for (int j = 1; j<height; j++){

					imNum.setImaginary((double)(i-width/2)*zoomLevel);
					imNum.setReal((double)(j-height/2)*zoomLevel);

					escapeTime = calcJuliaEscapeTime(imNum);
					if (escapeTime==0){
						g.setColor(new Color( 0, 0, 0));
					}
					else{
						g.setColor(new Color(255-escapeTime  , 255, 255));
					}
					g.drawLine(i, j, i, j);
					//	System.out.println("i: " + i + " ... j: " + j + "   escapeTime: " + escapeTime);
				}
			}
		}
	}

	/**
	 * Calculates how many iterations it takes for an imaginary number to escape the julia set
	 * @param num what imaginary number to test
	 * @return the amount of iterations, returns 0 if result would be over iterationCount.
	 */
	public static int calcJuliaEscapeTime(ImaginaryNumber num){
		int counter = 0;
		//julia = z(n+1) = Zn^2 + C
		//(x+yi)(u+vi) = (xu - yv) + (xv + yu)i
		//(x+yi)(x+yi) = (xx - yy) + (xy + yx)i 	-komplext tal ^2
		double c = 0.2732; //konstant som läggs på

		for (int i = 0; i<iterationCount; i++){
			//			System.out.println("before: imgnum real: " + num.getReal());
			//			System.out.println("before: imgnum imagi: " + num.getImaginary());

			//komplext tal ^2 (+ konstant)
			num.setReal((num.getReal()*num.getReal()) - (num.getImaginary() *num.getImaginary()) + c);
			num.setImaginary((num.getReal()*num.getImaginary()) + (num.getReal()*num.getImaginary()));
			counter++;

			//			System.out.println("after: imgnum real: " + num.getReal());
			//			System.out.println("after: imgnum imagi: " + num.getImaginary());

			if (calcAbsoluteVal(num) > 2){
				return counter;
			}
		}
		return 0;

	}

	/**
	 * calculates the absolute value of an imaginary number
	 * @param n what imaginary number to test
	 * @return the absolute value of n
	 */
	public static double calcAbsoluteVal(ImaginaryNumber n){
		//absolutvärde på komplext tal = sqrt(a^2 + b^2) : a är rationell del  och b är imaginär del
		return Math.sqrt( (n.getReal() * n.getReal()) + (n.getImaginary() * n.getImaginary()) );

	}

	private static class ImaginaryNumber{
		private double real = 0;
		private double imaginary = 0;

		/**
		 * default constructor 
		 */
		public ImaginaryNumber(){
			this.real = 0;
			this.imaginary = 0;
		}

		public ImaginaryNumber(double a, double i){
			this.real = a;
			this.imaginary = i;
		}


		public double getReal(){
			return this.real;
		}
		public double getImaginary(){
			return this.imaginary;
		}

		public void setReal(Double d){
			this.real = d;
		}
		public void setImaginary(Double d){
			this.imaginary = d;
		}
	}

}
