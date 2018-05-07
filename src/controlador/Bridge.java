package controlador;

import java.util.ArrayList;
import acciones.AccionesControl;
import acciones.AccionesExportar;
import acciones.AccionesLimpiar;
import controlador.action.ActionBuscar;
import controlador.action.ActionExportar;
import controlador.action.ActionLimpiar;
import modelo.Buscador;
import vista.UI;

public class Bridge extends UI {

	private Buscador buscador;
	private AccionesControl accionesControl;
	private AccionesLimpiar accionesLimpiar;
	private AccionesExportar accionesExportar;

	public Bridge() {
		this.buscador = new Buscador();
		this.accionesControl = new AccionesControl(this);
		this.accionesLimpiar = new AccionesLimpiar(this);
		this.accionesExportar = new AccionesExportar(this);
		establecerActionListener();
		this.accionesControl.actualizarCantidadFicherosMP3();
	}

	public void establecerActionListener() {
		establecerActionBuscar();
		establecerActionLimpiar();
		establecerActionExportar();
	}

	public void establecerActionBuscar() {
		buscar.addActionListener(new ActionBuscar(this));
	}

	public void establecerActionLimpiar() {
		limpiar.addActionListener(new ActionLimpiar(this));
	}

	public void establecerActionExportar() {
		exportar.addActionListener(new ActionExportar(this));
	}

	public Buscador getBuscador() {
		return buscador;
	}

	public AccionesControl getAccionesControl() {
		return accionesControl;
	}

	public AccionesLimpiar getAccionesLimpiar() {
		return accionesLimpiar;
	}

	public AccionesExportar getAccionesExportar() {
		return accionesExportar;
	}

	public void buscar(String path, String formato) {
		buscador.buscar(path, formato);
	}

	public void actualizarCantidadFicherosMP3() {
		accionesControl.actualizarCantidadFicherosMP3();
	}

	public boolean isFormato(String path) {
		return buscador.isFormato(path);
	}

	public void limpiarBusqueda() {
		buscador.limpiarBusqueda();
	}

	public ArrayList<String> getBusqueda() {
		return buscador.getBusqueda();
	}

	public int obtenerEncontrados() {
		return buscador.obtenerEncontrados();
	}

}
