package stree;

import semantic.Type;

public class Parameter extends FunctionParameters implements Typable {
	private Type type;
	
	public Parameter(Name name, TypeSpecifier type) {
		super(Tag.PARAM, name, type);
		this.type = type.getType();
	}
	
	public Type getType() {
		return this.type;
	}
}
