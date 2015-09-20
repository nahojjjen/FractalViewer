/**
 * Created by Johan on 2015-09-20.
 */
public class JuliaSet {

    public static int getEscapeTime(ImaginaryNumber imNum){

        for (int i = 0; i < 300 ; i++){
            if (imNum.calcAbsoluteValNoSqrt() > 4){
                return i;
            }
            else{

                imNum =  imNum.pow2();
                imNum = imNum.add(new ImaginaryNumber(-0.123, 0.745));
            }

        }

        return 0;
    }
}
