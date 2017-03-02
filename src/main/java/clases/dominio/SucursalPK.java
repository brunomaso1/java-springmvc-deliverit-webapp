package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SucursalPK  {

    private short id;

    private int restaurant;

    public SucursalPK() {
    }

    public SucursalPK(short id, int restaurant) {
        this.id = id;
        this.restaurant = restaurant;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) restaurant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SucursalPK)) {
            return false;
        }
        SucursalPK other = (SucursalPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.restaurant != other.restaurant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucu.deliverit.backcore.entidades.SucursalPK[ id=" + id + ", restaurant=" + restaurant + " ]";
    }
    
}