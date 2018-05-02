package acciones;

import controlador.Bridge;

public class AccionesLimpiar {
	
	private Bridge bridge;

	public AccionesLimpiar(Bridge bridge) {
		super();
		this.bridge = bridge;
	}
	
	public void limpiarBusqueda() {
		this.bridge.getControl().limpiarFicherosMP3();
		this.bridge.vaciarListado();
		this.bridge.getAccionesControl().actualizarCantidadFicherosMP3();
		
		this.bridge.getControl().limpiarRecorrido();
		this.bridge.vaciarRecorrido();
	}
	
}
