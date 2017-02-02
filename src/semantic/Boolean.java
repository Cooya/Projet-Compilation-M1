package semantic;

public class Boolean extends SimpleType {

	public Boolean() {
		super();
	}
	
	public String toString() {
		return "Boolean";
	}
	
	public Object getInitialValue() {
		return false;
	}
	
	public int getSize() {
		return 1;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Boolean)
			return null;
		return new TypeDiff(this, otherType);
	}
}

