package stree;

import semantic.Type;
import exceptions.InvalidStructureAccessException;
import exceptions.UnknownSymbolException;

public class AccessorOperation extends Accessor {

	public AccessorOperation(Operator operator, Accessor a1, Accessor a2) throws Exception {
		super(operator.getTag(), a1, a2, getType(operator.getTag(), a1, a2));
	}
	
	// vérifie les typages des accès à une structure, une classe ou un pointeur de structure (construction de gauche à droite)
	private static Type getType(Tag ope, Identifier a1, Identifier a2) throws Exception {
		Type a1Type = a1.getType();
		if(a1Type == null)
			throw new UnknownSymbolException("Cannot find symbol \"" + ((Name) a1.getLeft()).getValue() + "\"");
		if(ope == Tag.DOT)
			if(a1Type instanceof semantic.Structure)
				return ((semantic.Structure) a1Type).getStructFieldType(((Name) a2.getLeft()).getValue());
			else if(a1Type instanceof semantic.Class)
				throw new Exception("Not implemented yet");
			else
				throw new InvalidStructureAccessException("Not a structure or a class");
		else if(ope == Tag.ARROW)
			if(a1Type instanceof semantic.Pointer && a1Type.getLeftChild() instanceof semantic.Structure)
				return ((semantic.Structure) a1Type.getLeftChild()).getStructFieldType(((Name) a2.getLeft()).getValue());
			else
				throw new InvalidStructureAccessException("Not a pointer of structure"); 
		else // cas impossible normalement
			throw new InvalidStructureAccessException("Impossible error !"); 
	}
}
