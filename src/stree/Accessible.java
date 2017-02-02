package stree;

import semantic.Symbol;
import semantic.Type;
import exceptions.IncompatibleTypeException;
import exceptions.InvalidArrayAccesException;
import exceptions.UnknownSymbolException;

public class Accessible extends Accessor {

	public Accessible(Name name, ArrayAccessor array) throws IncompatibleTypeException, InvalidArrayAccesException, UnknownSymbolException {
		super(Tag.ACCESSIBLE, name, array, getType(name.getValue(), array));
	}

	public Accessible(Name name) throws IncompatibleTypeException, InvalidArrayAccesException, UnknownSymbolException {
		super(Tag.ACCESSIBLE, name, getType(name.getValue(), null));
	}
	
	public Accessible(Pointer pointer, Accessible accessible) throws UnknownSymbolException { // association pointeur/accessible dans le parseur
		super(Tag.ACCESSIBLE, pointer, accessible, getType(pointer, accessible));
	}
	
	public Accessible(Tag tag, Name name, ArgumentsList list, Type type) {
		super(tag, name, list, type);
	}

	public Accessible(Tag tag, Name name, Void v, Type type) {
		super(tag, name, v, type);
	}
	
	public Accessible(Tag tag, Accessible accessible) { // constructeur pour l'accès à la référence d'une variable (&)
		super(tag, accessible, accessible.getType());
	}
	
	// construction du type pointeur(s) + accessible
	private static Type getType(Pointer p, Accessible accessible) throws UnknownSymbolException {
		if(accessible.getType() == null)
			throw new UnknownSymbolException("Cannot find symbol \"" + ((Name) accessible.getLeft()).getValue() + "\"");
		Type t = new semantic.Pointer(accessible.getType());
		while((p = (Pointer) p.getLeft()) != null)
			t = new semantic.Pointer(t);
		return t;
	}
	
	private static Type getType(String name, ArrayAccessor array) throws IncompatibleTypeException, InvalidArrayAccesException, UnknownSymbolException {
		Symbol s = stack.getSymbol(name);
		if(s == null) return null;
		if(array == null) return s.getType();
		Type t = s.getType().getLeftChild();
		if(t instanceof semantic.Pointer || t instanceof semantic.Listof || t instanceof semantic.Str)
			return diveIntoAccessor(t, array.getDepth());
		else
			throw new IncompatibleTypeException("Invalid type, " + t.toString() + " cannot be accessed with offset");
	}
	
	private static Type diveIntoAccessor(Type t, int depth) throws InvalidArrayAccesException {
		if(t == null)
			throw new InvalidArrayAccesException("Out of bound access");
		else if(t instanceof semantic.Str)
			if(depth > 1)
				throw new InvalidArrayAccesException("Invalid access to a string");
			else
				return new semantic.Character();
		else if(depth > 0)
			return diveIntoAccessor(t.getLeftChild(), depth - 1);
		else // depth == 0
			return t;
	}
}