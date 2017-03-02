package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sucursal {

	protected SucursalPK sucursalPK;

	private String nombre;

	private Restaurant restaurant;

	private Direccion direccion;

	private Collection<Viaje> viajeCollection;

	public Sucursal() {
	}
	
	public Sucursal(int sucursal, int restaurant) {
		this.sucursalPK = new SucursalPK((short)sucursal, restaurant);
		this.viajeCollection = new ArrayList<>();
	}

	public SucursalPK getSucursalPK() {
		return sucursalPK;
	}

	public void setSucursalPK(SucursalPK sucursalPK) {
		this.sucursalPK = sucursalPK;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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
		hash += (sucursalPK != null ? sucursalPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Sucursal)) {
			return false;
		}
		Sucursal other = (Sucursal) object;
		if ((this.sucursalPK == null && other.sucursalPK != null) || (this.sucursalPK != null && !this.sucursalPK.equals(other.sucursalPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Sucursal[ sucursalPK=" + sucursalPK + " ]";
	}

}
