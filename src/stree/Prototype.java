package stree;

public class Prototype extends Stree {
	
	public Prototype(Name name, FunctionParameters params) {
		super(Tag.PROTOTYPE, name, params);
	}
	
	public Prototype(Tag tag, Prototype prototype) { // méthode statique
		super(tag, prototype);
	}
}
