package stree;

import semantic.Symbol;
import semantic.Type;

public class Name extends Identifier {
	private String value;
	
	public Name(String value) {
		super(Tag.NAME, getType(value));
		this.value = value;
	}
	
	public Name() {
		super(Tag.NAME, null);
	}
	
	public String getValue() {
		return this.value;
	}
	
	private static Type getType(String name) {
		Symbol s = stack.getSymbol(name);
		if(s == null) return null;
		return s.getType();
	}
} 