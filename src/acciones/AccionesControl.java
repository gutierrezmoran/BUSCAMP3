package acciones;

import controlador.Bridge;

public class AccionesControl {

	private Bridge bridge;

	public AccionesControl(Bridge bridge) {
		this.bridge = bridge;
	}

	public void buscar(String path) {
		this.bridge.getControl().realizarBusqueda(path);
	}

	public void actualizarListado() {
		this.bridge.vaciarListado();

		for (String path : this.bridge.getControl().getFicherosMP3()) {
			this.bridge.getListado().setText(this.bridge.getListado().getText() + path + "\r\n");
		}
	}

	public void actualizarRecorrido() {
		this.bridge.vaciarRecorrido();

		for (String path : this.bridge.getControl().getBusqueda()) {
			this.bridge.getRecorrido().setText(this.bridge.getRecorrido().getText() + path + "\r\n");
		}
	}

	public boolean isPathEmpty() {
		return this.bridge.getPath().getText().equals("");
	}

	public void actualizarCantidadFicherosMP3() {
		this.bridge.getResultados().setText(String.valueOf(this.bridge.getControl().obtenerCantidadFicherosMP3()));
	}
	
}
