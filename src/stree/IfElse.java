package stree;

public class IfElse extends ConditionalStatement {
	
	public IfElse(If block1, StatementsBlock block2) {
		super(Tag.IFELSE, block1, new Else(block2));
	}
}