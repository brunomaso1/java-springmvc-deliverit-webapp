package clases.historialPedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonObjectBarsHistPedidos {

	private String anioMes;
	private Integer costo;

	public JsonObjectBarsHistPedidos() {
	}

	public JsonObjectBarsHistPedidos(String anioMes, Integer costo) {
		this.anioMes = anioMes;
		this.costo = costo;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public ArrayList mapToJSON(Map<String, Integer> map) {
		ArrayList jsonObjectBarsList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectBarsList.add(new JsonObjectBarsHistPedidos(k, v)));
		return jsonObjectBarsList;
	}
}