package stree;

import semantic.Type;

public class Number extends Identifier {
	private float value;
	private Type type;
	
	public Number(Object number) {
		super(Tag.NB, getType(number));
		this.type = getType(number); // pas le choix...
		this.value = Float.parseFloat(number.toString());
	}
	
	public float getValue() {
		return this.value;
	}
	
	private static Type getType(Object number) {
		String str = number.toString();
		int length = str.length();
		for(int i = 0; i < length; ++i)
			if(str.charAt(i) == '.')
				return new semantic.Float();
		return new semantic.Integer();
	}
	
	public Type getType() {
		return this.type;
	}
}
