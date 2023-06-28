package mantenimiento;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit;

import Principal.MenuPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;


import java.awt.event.ActionEvent;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

public class ConsultarCerámico extends JInternalFrame implements ActionListener {
	
	
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblLargo;
	private JLabel lblEspesor;
	private JLabel lblContenido;
	private JComboBox cboModelo;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;
	private JButton btnCerrar;
	private JTextField txtPrecio;
	private JPanel pnlcolor;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCerámico frame = new ConsultarCerámico();
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
	public ConsultarCerámico() {
		setBackground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(100, 130, 154));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setBorder(new LineBorder(new Color(0, 0, 0), 6));
		setIconifiable(true);
		setTitle("Consultar cer\u00E1mico");
		setBounds(100, 100, 517, 285);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("\u2023 Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(10, 22, 78, 25);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("\u2023 Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(10, 58, 92, 25);
		getContentPane().add(lblPrecio);
		
		lblAncho = new JLabel("\u2023 Ancho (cm)");
		lblAncho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAncho.setBounds(10, 94, 92, 25);
		getContentPane().add(lblAncho);
		
		lblLargo = new JLabel("\u2023 Largo (cm)");
		lblLargo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLargo.setBounds(10, 130, 92, 27);
		getContentPane().add(lblLargo);
		
		lblEspesor = new JLabel("\u2023 Espesor (mm)");
		lblEspesor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEspesor.setBounds(10, 168, 102, 31);
		getContentPane().add(lblEspesor);
		
		lblContenido = new JLabel("\u2023 Contenido");
		lblContenido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContenido.setBounds(10, 210, 92, 25);
		getContentPane().add(lblContenido);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		
		pnlcolor = new JPanel();
		pnlcolor.setBackground(new Color(0, 0, 0));
		pnlcolor.setBounds(0, 0, 505, 10);
		getContentPane().add(pnlcolor);
		cboModelo.setBackground(new Color(191, 205, 217));
		cboModelo.setForeground(SystemColor.textInactiveText);
		cboModelo.setToolTipText("");
		cboModelo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE", "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		cboModelo.setBounds(140, 21, 221, 26);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(140, 61, 221, 25);
		getContentPane().add(txtPrecio);
		
		txtAncho = new JTextField();
		txtAncho.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(140, 97, 221, 25);
		getContentPane().add(txtAncho);
		
		txtLargo = new JTextField();
		txtLargo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLargo.setEditable(false);
		txtLargo.setColumns(10);
		txtLargo.setBounds(140, 134, 221, 25);
		getContentPane().add(txtLargo);
		
		txtEspesor = new JTextField();
		txtEspesor.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEspesor.setEditable(false);
		txtEspesor.setColumns(10);
		txtEspesor.setBounds(140, 174, 221, 25);
		getContentPane().add(txtEspesor);
		
		txtContenido = new JTextField();
		txtContenido.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtContenido.setEditable(false);
		txtContenido.setColumns(10);
		txtContenido.setBounds(140, 213, 221, 25);
		getContentPane().add(txtContenido);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnCerrar.setBounds(378, 105, 102, 45);
		getContentPane().add(btnCerrar);

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		
		switch (cboModelo.getSelectedIndex()){
		case 1:
			txtPrecio.setText(MenuPrincipal.precio0+"");
			txtPrecio.setForeground(new Color(120, 40, 31));
			lblPrecio.setForeground(new Color(120, 40, 31));
			
			txtAncho.setText(MenuPrincipal.ancho0+"");
			txtAncho.setForeground(new Color(120, 40, 31));
			lblAncho.setForeground(new Color(120, 40, 31));
			
			txtLargo.setText(MenuPrincipal.largo0+"");
			txtLargo.setForeground(new Color(120, 40, 31));
			lblLargo.setForeground(new Color(120, 40, 31));
			
			txtEspesor.setText(MenuPrincipal.espesor0+"");
			txtEspesor.setForeground(new Color(120, 40, 31));
			lblEspesor.setForeground(new Color(120, 40, 31));
			
			txtContenido.setText(MenuPrincipal.contenido0+"");
			txtContenido.setForeground(new Color(120, 40, 31));
			lblContenido.setForeground(new Color(120, 40, 31));break;
		case 2:
			txtPrecio.setText(MenuPrincipal.precio1+"");
			txtPrecio.setForeground(new Color(108, 52, 131 ));
			lblPrecio.setForeground(new Color(108, 52, 131 ));
			
			txtAncho.setText(MenuPrincipal.ancho1+"");
			txtAncho.setForeground(new Color(108, 52, 131 ));
			lblAncho.setForeground(new Color(108, 52, 131 ));
			
			txtLargo.setText(MenuPrincipal.largo1+"");
			txtLargo.setForeground(new Color(108, 52, 131 ));
			lblLargo.setForeground(new Color(108, 52, 131 ));
			
			txtEspesor.setText(MenuPrincipal.espesor1+"");
			txtEspesor.setForeground(new Color(108, 52, 131 ));
			lblEspesor.setForeground(new Color(108, 52, 131 ));
			
			txtContenido.setText(MenuPrincipal.contenido1+"");
			txtContenido.setForeground(new Color(108, 52, 131 ));
			lblContenido.setForeground(new Color(108, 52, 131 ));break;
		case 3:
			txtPrecio.setText(MenuPrincipal.precio2+"");
			txtPrecio.setForeground(new Color(120, 80, 20));
			lblPrecio.setForeground(new Color(120, 80, 20));
			
			txtAncho.setText(MenuPrincipal.ancho2+"");
			txtAncho.setForeground(new Color(120, 80, 20));
			lblAncho.setForeground(new Color(120, 80, 20));
			
			txtLargo.setText(MenuPrincipal.largo2+"");
			txtLargo.setForeground(new Color(120, 80, 20));
			lblLargo.setForeground(new Color(120, 80, 20));
			
			txtEspesor.setText(MenuPrincipal.espesor2+"");
			txtEspesor.setForeground(new Color(120, 80, 20));
			lblEspesor.setForeground(new Color(120, 80, 20));
			
			txtContenido.setText(MenuPrincipal.contenido2+"");
			txtContenido.setForeground(new Color(120, 80, 20));
			lblContenido.setForeground(new Color(120, 80, 20));break;
		case 4:
			txtPrecio.setText(MenuPrincipal.precio3+"");
			txtPrecio.setForeground(new Color(186, 74, 0));
			lblPrecio.setForeground(new Color(186, 74, 0));
			
			txtAncho.setText(MenuPrincipal.ancho3+"");
			txtAncho.setForeground(new Color(186, 74, 0));
			lblAncho.setForeground(new Color(186, 74, 0));
			
			txtLargo.setText(MenuPrincipal.largo3+"");
			txtLargo.setForeground(new Color(186, 74, 0));
			lblLargo.setForeground(new Color(186, 74, 0));
			
			txtEspesor.setText(MenuPrincipal.espesor3+"");
			txtEspesor.setForeground(new Color(186, 74, 0));
			lblEspesor.setForeground(new Color(186, 74, 0));
			
			txtContenido.setText(MenuPrincipal.contenido3+"");
			txtContenido.setForeground(new Color(186, 74, 0));
			lblContenido.setForeground(new Color(186, 74, 0));break;
		case 5:
			txtPrecio.setText(MenuPrincipal.precio4+"");
			txtPrecio.setForeground(new Color(1, 8, 18));
			lblPrecio.setForeground(new Color(1, 8, 18));
			
			txtAncho.setText(MenuPrincipal.ancho4+"");
			txtAncho.setForeground(new Color(1, 8, 18));
			lblAncho.setForeground(new Color(1, 8, 18));
			
			txtLargo.setText(MenuPrincipal.largo4+"");
			txtLargo.setForeground(new Color(1, 8, 18));
			lblLargo.setForeground(new Color(1, 8, 18));
			
			txtEspesor.setText(MenuPrincipal.espesor4+"");
			txtEspesor.setForeground(new Color(1, 8, 18));
			lblEspesor.setForeground(new Color(1, 8, 18));
			
			txtContenido.setText(MenuPrincipal.contenido4+"");
			txtContenido.setForeground(new Color(1, 8, 18));
			lblContenido.setForeground(new Color(1, 8, 18));break;
		default:
	
			txtPrecio.setText("");
		
			txtAncho.setText("");
			
			txtLargo.setText("");
			
			txtEspesor.setText("");
			
			txtContenido.setText("");
		}
		
	}
}
