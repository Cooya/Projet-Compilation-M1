package stree;

import semantic.Type;

public abstract class Identifier extends Expression implements Typable {
	private Type type;
	
	public Identifier(Tag tag, Type type) { // classes de types simples et classe Name
		super(tag, type);
		this.type = type;
	}
	
	public Identifier(Tag tag, Identifier id, Type type) { // classe ArrayIndex et Accessible
		super(tag, id, type);
		this.type = type;
	}
	
	public Identifier(Tag tag, Identifier i1, Identifier i2, Type type) { // classes AccessorOperation et FunctionCall
		super(tag, i1, i2, type);
		this.type = type;
	}

	public Identifier(Tag tag, Name name, ArgumentsList list, Type type) { // classe FunctionCall
		super(tag, name, list, type);
		this.type = type;
	}
	
	public Identifier(Tag tag, Pointer pointer, Accessible accessible, Type type) { // classe Accessible
		super(tag, pointer, accessible, type);
		this.type = type;
	}
	
	public Identifier(Tag tag, Name name, ArrayAccessor array, Type type) { // classe Accessible
		super(tag, name, array, type);
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}
	
	/*
	public Identifier(Tag tag, Pointer p, Type type) { // classe Pointer
		super(tag, p, type);
		this.type = type;
	}
	
	public Identifier(Tag tag, ArrayAccessor array, ArrayIndex index) { // classe ArrayAccessor
		super(tag, array, index, null); // pas de type
		this.type = null;
	}
	*/
}
