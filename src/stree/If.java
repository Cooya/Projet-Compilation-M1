package stree;

public class If extends ConditionalStatement {
	
	public If(Expression exp, StatementsBlock block) {
		super(Tag.IF, exp, block);
	}
}