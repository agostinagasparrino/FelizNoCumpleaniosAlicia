package ar.edu.unlam.pb2;

public class AlimentoQueEncoge extends Alimento {

	private static final Integer PODER_CALORICO = -50;

	public AlimentoQueEncoge(String nombre, Integer precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getPoderCalorico() {
		return PODER_CALORICO;
	}

}
