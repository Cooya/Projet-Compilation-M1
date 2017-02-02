package stree;

import semantic.Product;
import semantic.TypeName;

public class StructFields extends Stree {
	private Product product;
	
	public StructFields(StructFields fields, VarDeclaration dec) {
		super(Tag.STRUCTFIELDS, dec, fields);
		this.product = new Product(fields.getProduct(), new Product(new TypeName(dec.getName()), dec.getType()));
	}
	
	public StructFields(VarDeclaration dec) {
		super(Tag.STRUCTFIELDS, dec);
		this.product = new Product(new TypeName(dec.getName()), dec.getType());
	}
	
	public Product getProduct() {
		return this.product;
	}
}
