package stree;

public class In extends Statement {

	public In(Name name, Accessor accessor) {
		super(Tag.IN, name, accessor);
	}
	
	public In(Name name, NumbersList list) {
		super(Tag.IN, name, list);
	}
}
