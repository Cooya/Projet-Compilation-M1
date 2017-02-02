package stree;

import exceptions.IncompatibleTypeException;
import semantic.Type;

public class Return extends Statement {
	
	public Return(Expression exp) throws IncompatibleTypeException {
		super(Tag.RETURN, checkReturnType(exp));
	}
	
	private static Expression checkReturnType(Expression exp) throws IncompatibleTypeException {
		Type t = stack.getReturnType();
		if(t.diff(exp.getType()) != null)
			throw new IncompatibleTypeException("This function must return a " + t.toString());
		return exp;
	}
}