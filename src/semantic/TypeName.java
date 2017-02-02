package semantic;

public class TypeName extends Type {
	private String name;
	
	public TypeName(String name) {
		super(null, null);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public Object getInitialValue() {
		return '\0';
	}

	public int getSize() {
		return name.length();
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof TypeName && this.name == ((TypeName) otherType).getName())
			return null;
		return new TypeDiff(this, otherType);
	}
}
