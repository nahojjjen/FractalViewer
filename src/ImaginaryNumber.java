
public class ImaginaryNumber {

	private double real = 0;
	private double imaginary = 0;

	private static int iterationCount = 255;
	private static double c = 0.2517; //2732
	private static double ci = 0.3817; //2732

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////    Methods               /////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * calculates the absolute value of an imaginary number
	 * @param n what imaginary number to test
	 * @return the absolute value of n
	 */
	public double calcAbsoluteVal(){
		//absolutvärde på komplext tal = sqrt(a^2 + b^2) : a är rationell del  och b är imaginär del
		return Math.sqrt( (this.getReal() * this.getReal()) + (this.getImaginary() * this.getImaginary()) );
	}


	/**
	 * Calculates how many iterations it takes for an imaginary number to escape the julia set
	 * @param this what imaginary number to test
	 * @return the amount of iterations, returns 0 if result would be over iterationCount.
	 */
	public int calcJuliaEscapeTime(){
		int counter = 0;
		//julia = z(n+1) = Zn^2 + C

		for (int i = 0; i<iterationCount; i++){
			
			if (this.calcAbsoluteVal() > 2){
				return counter;
			}
			this.pow2();
			this.add(new ImaginaryNumber(c,ci));
			counter++;

		}
		return 0;
	}
	
	
	/**
	 * raise the imaginary number to the power of 2
	 */
	public void pow2(){
		//(komplext tal)^2 + konstant
		double tmpReal= this.getReal();
		double tmpIm = this.getImaginary();
		
		this.setReal( (tmpReal*tmpReal) - (tmpIm*tmpIm));
		this.setImaginary(2*(tmpReal*tmpIm));

	}
	
	/**
	 * add an imaginary numer to another
	 * @param oth what other imaginary number to add
	 * @return the new imaginary number
	 */
	public void add(ImaginaryNumber oth){
		ImaginaryNumber ret = new ImaginaryNumber();
		
		this.setImaginary(this.getImaginary() + oth.getImaginary());
		this.setReal(this.getReal()+oth.getReal());
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////// Constructons, getter & setters  ///////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * default constructor 
	 */
	public ImaginaryNumber(){
		this.real = 0;
		this.imaginary = 0;
	}
	/**
	 * constructor
	 * @param a real part of imaginary number
	 * @param i imaginary part of imaginary number
	 */
	public ImaginaryNumber(double a, double i){
		this.real = a;
		this.imaginary = i;
	}

	public double getReal(){return this.real;}
	public double getImaginary(){return this.imaginary;}
	public double getC(){return this.c;}
	public double getCI(){return this.ci;}

	public void setReal(Double d){this.real = d;}
	public void setImaginary(Double d){this.imaginary = d;}
	public void setC(Double d){this.c = d;}
	public void setCI(Double d){this.ci = d;}

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////  teori     //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//regler för imaginära tal
//(x+yi)(u+vi) = (xu - yv) + (xv + yu)i
//(x+yi)(x+yi) = (xx - yy) + (xy + yx)i 	-komplext tal ^2

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

