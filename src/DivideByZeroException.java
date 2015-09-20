/**
 * Created by Johan on 2015-09-20.
 */
public class DivideByZeroException extends Throwable {
    public DivideByZeroException(String s) {
        super("Attempting to divide by zero");
    }
}
