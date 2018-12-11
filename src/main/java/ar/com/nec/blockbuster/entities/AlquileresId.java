package ar.com.nec.blockbuster.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AlquileresId {

        private Cliente cliente;
        private Pelicula pelicula;

        @ManyToOne(cascade = CascadeType.ALL)
        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        @ManyToOne(cascade = CascadeType.ALL)
        public Pelicula getPelicula() {
            return pelicula;
        }

        public void setPelicula(Pelicula pelicula) {
            this.pelicula = pelicula;
        }
}
