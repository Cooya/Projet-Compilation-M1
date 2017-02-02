package stree;

public abstract class ConditionalStatement extends Statement {
	
	public ConditionalStatement(Tag tag, Stree s1, Stree s2) {
		super(tag, s1, s2);
	}

	public ConditionalStatement(Tag tag, Stree s) {
		super(tag, s);
	}

}
