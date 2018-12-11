package ar.com.nec.blockbuster.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue
	@Column(name = "idCliente")
	private int idCliente;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "dni")
	private int dni;


	private Set<Alquileres> alquileres = new HashSet<Alquileres>();


	public Cliente(){}
	public Cliente(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public void addAlquiler(Alquileres alquiler) {
		this.alquileres.add(alquiler);
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@OneToMany(mappedBy = "primaryKey.cliente",
			cascade = CascadeType.ALL)
	public Set<Alquileres> getAlquileres() {
		return alquileres;
	}


	public String misPeliculas() {
	String result = getAlquileres().stream()
	        .map(Object::toString)
	        .collect(Collectors.joining(","));
	return result;
	}
	public String toString() {
		return "Nombre..: "+nombre+"\nDni..: "+dni+"\nLista de peliculas..: "+misPeliculas();
	}

	
	
}
