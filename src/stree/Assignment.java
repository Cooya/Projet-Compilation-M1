package stree;

public class Assignment extends Statement {
	public Assignment(AssignmentOperator operator, Accessor accessor, Stree exp) {
		super(operator.getTag(), accessor, exp);
	}
}