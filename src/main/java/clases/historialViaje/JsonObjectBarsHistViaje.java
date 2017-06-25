package clases.historialViaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonObjectBarsHistViaje {

	private String anioMes;
	private Integer costo;

	public JsonObjectBarsHistViaje() {
	}

	public JsonObjectBarsHistViaje(String anioMes, Integer costo) {
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

	public List<JsonObjectBarsHistViaje> mapToJSON(Map<String, Integer> map) {
		List<JsonObjectBarsHistViaje> jsonObjectBarsList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectBarsList.add(new JsonObjectBarsHistViaje(k, v)));
		return jsonObjectBarsList;
	}
}
