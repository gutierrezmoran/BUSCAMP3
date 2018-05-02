package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Control {
	private File file;
	private File[] ficheros;
	private ArrayList<String> ficherosMP3;
	
	public Control() {
		this.ficherosMP3 = new ArrayList<>();
	}
	
	private void crear(String path) {
		this.file = new File(path);
	}
	
	private void buscar() {
		this.ficheros = this.file.listFiles();
	}
	
	private void buscarMP3() {
		for (File file : this.ficheros) {
			if(file.getName().endsWith(".mp3")) {
				try {
					this.ficherosMP3.add(file.getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void borrarInstanciaFile() {
		this.file = null;
	}
	
	public void buscar(String path) {
		crear(path);
		buscar();
		buscarMP3();
		borrarInstanciaFile();
	}

	public ArrayList<String> getFicherosMP3() {
		return ficherosMP3;
	}
	
	public int obtenerCantidadFicherosMP3() {
		return this.ficherosMP3.size();
	}

}
