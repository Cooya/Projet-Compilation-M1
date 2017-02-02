package stree;

public class ParametersList extends List {

	public ParametersList(Parameter param) {
		super(Tag.PARAMSLIST, param);
	}
	
	public ParametersList(Parameter param1, Parameter param2) {
		super(Tag.PARAMSLIST, param1, param2);
	}
	
	public ParametersList add(Typable p) {
		Stree rChild = getRight();
		if(rChild == null) {
			setRight((Parameter) p);
			updateProduct();
		}
		else if(!(rChild instanceof ParametersList)) {
			setRight(new ParametersList((Parameter) rChild, (Parameter) p));
			updateProduct();
		}
		else
			((ParametersList) rChild).add(p);
		return this;
	}
}
