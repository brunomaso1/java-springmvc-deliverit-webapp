/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Direccion {

	private Integer id;

	private String calle;

	private short nroPuerta;

	private short apartamento;

	private String esquina;

	private Double latitud;

	private Double longitud;

	private Collection<Cliente> clienteCollection;

	private Collection<Sucursal> sucursalCollection;

	public Direccion() {
	}

	public Direccion(String calle, String nroPuerta, String apartamento, String esquina, Double latitud, Double longitud) {
		this.calle = calle;
		this.nroPuerta = Short.parseShort(nroPuerta);
		this.apartamento = Short.parseShort(apartamento);
		this.esquina = esquina;
		this.latitud = latitud;
		this.longitud = longitud;
		this.clienteCollection = new ArrayList<>();
		this.sucursalCollection = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public short getNroPuerta() {
		return nroPuerta;
	}

	public void setNroPuerta(short nroPuerta) {
		this.nroPuerta = nroPuerta;
	}

	public String getEsquina() {
		return esquina;
	}

	public void setEsquina(String esquina) {
		this.esquina = esquina;
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

	public short getApartamento() {
		return apartamento;
	}

	public void setApartamento(short apartamento) {
		this.apartamento = apartamento;
	}

	public Collection<Cliente> getClienteCollection() {
		return clienteCollection;
	}

	public void setClienteCollection(Collection<Cliente> clienteCollection) {
		this.clienteCollection = clienteCollection;
	}

	public Collection<Sucursal> getSucursalCollection() {
		return sucursalCollection;
	}

	public void setSucursalCollection(Collection<Sucursal> sucursalCollection) {
		this.sucursalCollection = sucursalCollection;
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
		if (!(object instanceof Direccion)) {
			return false;
		}
		Direccion other = (Direccion) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Direccion[ id=" + id + " ]";
	}

}
