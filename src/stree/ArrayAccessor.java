package stree;

public class ArrayAccessor extends Stree {

	public ArrayAccessor(ArrayAccessor array, ArrayIndex index) {
		super(Tag.ARRAYACCESSOR, array, index);
	}
	
	public ArrayAccessor(ArrayIndex index) {
		super(Tag.ARRAYACCESSOR, index);
	}
	
	public int getDepth() { // retourne la profondeur de l'accès à un tableau (= nombre de [X])
		if(getRight() == null)
			return 1;
		return 1 + ((ArrayAccessor) getLeft()).getDepth();
	}
}
