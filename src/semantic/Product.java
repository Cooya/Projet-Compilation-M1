package semantic;

public class Product extends Type {
	
	public Product(Type lChild, Type rChild) {
		super(lChild, rChild);
	}
	
	public Product(Type lChild) {
		super(lChild, null);
	}
	
	public Product add(Type newChild) {
		Type rChild = getRightChild();
		if(rChild == null)
			setRightChild(newChild);
		else if(!(rChild instanceof Product))
			setRightChild(new Product(rChild, newChild));
		else
			((Product) rChild).add(newChild);
		return this;
	}
	
	public String toString() {
		Type rChild = getRightChild(); 
		if(rChild == null)
			return getLeftChild().toString();
		Type lChild = getLeftChild();
		if(lChild instanceof TypeName)
			return lChild.toString() + ": "+ getRightChild().toString();
		else
			return lChild.toString() + ", " + getRightChild().toString();
	}
	
	public Object getInitialValue() {
		return null;
	}
	
	public int getSize() {
		return getLeftChild().getSize() + getRightChild().getSize();
	}
	
	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Product) {
			TypeDiff td = this.getLeftChild().diff(otherType.getLeftChild());
			if(td != null)
				return td;
			if(this.getRightChild() != null)
				return this.getRightChild().diff(otherType.getRightChild());
			if(otherType.getRightChild() == null)
				return null;
		}
		return new TypeDiff(this, otherType);		
	}
	
	protected Type getStructFieldType(String name) {
		Type lChild = getLeftChild();
		Type rChild = getRightChild();
		if(lChild instanceof TypeName && ((TypeName) lChild).getName().equals(name)) // trouvé
			return rChild;
		Type result = null;
		if(lChild instanceof Product) // on essaye à gauche
			result = ((Product) lChild).getStructFieldType(name);
		if(result == null && rChild instanceof Product) // si rien à gauche, on essaye à droite
			result = ((Product) rChild).getStructFieldType(name);
		return result;
	}
}
