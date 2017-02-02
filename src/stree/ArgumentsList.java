package stree;

public class ArgumentsList extends List {
	
	public ArgumentsList(Expression exp) {
		super(Tag.ARGSLIST, exp);
	}
	
	public ArgumentsList(Expression exp1, Expression exp2) {
		super(Tag.ARGSLIST, exp1, exp2);
	}
	
	public ArgumentsList add(Typable exp) { // doit modifier le product dans List
		Stree rChild = getRight();
		if(rChild == null) {
			setRight((Expression) exp);
			updateProduct();
		}
		else if(!(rChild instanceof ArgumentsList)) {
			setRight(new ArgumentsList((Expression) rChild, (Expression) exp));
			updateProduct();
		}
		else
			((ArgumentsList) rChild).add(exp);
		return this;
	}
}
