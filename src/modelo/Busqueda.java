package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Busqueda {
	
	private ArrayList<String> busqueda;
	
	public Busqueda() {
		this.busqueda = new ArrayList<>();
	}
	
	public void agregar(File file) {
		try {
			this.busqueda.add(file.getCanonicalPath());
		} catch (IOException e) {
			this.busqueda.add("Error al obtener la ruta del fichero");
		}
	}
	
	public void limpiar() {
		this.busqueda.clear();
	}
	
	public boolean isValido(File file) {
		for (String path : this.busqueda) {
			try {
				if(path == file.getCanonicalPath()) {
					return false;
				}
			} catch (IOException e) {
				return false;
			}
		}

		return true;
	}
	
	public ArrayList<String> getBusqueda() {
		return busqueda;
	}

}
