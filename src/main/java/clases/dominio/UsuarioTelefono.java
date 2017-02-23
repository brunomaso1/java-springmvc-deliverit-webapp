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
public class UsuarioTelefono  {
  
    protected UsuarioTelefonoPK usuarioTelefonoPK;
    
    private Usuario usuario1;

    public UsuarioTelefono() {
    }

    public UsuarioTelefono(UsuarioTelefonoPK usuarioTelefonoPK) {
        this.usuarioTelefonoPK = usuarioTelefonoPK;
    }

    public UsuarioTelefono(int usuario, String telefono) {
        this.usuarioTelefonoPK = new UsuarioTelefonoPK(usuario, telefono);
    }

    public UsuarioTelefonoPK getUsuarioTelefonoPK() {
        return usuarioTelefonoPK;
    }

    public void setUsuarioTelefonoPK(UsuarioTelefonoPK usuarioTelefonoPK) {
        this.usuarioTelefonoPK = usuarioTelefonoPK;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioTelefonoPK != null ? usuarioTelefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTelefono)) {
            return false;
        }
        UsuarioTelefono other = (UsuarioTelefono) object;
        if ((this.usuarioTelefonoPK == null && other.usuarioTelefonoPK != null) || (this.usuarioTelefonoPK != null && !this.usuarioTelefonoPK.equals(other.usuarioTelefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucu.deliverit.backcore.entidades.UsuarioTelefono[ usuarioTelefonoPK=" + usuarioTelefonoPK + " ]";
    }
    
}