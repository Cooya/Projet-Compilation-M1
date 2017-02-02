package semantic;

//import exceptions.IncompatibleUnificationException;

public abstract class SimpleType extends Type {
	
	public SimpleType() {
		super(null, null);
	}
	
	/*
	public Type unify(Type otherType) throws IncompatibleUnificationException {
		throw new IncompatibleUnificationException("Cannot unify simple type with an other type");
	}
	*/

	public abstract String toString();
	public abstract Object getInitialValue();
	public abstract int getSize();
	public abstract TypeDiff diff(Type otherType);
}
