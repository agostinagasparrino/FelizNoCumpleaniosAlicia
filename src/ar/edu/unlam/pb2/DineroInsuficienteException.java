package ar.edu.unlam.pb2;

public class DineroInsuficienteException extends Exception {
	
	public DineroInsuficienteException(String string) {
		super("Dinero insuficiente para comprar el alimento");
	}


}
