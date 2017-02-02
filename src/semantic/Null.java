package semantic;

public class Null extends Type {
	
	public Null() {
		super(null, null);
	}

	public String toString() {
		return "Null";
	}

	public Object getInitialValue() {
		return null;
	}

	public int getSize() {
		return 0;
	}

	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Null)
			return null;
		return new TypeDiff(this, otherType);
	}
}
