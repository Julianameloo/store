package br.com.api.store.model;

public enum Genero {
	FEMININO,
	MASCULINO,
	OUTRO;
	
	public static boolean contains(String test) {

	    for (Genero genero : Genero.values()) {
	        if (genero.name().equals(test)) {
	        	return true;
	        }
	    }

	    return false;
	}
}
