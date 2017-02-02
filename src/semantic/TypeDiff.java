package semantic;

public class TypeDiff {
	private Type t1;
	private Type t2;
	
	public TypeDiff(Type t1, Type t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public boolean isDiff() {
		if(t1 == null)
			if(t2 == null)
				return false;
			else
				return true;
		return t1.diff(t2) != null;
	}
}
