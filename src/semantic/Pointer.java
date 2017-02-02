package semantic;

public class Pointer extends Type {

	public Pointer(Type lChild) {
		super(lChild, null);
	}

	public String toString() {
		return "^" + getLeftChild().toString();
	}
	
	public Object getInitialValue() {
		return null;
	}
	
	public int getSize() {
		return 4;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Pointer)
			return this.getLeftChild().diff(otherType.getLeftChild()); 
		return new TypeDiff(this, otherType);
	}
}

