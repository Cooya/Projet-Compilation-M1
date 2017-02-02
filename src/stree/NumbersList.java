package stree;

public class NumbersList extends List {
	
	public NumbersList(Number number) {
		super(Tag.NBLIST, number);
	}
	
	public NumbersList(Number n1, Number n2) {
		super(Tag.NBLIST, n1, n2);
	}
	
	public NumbersList add(Typable n) {
		Stree rChild = getRight();
		if(rChild == null) {
			setRight((Number) n);
			updateProduct();
		}
		else if(!(rChild instanceof NumbersList)) {
			setRight(new NumbersList((Number) rChild, (Number) n));
			updateProduct();
		}
		else
			((NumbersList) rChild).add(n);
		return this;
	}
}
