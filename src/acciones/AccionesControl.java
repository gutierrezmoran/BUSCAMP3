package acciones;

import controlador.Bridge;

public class AccionesControl {

	private Bridge bridge;

	public AccionesControl(Bridge bridge) {
		this.bridge = bridge;
	}

	public void buscar(String path) {
		this.bridge.getControl().buscar(path);
	}
	
	public void actualizarListado() {
		this.bridge.vaciarListado();

		for (String path : this.bridge.getControl().getFicherosMP3()) {
			this.bridge.getListado().setText(path + "\n\n");
		}
	}
	
	public void actualizarCantidadFicherosMP3() {
		this.bridge.getResultados().setText(String.valueOf(this.bridge.getControl().obtenerCantidadFicherosMP3()));
	}
}
