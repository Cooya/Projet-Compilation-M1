package semantic;

public class Integer extends SimpleType {

	public Integer() {
		super();
	}
	
	public String toString() {
		return "Integer";
	}
	
	public Object getInitialValue() {
		return 0;
	}
	
	public int getSize() {
		return 4;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Integer)
			return null;
		return new TypeDiff(this, otherType);
	}
}
