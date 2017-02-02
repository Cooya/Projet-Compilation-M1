package semantic;

public class Typedef extends Type {

	public Typedef(String name) {
		super(new TypeName(name), null);
	}

	public String toString() {
		return "Typedef " + getLeftChild().toString();
	}
	
	public Object getInitialValue() {
		return null;
	}

	public int getSize() {
		return 0;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Typedef)
			return this.getLeftChild().diff(otherType.getLeftChild());
		return new TypeDiff(this, otherType);
	}
}