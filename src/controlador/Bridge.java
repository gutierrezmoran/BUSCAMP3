package controlador;

import acciones.AccionesControl;
import modelo.Control;
import vista.UI;

public class Bridge extends UI {

	private Control control;
	private AccionesControl accionesControl;
	
	public Bridge() {
		this.control = new Control();
		this.accionesControl = new AccionesControl(this);
		establecerActionBuscar();
		this.accionesControl.actualizarCantidadFicherosMP3();
	}
	
	public void establecerActionBuscar() {
		buscar.addActionListener(new ActionBuscar(this));
	}

	public Control getControl() {
		return control;
	}

	public AccionesControl getAccionesControl() {
		return accionesControl;
	}

}
