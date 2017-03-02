package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstadoViaje  {
   
    private Short id;
   
    private String descripcion;
    
    private Collection<Viaje> viajeCollection;

    public EstadoViaje() {
    }

	public EstadoViaje(int id) {
		this.id = (short)id;
	}

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoViaje)) {
            return false;
        }
        EstadoViaje other = (EstadoViaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucu.deliverit.backcore.entidades.EstadoViaje[ id=" + id + " ]";
    }
    
}