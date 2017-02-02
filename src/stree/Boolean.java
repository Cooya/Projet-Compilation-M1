package stree;

public class Boolean extends Identifier {
	private boolean value;
	
	public Boolean(Object o) {
		super(Tag.BOOL, new semantic.Boolean());
		this.value = java.lang.Boolean.parseBoolean(o.toString());
	}
	
	public boolean getValue() {
		return this.value;
	}
}
