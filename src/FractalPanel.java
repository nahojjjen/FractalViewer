import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * A program to view fractals in a 2d plane.
 * @author Johan Swanberg
 *
 */
public class FractalPanel extends JPanel{
	
	private static int width;
	private static int height;
	private static ImaginaryNumber imNum = new ImaginaryNumber();
	private static int escapeTime = 0; 
	//smaller number, more zoomed  in
	private static double magnification = 420;
	
	public void paintComponent (Graphics g){
		long startTime = System.currentTimeMillis();
		width  = this.getWidth();
		height = this.getHeight();

		for (int i = 1; i<width;i++){
			for (int j = 1; j<height; j++){
				//varje pixel ger ett värde till ett imaginärt nummer.
				imNum = new ImaginaryNumber((double)(j-height/2)/magnification ,(double)(i-width/2)/magnification);
				escapeTime = imNum.calcJuliaEscapeTime(); //går att ersätta med annat än julia

				if (escapeTime==0){
					g.setColor(new Color( 0, 0, 0));
				}
				else{
					g.setColor(new Color(255-escapeTime  , 255, 255));
				}
				g.drawLine(i, j, i, j);
			}
		}
		long passedTime = System.currentTimeMillis() - startTime;
		System.out.println(passedTime + " milisekunder");
	}
	
	public static ImaginaryNumber getIm(){
		return imNum;
		
	}
}
