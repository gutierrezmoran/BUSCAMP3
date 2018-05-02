package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBuscar implements ActionListener{
	
	private Bridge bridge;
	
	public ActionBuscar(Bridge bridge) {
		this.bridge = bridge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.bridge.getAccionesControl().buscar(this.bridge.getPath().getText());
		this.bridge.getAccionesControl().actualizarListado();
		this.bridge.getAccionesControl().actualizarCantidadFicherosMP3();
	}

}
