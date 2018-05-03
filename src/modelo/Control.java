package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Control {
	private File file;
	private ArrayList<File> ficheros;
	private ArrayList<String> ficherosMP3;
	private ArrayList<String> busqueda;
	private String formatoBuscado;
	
	public Control() {
		this.ficherosMP3 = new ArrayList<>();
		this.ficheros = new ArrayList<>();
		this.busqueda = new ArrayList<>();
	}
	
	private void crear(String path, String formato) {
		this.file = new File(path);
		this.formatoBuscado = formato;
	}
	
	private void buscar(File file) {
		if (file.isDirectory()) {
			for (int i = 0; i < file.listFiles().length; i++) {
				try {
					if(isRutaValida(file)) {
						this.busqueda.add(file.getCanonicalPath());
					}
					
					buscar(file.listFiles()[i]);
				} catch (IOException e) {
					this.busqueda.add("Error al obtener la ruta del directorio");
				}
			}
		} else {
			try {
				if(isRutaValida(file)) {
					this.busqueda.add(file.getCanonicalPath());
				}
			} catch (IOException e) {
				this.busqueda.add("Error al obtener la ruta del fichero");
			}
			this.ficheros.add(file);
		}
	}
	
	private boolean isFormato(File file) {
		return file.getName().toLowerCase().endsWith(this.formatoBuscado);
	}
	
	private boolean isFileValido(File file) {
		return isFormato(file) && !isRepetido(file);
	}
	
	private boolean isRutaValida(File file) {
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
	
	private boolean isRepetido(File file) {
		for (String fileMP3 : this.ficherosMP3) {
			try {
				if(file.getCanonicalPath() == fileMP3) {
					return true;
				}
			} catch (IOException e) {
				return false;
			}
		}
		return false;
	}

	private void buscarFormato() {
		for (File file : this.ficheros) {
			if(isFileValido(file)) {
				try {
					this.ficherosMP3.add(file.getCanonicalPath());
				} catch (IOException e) {
					this.ficherosMP3.add("Error al obtener la ruta del fichero");
				}
			}
		}
	}
	
	private void borrarInstanciaFile() {
		this.file = null;
	}
	
	public void limpiarFicherosMP3() {
		this.ficherosMP3.clear();
	}
	
	public void limpiarRecorrido() {
		this.busqueda.clear();
	}
	
	public void realizarBusqueda(String path, String formato) {
		crear(path, formato);
		buscar(this.file);
		buscarFormato();
		borrarInstanciaFile();
	}
	
	public int obtenerCantidadFicherosMP3() {
		return this.ficherosMP3.size();
	}

	public ArrayList<String> getFicherosMP3() {
		return ficherosMP3;
	}

	public ArrayList<String> getBusqueda() {
		return busqueda;
	}

}
