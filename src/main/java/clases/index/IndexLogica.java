package clases.index;

import clases.dominio.Restaurant;
import clases.dominio.Sucursal;

public class IndexLogica {

	private String tipo;
	
	private String pass;
	
	private Restaurant restaurant;
	
	private Sucursal sucursal;
	
	private String userName;
	
	private IndexFormBean bean;

	public IndexLogica(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}

	public IndexLogica(IndexFormBean bean) {
		this.bean = bean;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Restaurant registrarRestaurant() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean loginValido() {
		//Obtiene o crea la entidad Restaurant y/o Sucursal.
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}