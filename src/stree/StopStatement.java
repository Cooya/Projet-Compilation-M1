package stree;

public class StopStatement extends Statement {

	public StopStatement(Tag tag, Expression exp) {
		super(tag, exp);
	}
	
	public StopStatement(Tag tag) {
		super(tag);
	}
}
