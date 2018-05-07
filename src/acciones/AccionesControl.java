package acciones;

import controlador.Bridge;
import modelo.Buscador;

public class AccionesControl {

	private Bridge bridge;

	public AccionesControl(Bridge bridge) {
		this.bridge = bridge;
	}

	public void buscar(String path, String formato) {
		this.bridge.buscar(path, formato);
	}

	public void actualizarResultado() {
		this.bridge.vaciarResultado();

		for (String path : this.bridge.getBusqueda()) {
			if(this.bridge.isFormato(path)) {
				this.bridge.getResultado().setText(this.bridge.getResultado().getText() + path + "\r\n");
			}
		}
	}

	public void actualizarTraza() {
		this.bridge.vaciarTraza();

		for (String path : this.bridge.getBusqueda()) {
			this.bridge.getTraza().setText(this.bridge.getTraza().getText() + path + "\r\n");
		}
	}
	
	public void actualizarBusqueda() {
		actualizarResultado();
		actualizarTraza();
	}

	public void actualizarCantidadFicherosMP3() {
		this.bridge.getResultados().setText(String.valueOf(this.bridge.obtenerEncontrados()));
	}
	
}
