package stree;

public class FunctionDefinition extends Definition {
	
	public FunctionDefinition(Prototype proto, StatementsBlock block) {
		super(Tag.FUNCDEF, proto, block);
	}
}