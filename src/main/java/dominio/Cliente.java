/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente {
    
    private Integer id;
    
    private String nombre;
    
    private Direccion direccion;
    
    private Collection<Pedido> pedidoCollection;
    
    private Collection<ClienteTelefono> clienteTelefonoCollection;

    public Cliente() {
    }

	public Cliente(Integer id, String nombre, Direccion direccion, Collection<Pedido> pedidoCollection, Collection<ClienteTelefono> clienteTelefonoCollection) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pedidoCollection = pedidoCollection;
		this.clienteTelefonoCollection = clienteTelefonoCollection;
	}
	

    public Cliente(Integer id) {
        this.id = id;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public Collection<ClienteTelefono> getClienteTelefonoCollection() {
        return clienteTelefonoCollection;
    }

    public void setClienteTelefonoCollection(Collection<ClienteTelefono> clienteTelefonoCollection) {
        this.clienteTelefonoCollection = clienteTelefonoCollection;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucu.deliverit.backcore.entidades.Cliente[ id=" + id + " ]";
    }
    
}