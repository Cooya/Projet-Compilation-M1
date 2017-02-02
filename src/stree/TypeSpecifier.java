package stree;

import semantic.Pointer;
import semantic.Type;
import semantic.Listof;

public class TypeSpecifier extends Stree {
	private Type type;
	
	public TypeSpecifier(Tag tag) {
		super(tag);
		switch(tag) {
			case INTEGER : this.type = new semantic.Integer(); break;
			case FLOAT : this.type = new semantic.Float(); break;
			case CHARACTER : this.type = new semantic.Character(); break;
			case BOOL : this.type = new semantic.Boolean(); break;
			case STRING : this.type = new semantic.Str(); break;
			default: this.type = null;
		}
	}
	
	public TypeSpecifier(Tag tag, TypeSpecifier type) {
		super(tag, type);
		switch(tag) { 
			case POINTER : this.type = new Pointer(type.getType()); break;
			case LISTOF : this.type = new Listof(type.getType()); break;
			default : this.type = null;
		}
	}
	
	TypeSpecifier(Tag tag, StructFields fields) { // structures
		super(tag, fields);
		this.type = new semantic.Structure(fields.getProduct());
	}
	
	public Type getType() {
		return this.type;
	}
}
