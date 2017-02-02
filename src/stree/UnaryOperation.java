package stree;

public class UnaryOperation extends Expression {
	
	public UnaryOperation(UnaryOperator operator, Expression exp) {
		super(operator.getTag(), exp, exp.getType());
	}
}
