package ar.edu.unlam.pb2;

import java.util.Objects;

public abstract class Alimento implements Comparable<Alimento> {

	protected String nombre;
	protected Integer precio;
	protected Integer cantidad = 0;

	public Alimento(String nombre, Integer precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void agregarCantidad(Integer i) {
		this.cantidad += i;

	}

	public void eliminarCantidad(Integer i) {
		this.cantidad -= i;

	}

	public abstract Integer getPoderCalorico();

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int compareTo(Alimento alimento) {
		return this.nombre.compareTo(alimento.getNombre());
	}

}
