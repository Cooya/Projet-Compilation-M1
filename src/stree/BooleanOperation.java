package stree;

public class BooleanOperation extends Expression {
	
	public BooleanOperation(BooleanOperator operator, Expression expL, Expression expR) {
		super(operator.getTag(), expL, expR, new semantic.Boolean());
	}
}
