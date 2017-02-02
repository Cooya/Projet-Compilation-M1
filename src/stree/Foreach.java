package stree;

public class Foreach extends Loop {

	public Foreach(Name name, Accessor accessor, StatementsBlock block) {
		super(Tag.FOREACH, new In(name, accessor), block);
	}
	
	public Foreach(Name name, NumbersList list, StatementsBlock block) {
		super(Tag.FOREACH, new In(name, list), block);
	}
}
