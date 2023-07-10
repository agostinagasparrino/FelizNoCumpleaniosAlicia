package ar.edu.unlam.pb2;

public class AlturaFueraDeRangoException extends Exception {
	
	public AlturaFueraDeRangoException(String string) {
		super("La altura está fuera del rango permitido.");
	}

}
