package modelo;

import java.io.File;
import java.util.ArrayList;

public class Buscador {

	private File file;
	private Busqueda busqueda;
	private String formato;

	public Buscador() {
		this.busqueda = new Busqueda();
	}

	private void crear(String path, String formato) {
		this.file = new File(path);
		this.formato = formato;
	}

	private void buscar(File file) {
		if (this.busqueda.isValido(file)) {
			this.busqueda.agregar(file);
		}

		if (file.isDirectory()) {
			for (File i : file.listFiles()) {
				buscar(i);
			}
		}
	}

	public void buscar(String path, String formato) {
		crear(path, formato);
		buscar(this.file);
	}

	public boolean isFormato(String path) {
		return path.toLowerCase().endsWith(this.formato);
	}

	public int obtenerEncontrados() {
		int c = 0;
		for (String i : this.busqueda.getBusqueda()) {
			if (isFormato(i)) {
				c++;
			}
		}
		return c;
	}

	public void limpiarBusqueda() {
		busqueda.limpiar();
	}

	public ArrayList<String> getBusqueda() {
		return busqueda.getBusqueda();
	}

}
