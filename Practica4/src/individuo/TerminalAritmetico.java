package individuo;

import interfaces.INodo;

public class TerminalAritmetico extends Terminal {
	
	public TerminalAritmetico(String s) {
		super(s);
	}
	public INodo copy() {
		INodo n = new TerminalAritmetico(simbolo);
		return n;
	}
	
}
