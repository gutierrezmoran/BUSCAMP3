package acciones;

import controlador.Bridge;

public class AccionesLimpiar {
	
	private Bridge bridge;

	public AccionesLimpiar(Bridge bridge) {
		super();
		this.bridge = bridge;
	}
	
	public void limpiarBusqueda() {
		this.bridge.limpiarFicherosMP3();
		this.bridge.vaciarListado();
		this.bridge.actualizarCantidadFicherosMP3();
		this.bridge.limpiarRecorrido();
		this.bridge.vaciarRecorrido();
	}
	
}
