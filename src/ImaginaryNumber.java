
public class ImaginaryNumber {

	private double real = 0;
	private double imaginary = 0;


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////    Methods               /////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * {@inheritDoc}
	 * Variables that are hashed are the imaginary and real part of the number.
	 */
	@Override
	public int hashCode(){
		return ((int)(this.getImaginary()*53)*100000) + (int)((this.getReal()*97)*10000);
	}

	@Override
	/**
	 * {@inheritDoc}
	 * compare two imaginary numbers, returns true if the real and imaginary parts of the 
	 * number has the same value. Example, 2+3i and 2+3i returns true, 5+2i and 6+2i returns false.
	 */
	public boolean equals(Object other){
		if (this == other){
			return true;
		}
		if (other == null){
			return false;
		}
		if (this.getClass() != other.getClass()){
			return false;
		}
		ImaginaryNumber otherIm = (ImaginaryNumber)other;
		if (this.hashCode() == other.hashCode()){
			return true;
		}
		return false;

	}

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
	 * slightly faster way of getting absolute val, make sure to check escapetime^2
	 * @return absolute val of imaginary number^2
	 */
	public double calcAbsoluteValNoSqrt(){
		return (this.getReal() * this.getReal()) + (this.getImaginary() * this.getImaginary());
	}

	/**
	 * raise the imaginary number to the power of 2
	 */
	public ImaginaryNumber pow2(){

		ImaginaryNumber returner = new ImaginaryNumber();
		returner.setReal( (this.getReal()*this.getReal()) - (this.getImaginary()*this.getImaginary()));
		returner.setImaginary(2*(this.getReal()*this.getReal()));

		return returner;
	}

	public ImaginaryNumber pow(int powerOf){

		ImaginaryNumber returner = new ImaginaryNumber();
		for (int i = 0; i < powerOf; i++){
			returner.setReal( (this.getReal()*this.getReal()) - (this.getImaginary()*this.getImaginary()));
			returner.setImaginary(2*(this.getReal()*this.getReal()));
		}
		return returner;
	}

	//(x+yi)(u+vi) = (xu - yv) + (xv + yu)i
	/**
	 * Multiply this imnum with another, overrides the value of this imnum with the results.
	 * @param n example: x.multiplyWith(n) does x*n and stores the result in x.
	 */
	public ImaginaryNumber multipyWith(ImaginaryNumber n){
		ImaginaryNumber returner = new ImaginaryNumber();

		returner.setReal( (this.getReal()*n.getReal() - this.getImaginary()*n.getImaginary()) );
		returner.setImaginary( (this.getReal()*n.getImaginary() + this.getImaginary()*n.getReal()) );
		return returner;
	}

	/**
	 * add an imaginary number to another
	 * @param oth what other imaginary number to add
	 * @return the new imaginary number
	 */
	public ImaginaryNumber add(ImaginaryNumber oth){
		ImaginaryNumber returner = new ImaginaryNumber();
		returner.setImaginary(this.getImaginary() + oth.getImaginary());
		returner.setReal(this.getReal()+oth.getReal());
		//debugg :System.out.println(this.toString() + ") + (" + oth.toString() + ") = (" + returner.toString() );
		return returner;
	}

	/**
	 * subtract an imaginary number with another
	 * @param oth x - oth = new x. where x was the old imaginary number
	 */
	public ImaginaryNumber sub(ImaginaryNumber oth){
		ImaginaryNumber returner = new ImaginaryNumber();
		returner.setImaginary((this.getImaginary() - oth.getImaginary()));
		returner.setReal(this.getReal() - oth.getReal());
		return returner;
	}
	
	/**
	 *{@inheritDoc}
	 *returns ImaginaryNumber to string in the format "of a + bi" 
	 */
	@Override
	public String toString(){
		return String.valueOf(this.getReal()) + " + "+ String.valueOf(this.getImaginary() + "i");
	}
	
	//!/!/!/!/!//!!/!/! funkar ej, error out of bounds, //TODO
	/**
	 * Method to get imaginary number to string, but with the numbers rounded to closest 4 decimals
	 * @return
	 */
	public String toShortString(){
		return (String.valueOf(this.getReal())).substring(0, 7) + " + "+ (String.valueOf(this.getImaginary()).substring(0, 7) + "i");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////// Constructons, getter & setters  ///////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * default constructor , creates a new imnum = 0 + 0i
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

	/**
	 * Clone constructor, creates a new imnum with the same values as params
	 * @param otherIm what imaginary number to clone.
	 */
	public ImaginaryNumber(ImaginaryNumber otherIm){
		this.real = otherIm.getImaginary();
		this.imaginary = otherIm.getImaginary();
	}

	public double getReal(){return this.real;}
	public double getImaginary(){return this.imaginary;}

	public void setReal(Double d){this.real = d;}
	public void setImaginary(Double d){this.imaginary = d;}


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

