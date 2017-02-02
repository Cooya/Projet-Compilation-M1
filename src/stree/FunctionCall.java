package stree;

import exceptions.InvalidFunctionCallArguments;
import exceptions.UnknownSymbolException;
import semantic.Symbol;
import semantic.Type;

public class FunctionCall extends Statement {
	
	public FunctionCall(Name name, ArgumentsList list) {
		super(Tag.FCTCALL, name, list);
	}
	
	public FunctionCall(Name name) {
		super(Tag.FCTCALL, name, new Void());
	}
	
	public Accessor toAccessor() throws InvalidFunctionCallArguments {
		Name name = (Name) getLeft();
		Symbol s = stack.getSymbol(name.getValue());
		Type type;
		if(s == null) 
			type = null;
		else {
			type = s.getType().getRightChild(); // type de retour
			checkArgs(getRight(), s.getType().getLeftChild()); // vérifie les arguments passés
		}
		if(getRight() instanceof ArgumentsList)
			return new Accessible(Tag.FCTCALL, name, (ArgumentsList) getRight(), type);
		else
			return new Accessible(Tag.FCTCALL, name, (Void) getRight(), type);
	}
	
	public Statement toStatement() throws InvalidFunctionCallArguments, UnknownSymbolException {
		Name name = (Name) getLeft();
		Symbol s = stack.getSymbol(name.getValue());
		if(s == null)
			throw new UnknownSymbolException("Cannot find function \"" + name.getValue() + "\"");
		checkArgs(getRight(), s.getType().getLeftChild()); // vérifie les arguments passés
		if(getRight() instanceof ArgumentsList)
			return new Statement(Tag.FCTCALL, name, getRight());
		else
			return new Statement(Tag.FCTCALL, name, (Void) getRight());
	}
	
	public void checkArgs(Stree passedArgs, Type waitedArgs) throws InvalidFunctionCallArguments { // à améliorer
		if(passedArgs instanceof Void) {
			if(!(waitedArgs instanceof semantic.Void))
				throw new InvalidFunctionCallArguments("Wrong arguments of function call passed, arguments waited : " + waitedArgs + ", passed : Void");
		}
		else {
			Type passedType = ((ArgumentsList) passedArgs).getType();
			if(passedType.diff(waitedArgs) != null)
				throw new InvalidFunctionCallArguments("Wrong arguments of function call passed, arguments waited : " + waitedArgs + ", passed : " + passedType);
		}
	}
}