package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import semantic.EnvironmentsStack;

// Abstract Syntax Tree
// decorated with attributs 
// tag: node label (cf EnumTag)

          
public abstract class Stree {
	
    private Tag tag;	// node label
    private Stree left;
    private Stree right;
    protected Object object;
    protected int id;   // used in toDot
    protected static int uniqId = 0;
    
    public static EnvironmentsStack stack = new EnvironmentsStack();

    public Stree(Tag tag, Stree left, Stree right, Object object) {
    	this.tag = tag;
    	this.left = left;
    	this.right = right;
    	this.object = object;
    	this.id = uniqId++;
    }
    
    public Stree() {
    	this(null, null, null, null);
    }
    
    public Stree(Tag tag) {
    	this(tag, null, null, null);
    }
    
    public Stree(Tag tag, Stree left) {
    	this(tag, left, null, null);
    }
    
    public Stree(Tag tag, Stree left, Stree right) {
    	this(tag, left, right, null);
    }
    
    public Tag getTag() {
        return tag;
    }    
    
    public int getId() {
        return id; 
    }    
    
    public Stree getLeft() {
    	return left;
    }
    
    public void setLeft(Stree s) {
    	left = s;
    }
    
    public Stree getRight() {
    	return right;
    }
    
    public void setRight(Stree s) {
    	right = s;
    }
    
    public Object getObject() {
    	return object;
    }
    
    public String toString() {
	String result = new String();
	result += tag.toString();
	if ((left != null) || (right != null)){
	    result +="(";
	    if (left != null)
	    	result += left.toString();
	    if (right != null){
                result+=",";
                if (right.tag==Tag.SUCC || right.tag==Tag.THENELSE)
                    result+="\n\n\t";
	    	result += right.toString();
            }
	    result+=")";
	}
	return result;
    }
    
    public void toDot(StringBuffer str) {
		str.append("a_"+id+" [");
		str.append("shape=\"ellipse\", label=\""+tag.toString()); 
		if (object!=null)
		  str.append("\\nobject: "+object.toString()); 
		str.append("\"];\n");
		if (left != null){
		    left.toDot(str);
		    str.append("a_"+id+" -> a_"+left.id+";\n");
		}
		if (right != null){
		    right.toDot(str);
		    str.append("a_"+id+" -> a_"+right.id+";\n");
		}
    }
    
    public void toDot(String file) {
		try {
		    BufferedWriter out = new BufferedWriter(new FileWriter(file));
		    out.write("digraph Stree {\n");
		    StringBuffer str = new StringBuffer();
		    toDot(str);
		    out.write(str.toString());
		    out.write("}\n");
		    out.close();
		} catch (IOException e) {
		    System.err.println("ERROR: build dot");
		}		
    }

}
