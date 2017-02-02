package stree;

public class TypeDeclaration extends Definition {
	
	public TypeDeclaration(Name name, TypeSpecifier type) {
		super(Tag.TYPE, name, type);
	}
}
