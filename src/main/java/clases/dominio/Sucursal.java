package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sucursal {

	private Integer id;

	private String nombre;

	private Restaurant restaurant;

	private Direccion direccion;

	private Collection<Viaje> viajeCollection;

	public Sucursal() {
	}
	
	public Sucursal(Integer sucursal) {
		this.id = sucursal;
		this.viajeCollection = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Sucursal[ sucursalId=" + id + " ]";
	}

}
