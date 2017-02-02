package semantic;

import java.util.Stack;

import exceptions.CompilationException;

public class EnvironmentsStack {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_ORANGE = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	private Stack<Environment> envStack;
	private String displayShift = "";
	
	public EnvironmentsStack() {
		envStack = new Stack<Environment>();
	}
	
	public Stack<Environment> getTable() {
		return envStack;
	}
	
	public void pushEnv(String name, Type type) {
		System.out.println(displayShift + "Push d'un nouvel environnement {" + name + ", " + type + "}");
		Environment e;
		if(envStack.empty())
			e = new Environment(name, type, null);
		else
			e = new Environment(name, type, envStack.peek());
		envStack.push(e);
		displayShift += "     ";
	}
	
	public void popEnv() throws CompilationException {
		if(envStack.empty())
			throw new CompilationException("Attempt to leave a nonexistent environment.");
		Environment e = envStack.pop();
		displayShift = displayShift.substring(0, displayShift.length() - 5);
		if(e.getType() instanceof Class)
			System.out.println(displayShift + "Pop de l'environnement {" + e.getName() + ", " + e.getType() + ", " + e.getSize() + " octets}");
		else
			System.out.println(displayShift + "Pop de l'environnement {" + e.getName() + ", " + e.getType() + "}");
	}
	
	public Symbol newSymbol(String name, Type type, Object value) throws CompilationException {
		if(envStack.empty())
			throw new CompilationException("Attempt to add a new symbol in a nonexistent environment.");
		Symbol s = envStack.peek().newSymbol(name, type, value);
		if(s == null) {
			warning(displayShift + "Symbole \"" + name + "\" déjà existant dans cet environnement");
			return null;
		}
		System.out.println(displayShift + "Création d'un nouveau symbole [" + s.getName() + ", " + s.getTypeAsString() + ", " + s.getValue() +"]");
		return s;
	}
	
	public Symbol newSymbol(String name, Type type) throws CompilationException {
		return newSymbol(name, type, null);
	}
	
	public Symbol getSymbol(String name) {
		return envStack.peek().findSymbol(name);
	}
	
	public boolean setValue(String name, Object newValue) {
		Symbol s = envStack.peek().findSymbol(name);
		if(s == null) {
			System.out.println("Symbole introuvable.");
			return false;
		}
		if(!s.setValue(newValue)) {
			System.out.println("Type non compatible.");
			return false;
		}
		return true;
	}
	
	public Type getReturnType() {
		return envStack.peek().getType().getRightChild();
	}
	
	public void printCurrentEnv() {
		System.out.println(envStack.peek().toString());
	}
	
	@SuppressWarnings("unused")
	static private void error(String msg) {
		System.out.println(ANSI_RED + msg + ANSI_RESET);
	}
	
	static private void warning(String msg) {
		System.out.println(ANSI_ORANGE + msg + ANSI_RESET);
	}
}