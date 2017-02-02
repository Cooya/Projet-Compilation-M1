package semantic;

public abstract class Type {
	private Type lChild;
	private Type rChild;
	
	
	public Type(Type lChild, Type rChild) {
		this.lChild = lChild;
		this.rChild = rChild;
	}
	
	public Type getLeftChild() {
		return lChild;
	}
	
	public Type getRightChild() {
		return rChild;
	}
	
	public void setLeftChild(Type lChild) {
		this.lChild = lChild;
	}
	
	public void setRightChild(Type rChild) {
		this.rChild = rChild;
	}
	
	public abstract String toString();
	public abstract Object getInitialValue();
	public abstract int getSize();
	public abstract TypeDiff diff(Type otherType);
}
