package stree;

import semantic.Type;

public abstract class Accessor extends Identifier implements Typable {

	public Accessor(Tag tag, Accessible accessible, Type type) { // classe ArrayIndex
		super(tag, accessible, type);
	}
	
	public Accessor(Tag tag, Number nb, Type type) { // classe ArrayIndex
		super(tag, nb, type);
	}
	
	public Accessor(Tag tag, Accessor a1, Accessor a2, Type type) { // classe AccessorOperation
		super(tag, a1, a2, type);
	}
	
	public Accessor(Tag tag, Pointer pointer, Accessible accessible, Type type) { // classe Accessible
		super(tag, pointer, accessible, type);
	}

	public Accessor(Tag tag, Name name, ArrayAccessor array, Type type) { // classe Accessible
		super(tag, name, array, type);
	}

	public Accessor(Tag tag, Name name, Type type) { // classe Accessible
		super(tag, name, type);
	}
	
	public Accessor(Tag tag, Name name, ArgumentsList list, Type type) { // classe FunctionCall (Accessible)
		super(tag, name, list, type);
	}

	public Accessor(Tag tag, Name name, Void v, Type type) { // classe FunctionCall (Accessible)
		super(tag, name, v, type);
	}
	
	/*
	public Accessor(Tag tag, ArrayAccessor array, ArrayIndex index) { // classe ArrayAccessor
		super(tag, array, index); // pas de type
	}

	public Accessor(Tag tag, ArrayIndex index) { // classe ArrayAccessor
		this(tag, (ArrayAccessor) null, index); // pas de type
	}
	
	public Accessor(Tag tag, Type type) { // classe Pointer
		super(tag, type);
	}

	public Accessor(Tag tag, Pointer p, Type type) { // classe Pointer
		super(tag, p, type); 
	}
	*/
}
