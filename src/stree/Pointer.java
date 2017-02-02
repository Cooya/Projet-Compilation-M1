package stree;

public class Pointer extends Stree {

	public Pointer(Pointer p) {
		super(Tag.POINTER, p);
	}
	
	public Pointer() {
		super(Tag.POINTER);
	}
}
