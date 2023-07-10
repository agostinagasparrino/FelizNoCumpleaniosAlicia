package ar.edu.unlam.pb2;

public class AlimentoQueAgranda extends Alimento {

	private static final Integer PODER_CALORICO = +40;

	public AlimentoQueAgranda(String nombre, Integer precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getPoderCalorico() {
		return PODER_CALORICO;
	}
}
