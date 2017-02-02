package semantic;

public class Void extends Type {
	
	public Void() {
		super(null, null);
	}

	public String toString() {
		return "Void";
	}

	public Object getInitialValue() {
		return null;
	}

	public int getSize() {
		return 0;
	}

	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Void)
			return null;
		return new TypeDiff(this, otherType);
	}
}
