package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlicia {

	@Test
	public void testQueAlComprarUnAlimentoSeDescuenteElDineroDisponible() throws DineroInsuficienteException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueAgranda a = new AlimentoQueAgranda("caramelo", 50);
		AlimentoQueAgranda b = new AlimentoQueAgranda("gomita", 50);
		p.comprarAlimento(a);
		p.comprarAlimento(b);
		assertEquals(100, p.getDinero(), 0.1);
	}

	@Test(expected = DineroInsuficienteException.class)
	public void testQueAlSuperarElDineroDisponibleLargueExcepcion() throws DineroInsuficienteException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueAgranda a = new AlimentoQueAgranda("caramelo", 150);
		AlimentoQueAgranda b = new AlimentoQueAgranda("gomita", 110);
		p.comprarAlimento(a);
		p.comprarAlimento(b);
	}

	@Test
	public void queSeMuestrenLosAlimentosOrdenadosPorOrdenAlfabetico() throws DineroInsuficienteException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueEncoge a = new AlimentoQueEncoge("masita", 40);
		AlimentoQueEncoge b = new AlimentoQueEncoge("alfajor", 70);
		AlimentoQueEncoge c = new AlimentoQueEncoge("bagle", 30);
		p.comprarAlimento(a);
		p.comprarAlimento(c);
		p.comprarAlimento(b);
		assertEquals(p.presetarAlimentosOrdenadosPorOrdenAlfabético().first(), b);
		assertEquals(p.presetarAlimentosOrdenadosPorOrdenAlfabético().last(), a);
		assertEquals(60, p.getDinero(), 0.1);
	}

	@Test
	public void queSeMuestrenLaCantidadDeAlimentosQueCompre() throws DineroInsuficienteException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueEncoge a = new AlimentoQueEncoge("masita", 40);
		AlimentoQueEncoge b = new AlimentoQueEncoge("alfajor", 70);
		AlimentoQueEncoge c = new AlimentoQueEncoge("bagle", 30);
		p.comprarAlimento(a);
		p.comprarAlimento(c);
		p.comprarAlimento(b);
		assertEquals(3, p.alimentosComprados(b), 0.1);
		assertEquals(60, p.getDinero(), 0.1);
	}

	@Test
	public void testQueAlConsumirUnAlimentoVerificarQueQueAgrande()
			throws DineroInsuficienteException, AlturaFueraDeRangoException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueAgranda a = new AlimentoQueAgranda("caramelo", 50);
		p.comprarAlimento(a);
		p.comerAlimento(a, 1);
		assertEquals(220, p.getAltura(), 0.1);
		assertEquals(150, p.getDinero(), 0.1);
	}

	@Test
	public void testQueAlConsumirUnAlimentoVerificarQueAchique()
			throws DineroInsuficienteException, AlturaFueraDeRangoException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueEncoge c = new AlimentoQueEncoge("bagle", 30);
		AlimentoQueAgranda a = new AlimentoQueAgranda("caramelo", 50);
		p.comprarAlimento(c);
		p.comprarAlimento(a);
		p.comerAlimento(c, 1);
		assertEquals(130, p.getAltura(), 0.1);
		assertEquals(1, p.alimentosComprados(a), 0.1);
		assertEquals(120, p.getDinero(), 0.1);
		// compro a y c, consumo c para ecoger la altura pero a sigue estando en la
		// coleccion
		// cuando consumo, se quita ese de los alimentos comprados y se actualiza la
		// cantidad
	}

	@Test(expected = AlturaFueraDeRangoException.class)
	public void testQueAlConsumirAlimentosVerificarQueNoSePuedaEncogerMenosDe50cm()
			throws DineroInsuficienteException, AlturaFueraDeRangoException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueEncoge a = new AlimentoQueEncoge("masita", 40);
		AlimentoQueEncoge b = new AlimentoQueEncoge("alfajor", 70);
		AlimentoQueEncoge c = new AlimentoQueEncoge("bagle", 30);
		p.comprarAlimento(a);
		p.comprarAlimento(c);
		p.comprarAlimento(b);
		p.comerAlimento(c, 1);
		p.comerAlimento(b, 1);
		p.comerAlimento(a, 1);
		assertEquals(30, p.getDinero(), 0.1);
	}

	@Test(expected = AlturaFueraDeRangoException.class)
	public void testQueAlConsumirAlimentosVerificarQueNoSePuedaAgrandarMasDe280cm() throws DineroInsuficienteException, AlturaFueraDeRangoException {
		Personaje p = new Personaje("Alicia", 15);
		AlimentoQueAgranda a = new AlimentoQueAgranda("caramelo", 50);
		AlimentoQueAgranda b = new AlimentoQueAgranda("gomita", 50);
		AlimentoQueAgranda c = new AlimentoQueAgranda("chocolate", 50);
		p.comprarAlimento(a);
		p.comprarAlimento(b);
		p.comprarAlimento(c);
		p.comerAlimento(c, 1);
		p.comerAlimento(b, 1);
		p.comerAlimento(a, 1);
		assertEquals(50, p.getDinero(), 0.1);
	}
}
