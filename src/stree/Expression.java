package stree;

import semantic.Type;

public abstract class Expression extends Stree implements Typable {
	private Type type;
	
	public Expression(Tag tag, Expression l, Expression r, Type type) {
		super(tag, l, r);
		this.type = type;
	}
	
	public Expression(Tag tag, Expression l, Type type) { // classe ArrayIndex
		super(tag, l);
		this.type = type;
	}
	
	public Expression(Tag tag, Type type) { // classes de types simples et classe Name
		super(tag);
		this.type = type;
	}

	public Expression(Tag tag, Name name, ArgumentsList list, Type type) { // classe FunctionCall
		super(tag, name, list, type);
		this.type = type;
	}

	public Expression(Tag tag, Pointer pointer, Accessible accessible, Type type) { // classe Accessible
		super(tag, pointer, accessible, type);
		this.type = type;
	}

	public Expression(Tag tag, Name name, ArrayAccessor array, Type type) { // classe Accessible
		super(tag, name, array, type);
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}
}