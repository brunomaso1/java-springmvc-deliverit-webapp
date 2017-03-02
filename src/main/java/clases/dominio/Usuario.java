package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

	private Integer id;

	private String nombre;

	private String password;

	private String mail;

	private String telefono;

	private int cuentaRedPagos;

	private byte[] foto;

	private Collection<Delivery> deliveryCollection;

	private Collection<Restaurant> restaurantCollection;

	public Usuario() {
	}

	public Usuario(Integer id, String nombre, String password, String mail, String telefono, int cuentaRedPagos, byte[] foto, Collection<Delivery> deliveryCollection, Collection<Restaurant> restaurantCollection) {
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.mail = mail;
		this.telefono = telefono;
		this.cuentaRedPagos = cuentaRedPagos;
		this.foto = foto;
		this.deliveryCollection = deliveryCollection;
		this.restaurantCollection = restaurantCollection;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCuentaRedPagos() {
		return cuentaRedPagos;
	}

	public void setCuentaRedPagos(int cuentaRedPagos) {
		this.cuentaRedPagos = cuentaRedPagos;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Collection<Delivery> getDeliveryCollection() {
		return deliveryCollection;
	}

	public void setDeliveryCollection(Collection<Delivery> deliveryCollection) {
		this.deliveryCollection = deliveryCollection;
	}

	public Collection<Restaurant> getRestaurantCollection() {
		return restaurantCollection;
	}

	public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
		this.restaurantCollection = restaurantCollection;
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
		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Usuario[ id=" + id + " ]";
	}

}
