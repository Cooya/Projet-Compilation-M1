package semantic;

public class Character extends SimpleType {

	public Character() {
		super();
	}
	
	public String toString() {
		return "Character";
	}
	
	public Object getInitialValue() {
		return "'\\0'";
	}
	
	public int getSize() {
		return 1;
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Character)
			return null;
		return new TypeDiff(this, otherType);
	}
}
