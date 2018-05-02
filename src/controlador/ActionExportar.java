package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionExportar implements ActionListener {
	
	private Bridge bridge;
	
	public ActionExportar(Bridge bridge) {
		this.bridge = bridge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.bridge.getAccionesExportar().exportarBusqueda()) {
			//TODO Cuando sale bien
		} else {
			//TODO Cuando sale mal
		}
	}
}
