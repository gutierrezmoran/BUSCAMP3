package controlador;

import acciones.AccionesControl;
import acciones.AccionesExportar;
import acciones.AccionesLimpiar;
import modelo.Control;
import vista.UI;

public class Bridge extends UI {

	private Control control;
	private AccionesControl accionesControl;
	private AccionesLimpiar accionesLimpiar;
	private AccionesExportar accionesExportar;
	
	public Bridge() {
		this.control = new Control();
		this.accionesControl = new AccionesControl(this);
		this.accionesLimpiar = new AccionesLimpiar(this);
		this.accionesExportar = new AccionesExportar(this);
		establecerActionListener();
		this.accionesControl.actualizarCantidadFicherosMP3();
	}
	
	public void establecerActionListener() {
		establecerActionBuscar();
		establecerActionLimpiar();
		establecerActionExportar();
	}
	
	public void establecerActionBuscar() {
		buscar.addActionListener(new ActionBuscar(this));
	}
	
	public void establecerActionLimpiar() {
		limpiar.addActionListener(new ActionLimpiar(this));
	}
	
	public void establecerActionExportar() {
		exportar.addActionListener(new ActionExportar(this));
	}

	public Control getControl() {
		return control;
	}

	public AccionesControl getAccionesControl() {
		return accionesControl;
	}

	public AccionesLimpiar getAccionesLimpiar() {
		return accionesLimpiar;
	}

	public AccionesExportar getAccionesExportar() {
		return accionesExportar;
	}

	public void realizarBusqueda(String path, String formato) {
		control.realizarBusqueda(path, formato);
	}

	public void limpiarFicherosMP3() {
		control.limpiarFicherosMP3();
	}

	public void limpiarRecorrido() {
		control.limpiarRecorrido();
	}

	public void actualizarCantidadFicherosMP3() {
		accionesControl.actualizarCantidadFicherosMP3();
	}

}
