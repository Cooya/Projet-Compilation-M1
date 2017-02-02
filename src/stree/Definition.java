package stree;

public abstract class Definition extends Statement {
	
	public Definition(Tag tag, Stree l, Stree r) {
		super(tag, l, r);
	}
	
	public Definition(Tag tag, Stree l) {
		super(tag, l);
	}
	
	public Definition(Tag tag) {
		super(tag);
	}
}
