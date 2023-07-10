package ar.edu.unlam.pb2;

import java.util.TreeSet;

public class Personaje {

	private String nombre;
	private Integer altura = 180;
	private Integer peso = 50;
	private Integer edad;
	private Integer dinero = 200;
	private TreeSet<Alimento> alimentos;

	public Personaje(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.alimentos = new TreeSet<Alimento>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getDinero() {
		return dinero;
	}

	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}

	public TreeSet<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(TreeSet<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public void comprarAlimento(Alimento alimento) throws DineroInsuficienteException {
		if (alimento.getPrecio() > this.dinero) {
			throw new DineroInsuficienteException("Dinero insuficiente para comprar el alimento");
		}

		this.alimentos.add(alimento);
		this.dinero -= alimento.getPrecio();
	}

	public Integer alimentosComprados(Alimento alimento) {
		return this.alimentos.size();
	}

	public void comerAlimento(Alimento alimento, Integer cantidad) throws AlturaFueraDeRangoException {
		if (alimentos.contains(alimento)) {
			alimentos.remove(alimento); // Eliminar el alimento del TreeSet
			altura += alimento.getPoderCalorico();
			
			// Verificar y ajustar la altura si es menor a 50 o mayor a 280
	        if (altura < 50 || altura > 280) {
	            throw new AlturaFueraDeRangoException("La altura está fuera del rango permitido.");
	        }
		}
	}

	public TreeSet<Alimento> presetarAlimentosOrdenadosPorOrdenAlfabético() {
		TreeSet<Alimento> aliementosPorAlfabetico = new TreeSet<Alimento>(new PorAlfabeticoComparator());
		// creo una nueva coleccion con un nuevo criterio de ordenamiento
		aliementosPorAlfabetico.addAll(alimentos);
		// le agrego todos los alimentos que tengo
		return aliementosPorAlfabetico;
		// retorno los alimentos que tengo
	}

}
