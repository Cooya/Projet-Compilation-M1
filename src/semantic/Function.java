package semantic;

public class Function extends Type {

	public Function(Product lChild, Type rChild) { // fonction avec retour et paramètre(s)
		super(checkParam(lChild), checkParam(rChild));
	}
	
	/*
	public Function(Product lChild) { // procédure avec paramètre(s)
		super(lChild, new Void());
	}
	
	public Function() { // procédure sans paramètre
		super(new Void(), new Void());
	}
	*/
	
	private static Type checkParam(Type t) {
		if(t == null)
			return new Void();
		return t;
	}

	public String toString() {
		Type rChild = getRightChild(); // type de retour
		Type lChild = getLeftChild(); // paramètres
		if(rChild instanceof Void)
			if(lChild instanceof Void)
				return "Procedure ()";
			else
				return "Procedure (" + lChild.toString() + ")"; 
		else
			if(lChild instanceof Void)
				return rChild.toString() + " ()";
			else
				return rChild.toString() + " (" + lChild.toString() + ")";
	}
	
	public Object getInitialValue() {
		return null;
	}

	public int getSize() {
		return 0; // une fonction ne prend pas de place en mémoire, tout est dans le code source et la pile (lorsque la fonction est appelée)
	}

	public TypeDiff diff(Type otherType) {
		if(otherType instanceof Function) {
			Type rChild = this.getRightChild();
			if(rChild != null) {
				TypeDiff td = rChild.diff(otherType.getRightChild());
				if(td != null)
					return td;
				Type lChild = this.getLeftChild();
				if(lChild != null)
					return lChild.diff(otherType.getLeftChild());
			}	
		}
		return new TypeDiff(this, otherType);
	}
}
