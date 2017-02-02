package stree;

public class StaticAttribute extends VarDeclaration {

	public StaticAttribute(VarDeclaration declaration) {
		super(Tag.STATIC, declaration);
	}
}
