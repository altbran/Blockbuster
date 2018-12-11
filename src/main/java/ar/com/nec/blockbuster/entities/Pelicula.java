package ar.com.nec.blockbuster.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "peliculas")
public class Pelicula {

	private String nombre = "";
	private String genero = "";
	private int idPelicula;

	private Set<Alquileres> alquileres = new HashSet<Alquileres>();

	public Pelicula(){}
	public Pelicula(String nombre, String genero) {
		this.nombre = nombre;
		this.genero = genero;
	}



	@Id
	@GeneratedValue
	@Column(name = "idPelicula")
	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@OneToMany(mappedBy = "primaryKey.pelicula",
			cascade = CascadeType.ALL)
	public Set<Alquileres> getAlquileres() {
		return alquileres;
	}
	
	public String toString() {
		return "\n\tNombre de pelicula..: "+nombre+"\n\tGenero de pelicula..: "+genero;
	}
	
}
