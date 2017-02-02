package stree;

public class ClassBody extends Stree {
	
	public ClassBody(Stree s, Definition def) {
		super(Tag.BODY, s, def);
	}
	
	public ClassBody(Definition def) {
		this(def, null);
	}
}