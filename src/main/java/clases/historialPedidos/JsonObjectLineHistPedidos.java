package clases.historialPedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonObjectLineHistPedidos {

	private String anioMes;
	private Integer pedidos;

	public JsonObjectLineHistPedidos() {
	}

	public JsonObjectLineHistPedidos(String anioMes, Integer pedidos) {
		this.anioMes = anioMes;
		this.pedidos = pedidos;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public Integer getPedidos() {
		return pedidos;
	}

	public void setPedidos(Integer pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList mapToArrayList (Map<String, Integer> map) {
		ArrayList jsonObjectLineList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectLineList.add(new JsonObjectLineHistPedidos(k, v)));
		return jsonObjectLineList;
	}
}