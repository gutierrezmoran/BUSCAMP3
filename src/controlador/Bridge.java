package controlador;

import acciones.AccionesControl;
import acciones.AccionesLimpiar;
import modelo.Control;
import vista.UI;

public class Bridge extends UI {

	private Control control;
	private AccionesControl accionesControl;
	private AccionesLimpiar accionesLimpiar;
	
	public Bridge() {
		this.control = new Control();
		this.accionesControl = new AccionesControl(this);
		this.accionesLimpiar = new AccionesLimpiar(this);
		establecerActionListener();
		this.accionesControl.actualizarCantidadFicherosMP3();
	}
	
	public void establecerActionListener() {
		establecerActionBuscar();
		establecerActionLimpiar();
	}
	
	public void establecerActionBuscar() {
		buscar.addActionListener(new ActionBuscar(this));
	}
	
	public void establecerActionLimpiar() {
		limpiar.addActionListener(new ActionLimpiar(this));
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

}
