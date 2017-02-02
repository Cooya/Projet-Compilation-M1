package exceptions;

@SuppressWarnings("serial")
public class UnknownSymbolException extends Exception {
	
	public UnknownSymbolException(String msg) {
		super(msg);
	}
}
