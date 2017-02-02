package exceptions;

@SuppressWarnings("serial")
public class UnknownStructureFieldException extends Exception {
	
	public UnknownStructureFieldException(String msg) {
		super(msg);
	}
}
