package stree;

import semantic.Type;

public class VarDeclaration extends Definition {
	private String name;
	private Type type;
	
	public VarDeclaration(Name name, TypeSpecifier type) {
		super(Tag.VARDEC, name, type);
		this.name = name.getValue();
		this.type = type.getType();
	}
	
	public VarDeclaration(Tag tag, VarDeclaration declaration) {
		super(tag, declaration);
	}

	public String getName() {
		return this.name;
	}
	
	public Type getType() {
		return this.type;
	}
}