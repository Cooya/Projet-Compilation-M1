package stree;

import semantic.Product;
import semantic.Type;

public abstract class List extends Stree implements Typable {
	private Product product;
	
	public List(Tag tag, Typable elt) {
		super(tag, (Stree) elt);
		this.product = new Product(elt.getType());
	}
	
	public List(Tag tag, List list, Typable elt) {
		super(tag, list, (Stree) elt);
		this.product = new Product(list.getType(), elt.getType());
	}
	
	public List(Tag tag, Typable elt1, Typable elt2) {
		super(tag, (Stree) elt1, (Stree) elt2);
		this.product = new Product(elt1.getType(), elt2.getType());
	}
	
	public abstract List add(Typable elt);
	
	public Product getProduct() {
		return this.product;
	}
	
	public void updateProduct() {
		this.product = new Product(((Typable) getLeft()).getType(), ((Typable) getRight()).getType());
	}
	
	public Type getType() {
		return this.product;
	}
}
