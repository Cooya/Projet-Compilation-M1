package stree;

public class While extends Loop {
	
	public While(Expression exp, StatementsBlock block) {
		super(Tag.WHILE, exp, block);
	}
}
