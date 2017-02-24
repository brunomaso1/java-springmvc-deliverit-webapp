/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author JMArtegoytia
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ubicacion {

	private Short id;

	private Double latitud;

	private Double longitud;

	private Delivery delivery;

	public Ubicacion() {
	}

	public Ubicacion(Short id, Double latitud, Double longitud, Delivery delivery) {
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.delivery = delivery;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
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
		if (!(object instanceof Ubicacion)) {
			return false;
		}
		Ubicacion other = (Ubicacion) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Ubicacion[ id=" + id + " ]";
	}

}
