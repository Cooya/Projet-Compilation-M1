package stree;

import semantic.Type;
import exceptions.InvalidArrayAccesException;
import exceptions.UnknownSymbolException;

public class ArrayIndex extends Accessor {
	
	public ArrayIndex(Number nb) throws InvalidArrayAccesException {
		super(Tag.INDEX, checkIndex(nb), new semantic.Integer());
	}
	
	public ArrayIndex(Accessible accessible) throws InvalidArrayAccesException, UnknownSymbolException {
		super(Tag.INDEX, checkIndex(accessible), accessible.getType());
	}
	
	// vérifie si l'index est bien un entier
	private static Number checkIndex(Number nb) throws InvalidArrayAccesException {
		if(!(nb.getType() instanceof semantic.Integer))
			throw new InvalidArrayAccesException("Cannot define an offset with another type than Integer");
		return nb;
	}
	
	// vérifie si l'index est connu et si c'est bien un entier
	private static Accessible checkIndex(Accessible accessible) throws InvalidArrayAccesException, UnknownSymbolException {
		Type type = accessible.getType();
		if(type == null)
			throw new UnknownSymbolException("Cannot find symbol \"" + ((Name)accessible.getLeft()).getValue() + "\"");
		if(!(type instanceof semantic.Integer))
			throw new InvalidArrayAccesException("Cannot define an offset with another type than Integer");
		return accessible;
	}
}
