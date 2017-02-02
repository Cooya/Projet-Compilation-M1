package stree;

import exceptions.IncompatibleTypeException;
import exceptions.UnknownSymbolException;
import exceptions.UnknownTypeException;
import semantic.Type;

public class VarDefinition extends Definition {
	
	// vérifie le type d'une variable que l'on incrémente ou décremente
	public VarDefinition(UnaryOperator operator, Accessor accessor) throws IncompatibleTypeException, UnknownTypeException, UnknownSymbolException {
		super(Tag.VARDEF, operator, accessor);
		Type t = accessor.getType();
		if(t == null) // si son type vaut null, cela signifie qu'elle n'a pas été déclarée
			throw new UnknownSymbolException("Cannot find symbol \"" + ((Name) accessor.getLeft()).getValue() + "\"");
		if(!(t instanceof semantic.Integer) && !(t instanceof semantic.Float) && !(t instanceof semantic.Pointer))
			throw new IncompatibleTypeException("Invalid type for this operation");
	}
	
	// vérifie le type d'une variable que l'on affecte au résultat d'une expression, on vérifie aussi si les types correspondent
	public VarDefinition(AssignmentOperator operator, Accessor accessor, Typable exp) throws IncompatibleTypeException, UnknownSymbolException {
		super(Tag.VARDEF, new Assignment(operator, accessor, (Stree) exp));
		
		Type t1 = accessor.getType();
		if(t1 == null) // non déclarée
			throw new UnknownSymbolException("Cannot find symbol \"" + ((Name) accessor.getLeft()).getValue() + "\"");
		else if(t1 instanceof semantic.Function)
			throw new IncompatibleTypeException("Cannot assign a value to a function");
		
		Type t2 = exp.getType();
		//System.out.println(exp);
		if(t2 == null) // non déclarée
			if(exp instanceof Accessible)
				throw new UnknownSymbolException("Cannot find symbol \"" + ((Name) ((Accessible) exp).getLeft()).getValue() + "\"");
			else
				throw new UnknownSymbolException("Variable definition has failed !"); // ne devrait pas survenir normalement
		
		if(t1.diff(t2) != null)
			if(t2 instanceof semantic.Null) {
				if(t1 instanceof semantic.Integer || t1 instanceof semantic.Float
				|| t1 instanceof semantic.Boolean || t1 instanceof semantic.Character)
					throw new IncompatibleTypeException(t1 + "cannot be NULL");
			}
			else
				throw new IncompatibleTypeException("Invalid type assignment, \"" + t2 + "\" in \"" + t1 + "\"");
	}

	public VarDefinition(Tag tag) { // juste pour DefinitionError
		super(tag);
	}
}