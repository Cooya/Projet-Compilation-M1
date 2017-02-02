package stree;

public class Statement extends Stree {
	
	public Statement(Tag tag, Stree s1, Stree s2) {
		super(tag, s1, s2);
	}
	
	public Statement(Tag tag, Stree s) {
		super(tag, s);
	}
	
	public Statement(Tag tag) {
		super(tag);
	}
}