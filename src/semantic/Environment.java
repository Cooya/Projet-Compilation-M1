package semantic;
import java.util.Collection;
import java.util.Hashtable;

public class Environment {
	private Hashtable<String, Symbol> localSymbols;
	private Hashtable<String, Symbol> globalSymbols;
	private String name;
	private Type type;
	
	public Environment(String name, Type type, Environment globalEnv) {
		localSymbols = new Hashtable<String, Symbol>();
		globalSymbols = new Hashtable<String, Symbol>();
		if(globalEnv != null)
			importGlobalSymbols(globalEnv);
		this.name = name;
		this.type = type;
	}
	
	/* J'ai fait le choix de respecter les règles de déclarations Java, c'est-à-dire qu'une variable peut porter le même nom qu'une fonction
	 * ou classe ou type existant. Pour différencier facilement une variable et une fonction portant le même nom, j'ai rajouté des "()" à
	 * un symbole représentant une fonction.
	 */
	public Symbol newSymbol(String name, Type type, Object value) {
		if(type instanceof Function)
			name = name + "()";
		Symbol s = localSymbols.get(name);
		
		/*
		if(s != null) {
			Type type2 = s.getType();
			if(type instanceof Function && type2 instanceof Function)
				return null;
			else if(type instanceof Function || type2 instanceof Function);
			else
				return null;
		}
		*/
		
		if(s != null)
			return null;
		s = new Symbol(name, type, value);
		localSymbols.put(name, s);
		return s;
	}
	
	public Symbol findSymbol(String name) {
		Symbol s = localSymbols.get(name);
		if(s == null)
			return globalSymbols.get(name);
		else
			return s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public int getSize() {
		int size = 0;
		Collection<Symbol> coll = localSymbols.values();
		for(Symbol s : coll)
			size += s.getSize();
		return size;
	}
	
	public String toString() {
		Collection<Symbol> coll = localSymbols.values();
		String str = "Contenu du scope : {";
		for(Symbol s : coll)
			str += s.getTypeAsString() + ' ' + s.getName() + ", ";
		return str.substring(0, str.length() - 2) + '}';
	}
	
	private void importGlobalSymbols(Environment globalEnv) {
		for(String s: globalEnv.globalSymbols.keySet())
			this.globalSymbols.put(s, globalEnv.globalSymbols.get(s));
		for(String s: globalEnv.localSymbols.keySet())
			this.globalSymbols.put(s, globalEnv.localSymbols.get(s));
	}
}
