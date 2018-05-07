package controlador.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingWorker;

import controlador.Bridge;

public class ActionBuscar implements ActionListener{
	
	private Bridge bridge;
	
	public ActionBuscar(Bridge bridge) {
		this.bridge = bridge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				bridge.getAccionesControl().buscar(bridge.getPath().getText(), bridge.getFormatos().getSelection().getActionCommand());
				bridge.getAccionesControl().actualizarBusqueda();
				bridge.getAccionesControl().actualizarCantidadFicherosMP3();
				bridge.getProgreso().setIndeterminate(false);
				bridge.getBuscar().setEnabled(true);
				bridge.getExportar().setEnabled(true);
				return null;
			}
			
		};

		if(!this.bridge.isPathEmpty()) {
			this.bridge.getProgreso().setIndeterminate(true);
			this.bridge.getBuscar().setEnabled(false);
			this.bridge.getExportar().setEnabled(false);
			worker.execute();
		}
	}

}
