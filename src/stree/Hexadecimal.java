package stree;

public class Hexadecimal extends Identifier {
	private char value;
	
	public Hexadecimal(Object o) {
		super(Tag.HEXA, new semantic.Character());
		this.value = o.toString().charAt(0);
	}
	
	public char getValue() {
		return this.value;
	}
}
