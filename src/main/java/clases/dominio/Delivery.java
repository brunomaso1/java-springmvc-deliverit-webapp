package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Delivery {

	private Integer id;

	private Short calificacion;

	private String token;

	private Vehiculo vehiculo;

	private Usuario usuario;
	
	private String nombre;

	private Ubicacion ubicacion;

	private Collection<Viaje> viajeCollection;

	public Delivery() {
	}

	public Delivery(Integer id, Short calificacion, String token, Vehiculo vehiculo, Usuario usuario, Ubicacion ubicacion, Collection<Viaje> viajeCollection, String nombre) {
		this.id = id;
		this.calificacion = calificacion;
		this.token = token;
		this.vehiculo = vehiculo;
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.nombre = nombre;
		this.viajeCollection = viajeCollection;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Short calificacion) {
		this.calificacion = calificacion;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
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
		if (!(object instanceof Delivery)) {
			return false;
		}
		Delivery other = (Delivery) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Delivery[ id=" + id + " ]";
	}

}
