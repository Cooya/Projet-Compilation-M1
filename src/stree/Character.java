package stree;

public class Character extends Identifier {
	private char value;
	
	public Character(Object o) {
		super(Tag.CHARACTER, new semantic.Character());
		this.value = o.toString().charAt(0);
	}
	
	public char getValue() {
		return this.value;
	}
}
