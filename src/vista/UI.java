package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UI extends JFrame {

	protected JPanel contentPane;
	protected JTextField path;
	protected JButton buscar;
	protected JLabel resultados;
	protected JTextArea listado;

	public UI() {
		setTitle("Buscador MP3");
		setMinimumSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TabbedPane.light"));
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelInferior.setOpaque(false);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new BorderLayout(10, 0));
		
		JPanel panelPath = new JPanel();
		panelInferior.add(panelPath, BorderLayout.CENTER);
		panelPath.setLayout(new BorderLayout(0, 2));
		
		JLabel lblRutaDeBsqueda = new JLabel("Ruta de b\u00FAsqueda");
		lblRutaDeBsqueda.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelPath.add(lblRutaDeBsqueda, BorderLayout.NORTH);
		
		path = new JTextField();
		panelPath.add(path, BorderLayout.SOUTH);
		path.setColumns(10);
		
		buscar = new JButton("Buscar");
		buscar.setBorderPainted(false);
		buscar.setBackground(UIManager.getColor("ScrollBar.thumbDarkShadow"));
		buscar.setBorder(new EmptyBorder(10, 15, 10, 15));
		buscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelInferior.add(buscar, BorderLayout.EAST);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		listado = new JTextArea();
		listado.setEditable(false);
		panelCentral.add(listado);
		
		JPanel panelCantidad = new JPanel();
		panelCantidad.setBackground(Color.LIGHT_GRAY);
		panelCantidad.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCentral.add(panelCantidad, BorderLayout.SOUTH);
		panelCantidad.setLayout(new BorderLayout(5, 0));
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBorder(new EmptyBorder(2, 2, 2, 2));
		lblResultados.setBackground(SystemColor.inactiveCaption);
		lblResultados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		panelCantidad.add(lblResultados, BorderLayout.WEST);
		
		resultados = new JLabel("");
		panelCantidad.add(resultados, BorderLayout.CENTER);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(new MatteBorder(0, 0, 3, 0, (Color) UIManager.getColor("List.selectionBackground")));
		panelSuperior.setBackground(SystemColor.activeCaption);
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBuscadorDeArchivos = new JLabel("Buscador MP3");
		lblBuscadorDeArchivos.setForeground(Color.WHITE);
		lblBuscadorDeArchivos.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscadorDeArchivos.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblBuscadorDeArchivos.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelSuperior.add(lblBuscadorDeArchivos, BorderLayout.NORTH);
	}
	
	public void vaciarListado() {
		this.listado.setText("");
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getPath() {
		return path;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public JLabel getResultados() {
		return resultados;
	}

	public JTextArea getListado() {
		return listado;
	}

}
