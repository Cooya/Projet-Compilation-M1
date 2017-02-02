package semantic;

public class Class extends Type {

	public Class(String name) {
		super(new TypeName(name), null);
	}

	public String toString() {
		return "Class " + getLeftChild().toString();
	}
	
	public Object getInitialValue() {
		return null;
	}

	public int getSize() {
		return 4;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Class)
			return this.getLeftChild().diff(otherType.getLeftChild());
		return new TypeDiff(this, otherType);
	}
}
