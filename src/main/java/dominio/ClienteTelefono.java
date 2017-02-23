/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author JMArtegoytia
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteTelefono  {
	
    protected ClienteTelefonoPK clienteTelefonoPK;
  
    private Cliente cliente;

    public ClienteTelefono() {
    }

	public ClienteTelefono(ClienteTelefonoPK clienteTelefonoPK, Cliente cliente1) {
		this.clienteTelefonoPK = clienteTelefonoPK;
		this.cliente = cliente1;
	}
	

    public ClienteTelefono(ClienteTelefonoPK clienteTelefonoPK) {
        this.clienteTelefonoPK = clienteTelefonoPK;
    }

    public ClienteTelefono(int cliente, String telefono) {
        this.clienteTelefonoPK = new ClienteTelefonoPK(cliente, telefono);
    }

    public ClienteTelefonoPK getClienteTelefonoPK() {
        return clienteTelefonoPK;
    }

    public void setClienteTelefonoPK(ClienteTelefonoPK clienteTelefonoPK) {
        this.clienteTelefonoPK = clienteTelefonoPK;
    }

    public Cliente getCliente1() {
        return cliente;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente = cliente1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteTelefonoPK != null ? clienteTelefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTelefono)) {
            return false;
        }
        ClienteTelefono other = (ClienteTelefono) object;
        if ((this.clienteTelefonoPK == null && other.clienteTelefonoPK != null) || (this.clienteTelefonoPK != null && !this.clienteTelefonoPK.equals(other.clienteTelefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucu.deliverit.backcore.entidades.ClienteTelefono[ clienteTelefonoPK=" + clienteTelefonoPK + " ]";
    }
    
}
