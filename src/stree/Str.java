package stree;

public class Str extends Identifier {
	private String value;
	
	public Str(Object o) {
		super(Tag.STRING, new semantic.Str());
		this.value = o.toString();
	}
	
	public String getValue() {
		return this.value;
	}
}