package exceptions;

@SuppressWarnings("serial")
public class InvalidFunctionCallArguments extends Exception {

	public InvalidFunctionCallArguments(String msg) {
		super(msg);
	}
}
