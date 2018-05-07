package controlador.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Bridge;

public class ActionLimpiar implements ActionListener {

	private Bridge bridge;

	public ActionLimpiar(Bridge bridge) {
		super();
		this.bridge = bridge;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.bridge.getAccionesLimpiar().limpiarBusqueda();
	}
	
}
