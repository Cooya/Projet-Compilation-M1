package exceptions;

@SuppressWarnings("serial")
public class UnknownTypeException extends Exception {
	
	public UnknownTypeException(String msg) {
		super(msg);
	}
}
