package semantic;

public class Listof extends Type {

	public Listof(Type lChild) {
		super(lChild, null);
	}

	public String toString() {
		return "Listof " + getLeftChild().toString();
	}
	
	public Object getInitialValue() {
		return null;
	}
	
	public int getSize() {
		return 4;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Listof)
			return this.getLeftChild().diff(otherType.getLeftChild());
		return new TypeDiff(this, otherType);
	}
}
