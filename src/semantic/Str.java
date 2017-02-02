package semantic;

public class Str extends SimpleType {

	public Str() {
		super();
	}
	
	public String toString() {
		return "String";
	}
	
	public Object getInitialValue() {
		return null;
	}
	
	public int getSize() {
		return 4;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Str)
			return null;
		return new TypeDiff(this, otherType);
	}
}
