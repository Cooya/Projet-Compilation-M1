package semantic;

import exceptions.UnknownStructureFieldException;

public class Structure extends Type {

	public Structure(Product fields) {
		super(fields, null);
	}

	/*
	public void add(Type newChild) {
		Type lChild = getLeftChild();
		if(lChild == null)
			setLeftChild(new Product(newChild));
		else
			((Product) lChild).add(newChild);
	}
	*/

	public String toString() {
		return "Structure {" + getLeftChild().toString() + "}";
	}
	
	public Object getInitialValue() {
		return null;
	}

	public int getSize() {
		return getLeftChild().getSize();
	}

	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Structure) {
			Type child = this.getLeftChild();
			Type otherChild = otherType.getLeftChild();
			if(child != null)
				return child.diff(otherChild);
			if(otherChild != null)
				return null;
		}
		return new TypeDiff(this, otherType);
	}
	
	// vérifie si un champ existe bel et bien dans une structure et retourne son type
	public Type getStructFieldType(String name) throws UnknownStructureFieldException {
		Type result = ((Product) getLeftChild()).getStructFieldType(name);
		if(result == null)
			throw new UnknownStructureFieldException("Cannot find field \"" + name + "\" in this structure");
		return result;
	}
}
