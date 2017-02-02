package stree;

public class FunctionParameters extends Stree {

	public FunctionParameters(ParametersList list, ReturnType type) {
		super(Tag.FUNCPARAMS, list, type);
	}
	
	public FunctionParameters(ReturnType type) {
		super(Tag.FUNCPARAMS, new Void(), type);
	}
	
	public FunctionParameters(ParametersList list) {
		super(Tag.FUNCPARAMS, list, new Void());
	}
	
	public FunctionParameters() {
		super(Tag.FUNCPARAMS, new Void(), new Void());
	}

	public FunctionParameters(Tag tag, TypeSpecifier type) {
		super(tag, type);
	}

	public FunctionParameters(Tag tag, Name name, TypeSpecifier type) {
		super(tag, name, type);
	}
}
