package stree;

import exceptions.CompilationException;
import semantic.Type;
import semantic.TypeDiff;

public class BinaryOperation extends Expression {

	public BinaryOperation(BinaryOperator operator, Expression expL, Expression expR) throws CompilationException {
		super(operator.getTag(), expL, expR, getReturnType(expL, expR));
	}
	
	static private Type getReturnType(Expression expL, Expression expR) throws CompilationException {
		Type expLType = expL.getType();
		Type expRType = expR.getType();
		TypeDiff diff = new TypeDiff(expLType, expRType);
		if(diff.isDiff()) throw new CompilationException("Forbidden operation between " + expLType + " and " + expRType);
		else return expLType;
	}
}
