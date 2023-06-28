package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.ConsultarCerámico;
import mantenimiento.ListarCeramicos;
import mantenimiento.ModificarCerámico;
import ventas.Vender;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.ImagingOpException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame implements ActionListener {

	private boolean isConsultaCeramicoAbierto, isModificarCeramicoAbierto, isListarCeramico, isVender= false;// Variable para verificar si el JInternalFrame está abierto
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmModificarCeramico;
	private JMenuItem mntmListarCermicos;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmAcercaDeTienda;
	private JDesktopPane Escritorio;
	private JMenuItem mntmConsultarCeramico;
	
	// Datos mínimos del primer producto
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;
	// Datos mínimos del segundo producto
	public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;
	// Datos mínimos del tercer producto
	public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;
	// Datos mínimos del cuarto producto
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;
	// Datos mínimos del quinto producto
	public static String modelo4 = "Thalía";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	private JLabel lblFondo;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH); //MAXIMIZAR LA VENTANA PRINCIPAL
					frame.setLocationRelativeTo(null); //centrar ventana
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setBackground(Color.WHITE);
		setTitle("Venta de Ceramicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 443);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(53, 54, 58));
		menuBar.setForeground(new Color(128, 128, 128));
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.setBorder(null);
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setBorder(null);
		mnArchivo.setBackground(new Color(53, 54, 58));
		mnArchivo.setForeground(new Color(216, 215, 221));
		mnArchivo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setBorder(null);
		mntmSalir.setBackground(new Color(53, 54, 58));
		mntmSalir.setForeground(new Color(216, 215, 221));
		mntmSalir.addActionListener(this);
		mntmSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setBorder(null);
		mnMantenimiento.setForeground(new Color(216, 215, 221));
		mnMantenimiento.setBackground(new Color(53, 54, 58));
		mnMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCeramico = new JMenuItem("Consultar cer\u00E1mico");
		mntmConsultarCeramico.setBorder(null);
		mntmConsultarCeramico.setBackground(new Color(53, 54, 58));
		mntmConsultarCeramico.setForeground(new Color(216, 215, 221));
		mntmConsultarCeramico.addActionListener(this);
		mntmConsultarCeramico.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnMantenimiento.add(mntmConsultarCeramico);
		
		mntmModificarCeramico = new JMenuItem("Modificar cer\u00E1mico");
		mntmModificarCeramico.setBorder(null);
		mntmModificarCeramico.setBackground(new Color(53, 54, 58));
		mntmModificarCeramico.setForeground(new Color(216, 215, 221));
		mntmModificarCeramico.addActionListener(this);
		mntmModificarCeramico.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnMantenimiento.add(mntmModificarCeramico);
		
		mntmListarCermicos = new JMenuItem("Listar cer\u00E1micos");
		mntmListarCermicos.setBorder(null);
		mntmListarCermicos.setBackground(new Color(53, 54, 58));
		mntmListarCermicos.setForeground(new Color(216, 215, 221));
		mntmListarCermicos.addActionListener(this);
		mntmListarCermicos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnMantenimiento.add(mntmListarCermicos);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setBorder(null);
		mnVentas.setForeground(new Color(216, 215, 221));
		mnVentas.setBackground(new Color(53, 54, 58));
		mnVentas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mntmVender.setBorder(null);
		mntmVender.setBackground(new Color(53, 54, 58));
		mntmVender.setForeground(new Color(216, 215, 221));
		mntmVender.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.setBorder(null);
		mntmGenerarReportes.setBackground(new Color(53, 54, 58));
		mntmGenerarReportes.setForeground(new Color(216, 215, 221));
		mntmGenerarReportes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		mnConfiguracion.setBorder(null);
		mnConfiguracion.setBackground(new Color(53, 54, 58));
		mnConfiguracion.setForeground(new Color(216, 215, 221));
		mnConfiguracion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.setBorder(null);
		mntmConfigurarDescuentos.setBackground(new Color(53, 54, 58));
		mntmConfigurarDescuentos.setForeground(new Color(216, 215, 221));
		mntmConfigurarDescuentos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.setBorder(null);
		mntmConfigurarObsequios.setBackground(new Color(53, 54, 58));
		mntmConfigurarObsequios.setForeground(new Color(216, 215, 221));
		mntmConfigurarObsequios.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarCantidadptima.setBorder(null);
		mntmConfigurarCantidadptima.setBackground(new Color(53, 54, 58));
		mntmConfigurarCantidadptima.setForeground(new Color(216, 215, 221));
		mntmConfigurarCantidadptima.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnConfiguracion.add(mntmConfigurarCantidadptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.setBorder(null);
		mntmConfigurarCuotaDiaria.setBackground(new Color(53, 54, 58));
		mntmConfigurarCuotaDiaria.setForeground(new Color(216, 215, 221));
		mntmConfigurarCuotaDiaria.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setBorder(null);
		mnAyuda.setBackground(new Color(53, 54, 58));
		mnAyuda.setForeground(new Color(216, 215, 221));
		mnAyuda.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.setBorder(null);
		mntmAcercaDeTienda.setBackground(new Color(53, 54, 58));
		mntmAcercaDeTienda.setForeground(new Color(216, 215, 221));
		mntmAcercaDeTienda.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(68, 70, 83));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Escritorio = new JDesktopPane();
		Escritorio.setOpaque(false); // Establece la opacidad en falso
		Escritorio.setBackground(new Color(0, 0, 0, 0)); // Establece el color de fondo transparente
		contentPane.add(Escritorio, BorderLayout.CENTER);
		
		
	
	}

	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmVender) {
			actionPerformedMntmVender(arg0);
		}
		if (arg0.getSource() == mntmListarCermicos) {
			actionPerformedMntmListarCermicos(arg0);
		}
		if (arg0.getSource() == mntmModificarCeramico) {
			actionPerformedMntmModificarCeramico(arg0);
		}
		if (arg0.getSource() == mntmConsultarCeramico) {
			actionPerformedMntmConsultarCeramico(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0); //OPCION DE SALIR
	//Mantenimineto
	}
	protected void actionPerformedMntmConsultarCeramico(ActionEvent arg0) {
		if (!isConsultaCeramicoAbierto) { // Verificar si el JInternalFrame ya está abierto
		ConsultarCerámico clo=new ConsultarCerámico();
		Dimension desktopSize=Escritorio.getSize();
		Dimension FrameSize=clo.getSize();
		clo.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		Escritorio.add(clo);
		clo.setVisible(true);
	}
}
	
	protected void actionPerformedMntmModificarCeramico(ActionEvent arg0) {
		if (!isModificarCeramicoAbierto){ // Verificar si el JInternalFrame ya está abierto
			ModificarCerámico mrc=new ModificarCerámico();
			Dimension desktopSize=Escritorio.getSize();
			Dimension FrameSize=mrc.getSize();
			mrc.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
			Escritorio.add(mrc);
			mrc.setVisible(true);
		}
}

	protected void actionPerformedMntmListarCermicos(ActionEvent arg0) {
		if (!isListarCeramico){ // Verificar si el JInternalFrame ya está abierto
			ListarCeramicos mrc=new ListarCeramicos();
			Dimension desktopSize=Escritorio.getSize();
			Dimension FrameSize=mrc.getSize();
			mrc.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
			Escritorio.add(mrc);
			mrc.setVisible(true);
		}
		
	}
	protected void actionPerformedMntmVender(ActionEvent arg0) {
		if (!isVender){ // Verificar si el JInternalFrame ya está abierto
			Vender vnd=new Vender();
			Dimension desktopSize=Escritorio.getSize();
			Dimension FrameSize=vnd.getSize();
			vnd.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
			Escritorio.add(vnd);
			vnd.setVisible(true);
	}
		}
	



}
