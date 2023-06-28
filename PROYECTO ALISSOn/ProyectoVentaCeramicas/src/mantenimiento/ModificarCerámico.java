package mantenimiento;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;

import Principal.MenuPrincipal;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.RandomAccessFile;
import java.io.IOException;

import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ModificarCerámico extends JInternalFrame implements ActionListener, KeyListener {
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblLargo;
	private JLabel lblEspesor;
	private JLabel lblContenido;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;
	private JButton btnLimpiar;
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JButton btnSI;
	private JButton btnNO;

	RandomAccessFile randomAccessFile;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCerámico frame = new ModificarCerámico();
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
	public ModificarCerámico() {
		setBorder(new LineBorder(new Color(0, 0, 0), 6));
		getContentPane().setBackground(new Color(100, 130, 154));
		setIconifiable(true);
		setTitle("Modificar cer\u00E1mico");
		setBounds(100, 100, 517, 279);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("\u2023 Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(10, 21, 78, 25);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("\u2023 Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(10, 57, 92, 25);
		getContentPane().add(lblPrecio);
		
		lblAncho = new JLabel("\u2023 Ancho (cm)");
		lblAncho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAncho.setBounds(10, 93, 92, 25);
		getContentPane().add(lblAncho);
		
		lblLargo = new JLabel("\u2023 Largo (cm)");
		lblLargo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLargo.setBounds(10, 129, 92, 27);
		getContentPane().add(lblLargo);
		
		lblEspesor = new JLabel("\u2023 Espesor (mm)");
		lblEspesor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEspesor.setBounds(10, 167, 102, 31);
		getContentPane().add(lblEspesor);
		
		lblContenido = new JLabel("\u2023 Contenido");
		lblContenido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContenido.setBounds(10, 209, 92, 25);
		getContentPane().add(lblContenido);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE", "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		cboModelo.setToolTipText("");
		cboModelo.setForeground(SystemColor.textInactiveText);
		cboModelo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cboModelo.setBackground(new Color(191, 205, 217));
		cboModelo.setBounds(140, 17, 221, 26);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setEnabled(false);
		txtPrecio.setDisabledTextColor(new Color(120, 40, 31));
		txtPrecio.setCaretColor(Color.BLACK);
		txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(140, 57, 221, 25);
		getContentPane().add(txtPrecio);
		
		txtAncho = new JTextField();
		txtAncho.addKeyListener(this);
		txtAncho.setDisabledTextColor(new Color(120, 40, 31));
		txtAncho.setEnabled(false);
		txtAncho.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAncho.setColumns(10);
		txtAncho.setBounds(140, 93, 221, 25);
		getContentPane().add(txtAncho);
		
		txtLargo = new JTextField();
		txtLargo.addKeyListener(this);
		txtLargo.setDisabledTextColor(Color.BLACK);
		txtLargo.setEnabled(false);
		txtLargo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLargo.setColumns(10);
		txtLargo.setBounds(140, 130, 221, 25);
		getContentPane().add(txtLargo);
		
		txtEspesor = new JTextField();
		txtEspesor.addKeyListener(this);
		txtEspesor.setDisabledTextColor(Color.BLACK);
		txtEspesor.setEnabled(false);
		txtEspesor.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEspesor.setColumns(10);
		txtEspesor.setBounds(140, 170, 221, 25);
		getContentPane().add(txtEspesor);
		
		txtContenido = new JTextField();
		txtContenido.addKeyListener(this);
		txtContenido.setDisabledTextColor(Color.BLACK);
		txtContenido.setEnabled(false);
		txtContenido.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtContenido.setColumns(10);
		txtContenido.setBounds(140, 209, 221, 25);
		getContentPane().add(txtContenido);
		
		btnGrabar = new JButton("GRABAR");
		btnGrabar.addActionListener(this);
		btnGrabar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnGrabar.setBounds(371, 46, 109, 45);
		getContentPane().add(btnGrabar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnLimpiar.setBounds(371, 102, 109, 45);
		getContentPane().add(btnLimpiar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnCerrar.setBounds(371, 158, 109, 45);
		getContentPane().add(btnCerrar);
		
		btnSI = new JButton("");
		btnSI.setBackground(Color.WHITE);
		btnSI.addActionListener(this);
		btnSI.setBounds(400, 17, 22, 14);
		getContentPane().add(btnSI);
		
		btnNO = new JButton("");
		btnNO.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNO.addActionListener(this);
		btnNO.setBackground(Color.BLACK);
		btnNO.setBounds(422, 17, 22, 14);
		getContentPane().add(btnNO);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 505, 10);
		getContentPane().add(panel);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnNO) {
			actionPerformedBtnNO(arg0);
		}
		if (arg0.getSource() == btnSI) {
			actionPerformedBtnSI(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			actionPerformedCboModelo(arg0);
		}
	}
	protected void actionPerformedCboModelo(ActionEvent arg0) {
		
		switch (cboModelo.getSelectedIndex()){
		case 1:
			txtPrecio.setText(MenuPrincipal.precio0+"");
			txtPrecio.setForeground(new Color(120, 40, 31));
			lblPrecio.setForeground(new Color(120, 40, 31));
			txtPrecio.setDisabledTextColor(new Color(120, 40, 31));
			
			txtAncho.setText(MenuPrincipal.ancho0+"");
			txtAncho.setForeground(new Color(120, 40, 31));
			lblAncho.setForeground(new Color(120, 40, 31));
			txtAncho.setDisabledTextColor(new Color(120, 40, 31));
			
			txtLargo.setText(MenuPrincipal.largo0+"");
			txtLargo.setForeground(new Color(120, 40, 31));
			lblLargo.setForeground(new Color(120, 40, 31));
			txtLargo.setDisabledTextColor(new Color(120, 40, 31));
			
			txtEspesor.setText(MenuPrincipal.espesor0+"");
			txtEspesor.setForeground(new Color(120, 40, 31));
			lblEspesor.setForeground(new Color(120, 40, 31));
			txtEspesor.setDisabledTextColor(new Color(120, 40, 31));
			
			txtContenido.setText(MenuPrincipal.contenido0+"");
			txtContenido.setForeground(new Color(120, 40, 31));
			txtContenido.setDisabledTextColor(new Color(120, 40, 31));
			lblContenido.setForeground(new Color(120, 40, 31));break;
		case 2:
			txtPrecio.setText(MenuPrincipal.precio1+"");
			txtPrecio.setForeground(new Color(108, 52, 131 ));
			lblPrecio.setForeground(new Color(108, 52, 131 ));
			txtPrecio.setDisabledTextColor(new Color(108, 52, 131 ));
			
			txtAncho.setText(MenuPrincipal.ancho1+"");
			txtAncho.setForeground(new Color(108, 52, 131 ));
			lblAncho.setForeground(new Color(108, 52, 131 ));
			txtAncho.setDisabledTextColor(new Color(108, 52, 131 ));
			
			txtLargo.setText(MenuPrincipal.largo1+"");
			txtLargo.setForeground(new Color(108, 52, 131 ));
			lblLargo.setForeground(new Color(108, 52, 131 ));
			txtLargo.setDisabledTextColor(new Color(108, 52, 131 ));
			
			txtEspesor.setText(MenuPrincipal.espesor1+"");
			txtEspesor.setForeground(new Color(108, 52, 131 ));
			lblEspesor.setForeground(new Color(108, 52, 131 ));
			txtEspesor.setDisabledTextColor(new Color(108, 52, 131 ));
			
			txtContenido.setText(MenuPrincipal.contenido1+"");
			txtContenido.setForeground(new Color(108, 52, 131 ));
			txtContenido.setDisabledTextColor(new Color(108, 52, 131 ));
			lblContenido.setForeground(new Color(108, 52, 131 ));break;
		case 3:
			txtPrecio.setText(MenuPrincipal.precio2+"");
			txtPrecio.setForeground(new Color(120, 80, 20));
			lblPrecio.setForeground(new Color(120, 80, 20));
			txtPrecio.setDisabledTextColor(new Color(120, 80, 20));
			
			txtAncho.setText(MenuPrincipal.ancho2+"");
			txtAncho.setForeground(new Color(120, 80, 20));
			lblAncho.setForeground(new Color(120, 80, 20));
			txtAncho.setDisabledTextColor(new Color(120, 80, 20));
			
			txtLargo.setText(MenuPrincipal.largo2+"");
			txtLargo.setForeground(new Color(120, 80, 20));
			lblLargo.setForeground(new Color(120, 80, 20));
			txtLargo.setDisabledTextColor(new Color(120, 80, 20));
			
			txtEspesor.setText(MenuPrincipal.espesor2+"");
			txtEspesor.setForeground(new Color(120, 80, 20));
			lblEspesor.setForeground(new Color(120, 80, 20));
			txtEspesor.setDisabledTextColor(new Color(120, 80, 20));
			
			txtContenido.setText(MenuPrincipal.contenido2+"");
			txtContenido.setForeground(new Color(120, 80, 20));
			txtContenido.setDisabledTextColor(new Color(120, 80, 20));
			lblContenido.setForeground(new Color(120, 80, 20));break;
		case 4:
			txtPrecio.setText(MenuPrincipal.precio3+"");
			txtPrecio.setForeground(new Color(186, 74, 0));
			lblPrecio.setForeground(new Color(186, 74, 0));
			txtPrecio.setDisabledTextColor(new Color(186, 74, 0));
			
			txtAncho.setText(MenuPrincipal.ancho3+"");
			txtAncho.setForeground(new Color(186, 74, 0));
			lblAncho.setForeground(new Color(186, 74, 0));
			txtAncho.setDisabledTextColor(new Color(186, 74, 0));
			
			txtLargo.setText(MenuPrincipal.largo3+"");
			txtLargo.setForeground(new Color(186, 74, 0));
			lblLargo.setForeground(new Color(186, 74, 0));
			txtLargo.setDisabledTextColor(new Color(186, 74, 0));
			
			txtEspesor.setText(MenuPrincipal.espesor3+"");
			txtEspesor.setForeground(new Color(186, 74, 0));
			lblEspesor.setForeground(new Color(186, 74, 0));
			txtEspesor.setDisabledTextColor(new Color(186, 74, 0));
			
			txtContenido.setText(MenuPrincipal.contenido3+"");
			txtContenido.setForeground(new Color(186, 74, 0));
			txtContenido.setDisabledTextColor(new Color(186, 74, 0));
			lblContenido.setForeground(new Color(186, 74, 0));break;
		case 5:
			txtPrecio.setText(MenuPrincipal.precio4+"");
			txtPrecio.setForeground(new Color(1, 8, 18));
			lblPrecio.setForeground(new Color(1, 8, 18));
			txtPrecio.setDisabledTextColor(new Color(1, 8, 18));
			
			txtAncho.setText(MenuPrincipal.ancho4+"");
			txtAncho.setForeground(new Color(1, 8, 18));
			lblAncho.setForeground(new Color(1, 8, 18));
			txtAncho.setDisabledTextColor(new Color(1, 8, 18));
			
			txtLargo.setText(MenuPrincipal.largo4+"");
			txtLargo.setForeground(new Color(1, 8, 18));
			lblLargo.setForeground(new Color(1, 8, 18));
			txtLargo.setDisabledTextColor(new Color(1, 8, 18));
			
			txtEspesor.setText(MenuPrincipal.espesor4+"");
			txtEspesor.setForeground(new Color(1, 8, 18));
			lblEspesor.setForeground(new Color(1, 8, 18));
			txtEspesor.setDisabledTextColor(new Color(1, 8, 18));
			
			txtContenido.setText(MenuPrincipal.contenido4+"");
			txtContenido.setForeground(new Color(1, 8, 18));
			txtContenido.setForeground(new Color(1, 8, 18));
			lblContenido.setForeground(new Color(1, 8, 18));break;
		default:
			txtPrecio.setText("");
			txtAncho.setText("");
			txtLargo.setText("");
			txtEspesor.setText("");
			txtContenido.setText("");break;	
	}
}
	
//BOTON CERRAR
protected void actionPerformedBtnCerrar(ActionEvent arg0) {
	this.dispose();
	}
	protected void actionPerformedBtnSI(ActionEvent arg0) {	
		txtPrecio.setEnabled(true);
		txtAncho.setEnabled(true);
		txtLargo.setEnabled(true);
		txtEspesor.setEnabled(true);
		txtContenido.setEnabled(true);
	}
	protected void actionPerformedBtnNO(ActionEvent arg0) {
		txtPrecio.setEnabled(false);
		txtAncho.setEnabled(false);
		txtLargo.setEnabled(false);
		txtEspesor.setEnabled(false);
		txtContenido.setEnabled(false);
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		try {
			String filePath = "C:\\Users\\user\\OneDrive\\Programa de ventas\\ProyectoVentaCeramicas\\src\\zDatosCeramico\\datos_ceramico.txt";
		    randomAccessFile = new RandomAccessFile(filePath, "rw");
		} catch (IOException e) {
		    e.printStackTrace();	
	}
		try {
		    // ...
		    randomAccessFile.writeBytes("Datos a escribir en el archivo");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		try {
		    // ...
		    randomAccessFile.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtEspesor) {
			keyTypedTxtEspesor(arg0);
		}
		if (arg0.getSource() == txtAncho) {
			keyTypedTxtAncho(arg0);
		}
		if (arg0.getSource() == txtPrecio) {
			keyTypedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtContenido) {
			keyTypedTxtContenido(arg0);
		}
		if (arg0.getSource() == txtLargo) {
			keyTypedTxtLargo(arg0);
		}
	}
	protected void keyTypedTxtLargo(KeyEvent arg0) {
		Character c = arg0.getKeyChar();
		if (Character.isLetter(c)){
			arg0.consume();
			
		}
	}
	protected void keyTypedTxtContenido(KeyEvent arg0) {
		Character c = arg0.getKeyChar();
		if (Character.isLetter(c)){
			arg0.consume();
		}
	}
	protected void keyTypedTxtPrecio(KeyEvent arg0) {
		Character c = arg0.getKeyChar();
		if (Character.isLetter(c)){
			arg0.consume();
		}
	}
	protected void keyTypedTxtAncho(KeyEvent arg0) {
		Character c = arg0.getKeyChar();
		if (Character.isLetter(c)){
			arg0.consume();
		}
	}
	protected void keyTypedTxtEspesor(KeyEvent arg0) {
		Character c = arg0.getKeyChar();
		if (Character.isLetter(c)){
			arg0.consume();
		}
	}
}
