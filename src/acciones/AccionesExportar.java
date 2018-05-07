package acciones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import controlador.Bridge;

public class AccionesExportar {
	private Bridge bridge;

	public AccionesExportar(Bridge bridge) {
		this.bridge = bridge;
	}

	private String obtenerHora() {
		return String.valueOf(LocalDateTime.now().getYear()) + String.valueOf(LocalDateTime.now().getMonthValue())
				+ String.valueOf(LocalDateTime.now().getDayOfMonth()) + String.valueOf(LocalDateTime.now().getHour())
				+ String.valueOf(LocalDateTime.now().getMinute()) + String.valueOf(LocalDateTime.now().getSecond())
				+ String.valueOf(LocalDateTime.now().getNano());
	}

	public boolean exportarBusqueda() {
		String ruta = "busquedaMP3Exportada" + obtenerHora() + ".txt";
		File fichero = new File(ruta);
		BufferedWriter bw;

		try {
			bw = new BufferedWriter(new FileWriter(fichero));
			bw.write(this.bridge.getResultado().getText());
			bw.close();
			return true;

		} catch (IOException e) {
			return false;
		}
	}

}
