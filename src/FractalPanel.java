import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * A program to view fractals in a 2d plane.
 * 
 * @author Johan Swanberg
 *
 */
public class FractalPanel extends JPanel {

	private static int width;
	private static int height;
	private static ImaginaryNumber imNum = new ImaginaryNumber();
	private static int escapeTime = 0;
	// smaller number, more zoomed in
	private static double magnification = 401;
	private double xOfset = 0;
	private double yOfset = 0;
	private static int mode = 0;

	/**
	 * Paint the fractal in the panel
	 */
	public void paintComponent(Graphics g) {

		long startTime = System.currentTimeMillis();
		width = this.getWidth();
		height = this.getHeight();

		for (int x = 0; x <= width; x++) { //go 
			if (x == width/2){
				System.out.println("halfway there, half time: " + (System.currentTimeMillis() - startTime));
			}
			for (int y = 0; y <= height; y++) {
				// varje pixel ger ett värde till ett imaginärt nummer.
				imNum = new ImaginaryNumber((double) (x - (width / 2) + xOfset)	/ magnification, 
						(double) (y - (height / 2) + yOfset)/ magnification);

				switch(mode){
				//case 0: escapeTime = MandelbrotSet.getEscapeTime(imNum);
				//break;
				case 1:  escapeTime = JuliaSet.getEscapeTime(imNum);
				break;
				//case 2:  escapeTime = GenericSet.getEscapeTime(imNum);
				//break;
				}

				pickColor(g, escapeTime);
				colorPixel(x, y, escapeTime, g);
			}
		}
		long passedTime = System.currentTimeMillis() - startTime;
		System.out.println(passedTime + " milisekunder");
	}

	/**
	 * draw a pixel on the panel
	 * 
	 * @param x
	 *            what x coordinate to draw on
	 * @param y
	 *            what y coordinate to draw on
	 * @param g
	 *            what graphics object to draw on
	 */
	private void colorPixel(int x, int y, int color, Graphics g) {
		g.drawLine(x, y, x, y);
	}


	/**
	 * Pick a color to draw depending on an int value
	 * 
	 * @param g
	 *            whast graphics object brush to change color on
	 * @param color
	 *            the int that will represent a color
	 */
	public void pickColor(Graphics g, int color) {
		// alltid svart om escapetime > iteration
		// ljusblå om snabb escapetime, mörkblå om det tar längre tid
		if (color == 0) {
			g.setColor(new Color(0, 0, 0));
		} else {

			if (color > 255) {
				color = 255;
			}
			// g.setColor(new Color((int)Math.sqrt(color)*15 , 255, 255));
			g.setColor(new Color(255 - (int) (Math.sqrt(color) * 15), 255, 255));
			// g.setColor(new Color((int)(Math.sqrt(color)*15) , 0, 0) );
			// g.setColor(new Color((color) , 0, 0) );
		}

	}


	/**
	 * cycle the window to show the next fractal
	 */
	public static void nextMode(){
		mode = (mode +1)%3;
		
		switch(mode){
		case 0: 
			System.out.println("Mandelbrot");
		break;
		case 1:  
		System.out.println("Julia");
		break;
		case 2: 
			System.out.println("User");
		break;
		}

	}

	/**
	 * get the magnification level in the window
	 * @return what level of magnification the fractalpanel has
	 */
	public static double getMag() {
		return magnification;
	}

	/**
	 * set the magnificationlevel
	 * @param d
	 *            what to set the mag level to
	 */
	public static void setMag(double d) {
		magnification = d;
		System.out.println("Magnification divider = " + magnification);
	}

}
