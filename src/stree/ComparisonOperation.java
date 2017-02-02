package stree;

public class ComparisonOperation extends Expression {
	
	public ComparisonOperation(ComparisonOperator operator, Expression expL, Expression expR) {
		super(operator.getTag(), expL, expR, new semantic.Boolean());
	}
}
