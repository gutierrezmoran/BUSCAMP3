package controlador;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

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
				bridge.getAccionesControl().buscar(bridge.getPath().getText());
				bridge.getAccionesControl().actualizarListado();
				bridge.getAccionesControl().actualizarRecorrido();
				bridge.getAccionesControl().actualizarCantidadFicherosMP3();
				bridge.getControl().limpiarFicherosMP3();
				bridge.getProgreso().setIndeterminate(false);
				return null;
			}
			
		};

		if(!this.bridge.getAccionesControl().isPathEmpty()) {
			this.bridge.getProgreso().setIndeterminate(true);
			worker.execute();
		}
	}

}
