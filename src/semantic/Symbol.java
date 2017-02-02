package semantic;

public class Symbol {
	private String name;
	private Object value;
	private Type type;
	private int size;
	
	public Symbol(String name, Type type, Object value) {
		this.name = name;
		this.type = type;
		this.value = type.getInitialValue();
		this.size = type.getSize();
	}
	
	public boolean setValue(Object value) {
		if(this.value.getClass() != value.getClass())
			return false;
		else {
			this.value = value; 
			return true;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String getTypeAsString() {
		return this.type.toString();
	}
}
