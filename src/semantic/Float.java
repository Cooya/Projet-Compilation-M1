package semantic;

public class Float extends SimpleType {

	public Float() {
		super();
	}
	
	public String toString() {
		return "Float";
	}
	
	public Object getInitialValue() {
		return 0.;
	}
	
	public int getSize() {
		return 8;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Float)
			return null;
		return new TypeDiff(this, otherType);
	}
}
