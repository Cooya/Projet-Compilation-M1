package stree;

public class StatementsBlock extends Statement {

	public StatementsBlock(Statement statement) {
		super(Tag.BLOCK, statement);
	}
	
	public StatementsBlock(Statement statement1, Statement statement2) {
		super(Tag.BLOCK, statement1, statement2);
	}
	
	public StatementsBlock add(Statement s) {
		Stree rChild = getRight();
		if(rChild == null)
			setRight((Statement) s);
		else if(!(rChild instanceof StatementsBlock))
			setRight(new StatementsBlock((Statement) rChild, (Statement) s));
		else
			((StatementsBlock) rChild).add(s);
		return this;
	}
}
