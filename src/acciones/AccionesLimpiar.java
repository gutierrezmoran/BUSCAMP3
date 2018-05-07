package acciones;

import controlador.Bridge;

public class AccionesLimpiar {
	
	private Bridge bridge;

	public AccionesLimpiar(Bridge bridge) {
		super();
		this.bridge = bridge;
	}
	
	public void limpiarBusqueda() {
		this.bridge.vaciarResultado();
		this.bridge.limpiarBusqueda();
		this.bridge.vaciarTraza();
		this.bridge.actualizarCantidadFicherosMP3();
	}
	
}
