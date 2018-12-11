package ar.com.nec.blockbuster.entities;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Alquileres")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.cliente",
                joinColumns = @JoinColumn(name = "idCliente")),
        @AssociationOverride(name = "primaryKey.pelicula",
                joinColumns = @JoinColumn(name = "idPelicula")) })
public class Alquileres {
    private AlquileresId primaryKey = new AlquileresId();

    @EmbeddedId
    public AlquileresId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(AlquileresId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Cliente getCliente() {
        return getPrimaryKey().getCliente();
    }

    public void setCliente(Cliente cliente) {
        getPrimaryKey().setCliente(cliente);
    }

    @Transient
    public Pelicula getPelicula() {
        return getPrimaryKey().getPelicula();
    }

    public void setPelicula(Pelicula pelicula) {
        getPrimaryKey().setPelicula(pelicula);
    }


}
