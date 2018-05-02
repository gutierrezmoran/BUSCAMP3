package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Control {
	private File file;
	private ArrayList<File> ficheros;
	private ArrayList<String> ficherosMP3;
	private ArrayList<String> busqueda;
	
	public Control() {
		this.ficherosMP3 = new ArrayList<>();
		this.ficheros = new ArrayList<>();
		this.busqueda = new ArrayList<>();
	}
	
	private void crear(String path) {
		this.file = new File(path);
	}
	
	private void buscar(File file) {
		if (file.isDirectory()) {
			for (int i = 0; i < file.listFiles().length; i++) {
				try {
					if(isRutaValida(file)) {
						this.busqueda.add(file.getCanonicalPath());
					}
				} catch (IOException e) {
					this.busqueda.add("Error al obtener la ruta del directorio");
				}
				buscar(file.listFiles()[i]);
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
	
	private boolean isMp3(File file) {
		return file.getName().toLowerCase().endsWith(".mp3");
	}
	
	private boolean isFileValido(File file) {
		return isMp3(file) && !isRepetido(file);
	}
	
	private boolean isRutaValida(File file) {
		for (String path : this.busqueda) {
			try {
				if(path == file.getCanonicalPath()) {
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();
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
				
			}
		}
		return false;
	}

	private void buscarMP3() {
		for (File file : this.ficheros) {
			if(isFileValido(file)) {
				try {
					this.ficherosMP3.add(file.getCanonicalPath());
				} catch (IOException e) {
					
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
	
	public void realizarBusqueda(String path) {
		crear(path);
		buscar(this.file);
		buscarMP3();
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
