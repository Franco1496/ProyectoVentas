package mantenimiento;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Principal.MenuPrincipal;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCeramicos extends JInternalFrame implements ActionListener {
	private JPanel Pcolor;
	private JComboBox cboModelo;
	private JPanel pnlPrincipal;
	private JPanel pnlCinzaPlus;
	private JPanel pnlLuxury;
	private JLabel lblCinzaPlus;
	private JLabel lblLuxury;
	private JPanel pnlAustria;
	private JLabel lblAustria;
	private JPanel pnlYungaMix;
	private JLabel lblYungaMix;
	private JPanel pnlThalia;
	private JLabel lblThalia;
	private JPanel pnlPresenta;
	private JLabel lblPresenta;

	/**
	 * Launch the application.
	 * 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCeramicos frame = new ListarCeramicos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	
	
	public ListarCeramicos() {
		setClosable(true);
		setIconifiable(true);
		getContentPane().setEnabled(false);
		setBorder(new LineBorder(new Color(0, 0, 0), 6));
		getContentPane().setBackground(new Color(100, 130, 154));
		getContentPane().setLayout(null);
		
		
		Pcolor = new JPanel();
		Pcolor.setBackground(Color.BLACK);
		Pcolor.setBounds(0, 0, 700, 10);
		getContentPane().add(Pcolor);
		
		cboModelo = new JComboBox();
		cboModelo.setBorder(null);
		cboModelo.setBounds(162, 33, 375, 37);
		getContentPane().add(cboModelo);
		cboModelo.addActionListener(this);
		cboModelo.setFont(new Font("Verdana", Font.BOLD, 14));
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"                    Seleccione un Modelo", "                             Cinza Plus", "                                Luxury", "                                Austria", "                            Yungay Mix", "                                 Thal\u00EDa"}));
		cboModelo.setBackground(new Color(191, 205, 217));
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBackground(new Color(100, 130, 154));
		pnlPrincipal.setBounds(0, 81, 700, 393);
		getContentPane().add(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		
		pnlPresenta = new JPanel();
		pnlPresenta.setLayout(null);
		pnlPresenta.setBackground(new Color(100, 130, 154));
		pnlPresenta.setBounds(0, -71, 700, 464);
		pnlPrincipal.add(pnlPresenta);
		
		lblPresenta = new JLabel("");
		lblPresenta.setBounds(0, 65, 700, 398);
		pnlPresenta.add(lblPresenta);

		ImageIcon imagenIcono = new ImageIcon("C:\\Users\\user\\OneDrive\\Programa de ventas\\ProyectoVentaCeramicas\\src\\zImagenesLista\\Presenta.png");
		Image imagen = imagenIcono.getImage();
		Image imagenAjustada = imagen.getScaledInstance(lblPresenta.getWidth(), lblPresenta.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenAjustadaIcono = new ImageIcon(imagenAjustada);
		lblPresenta.setIcon(imagenAjustadaIcono);
		
		pnlCinzaPlus = new JPanel();
		pnlCinzaPlus.setBounds(0, 0, 700, 393);
		pnlPrincipal.add(pnlCinzaPlus);
		pnlCinzaPlus.setBackground(new Color(100, 130, 154));
		pnlCinzaPlus.setLayout(null);
		
		lblCinzaPlus = new JLabel();
		lblCinzaPlus.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Programa de ventas\\ProyectoVentaCeramicas\\src\\zImagenesLista\\1_Cinza.png"));
		lblCinzaPlus.setBounds(0, -22, 700, 415);
		pnlCinzaPlus.add(lblCinzaPlus);
		
		pnlLuxury = new JPanel();
		pnlLuxury.setBounds(0, 0, 700, 393);
		pnlPrincipal.add(pnlLuxury);
		pnlLuxury.setBackground(new Color(100, 130, 154));
		pnlLuxury.setLayout(null);
		
		lblLuxury = new JLabel("");
		lblLuxury.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Programa de ventas\\ProyectoVentaCeramicas\\src\\zImagenesLista\\2_Luxury.png"));
		lblLuxury.setBounds(0, -23, 700, 416);
		pnlLuxury.add(lblLuxury);
		
		pnlAustria = new JPanel();
		pnlAustria.setLayout(null);
		pnlAustria.setBackground(new Color(100, 130, 154));
		pnlAustria.setBounds(0, 0, 700, 393);
		pnlPrincipal.add(pnlAustria);
		
		lblAustria = new JLabel();
		lblAustria.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Programa de ventas\\ProyectoVentaCeramicas\\src\\zImagenesLista\\3_Austria.png"));
		lblAustria.setBounds(0, -23, 700, 416);
		pnlAustria.add(lblAustria);
		
		pnlYungaMix = new JPanel();
		pnlYungaMix.setLayout(null);
		pnlYungaMix.setBackground(new Color(100, 130, 154));
		pnlYungaMix.setBounds(0, 0, 700, 393);
		pnlPrincipal.add(pnlYungaMix);
		
		lblYungaMix = new JLabel();
		lblYungaMix.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Programa de ventas\\ProyectoVentaCeramicas\\src\\zImagenesLista\\4_YungaMix.png"));
		lblYungaMix.setBounds(0, -23, 700, 416);
		pnlYungaMix.add(lblYungaMix);
		
		pnlThalia = new JPanel();
		pnlThalia.setLayout(null);
		pnlThalia.setBackground(new Color(100, 130, 154));
		pnlThalia.setBounds(0, 0, 700, 393);
		pnlPrincipal.add(pnlThalia);
		
		lblThalia = new JLabel();
		lblThalia.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Programa de ventas\\ProyectoVentaCeramicas\\src\\zImagenesLista\\5_Thalia.png"));
		lblThalia.setBounds(0, -21, 700, 414);
		pnlThalia.add(lblThalia);
		setTitle("Lista de Cer\u00E1micos");
		setBounds(100, 100, 712, 507);

	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboModelo) {
			actionPerformedCboModelo(arg0);
		}
	}
	
	protected void actionPerformedCboModelo(ActionEvent arg0) {
		switch (cboModelo.getSelectedIndex()) {
			case 1:
				pnlPresenta.setVisible(false);
				pnlCinzaPlus.setVisible(true);
				pnlLuxury.setVisible(false);
				pnlAustria.setVisible(false);
				pnlYungaMix.setVisible(false);
				pnlThalia.setVisible(false);
				break;
			case 2:
				pnlPresenta.setVisible(false);
				pnlCinzaPlus.setVisible(false);
				pnlLuxury.setVisible(true);
				pnlAustria.setVisible(false);
				pnlYungaMix.setVisible(false);
				pnlThalia.setVisible(false);
				break;
			case 3:
				pnlPresenta.setVisible(false);
				pnlCinzaPlus.setVisible(false);
				pnlLuxury.setVisible(false);
				pnlAustria.setVisible(true);
				pnlYungaMix.setVisible(false);
				pnlThalia.setVisible(false);
				break;
			case 4:
				pnlPresenta.setVisible(false);
				pnlCinzaPlus.setVisible(false);
				pnlLuxury.setVisible(false);
				pnlAustria.setVisible(false);
				pnlYungaMix.setVisible(true);
				pnlThalia.setVisible(false);
				break;
			case 5:
				pnlPresenta.setVisible(false);
				pnlCinzaPlus.setVisible(false);
				pnlLuxury.setVisible(false);
				pnlAustria.setVisible(false);
				pnlYungaMix.setVisible(false);
				pnlThalia.setVisible(true);
				break;
			default:
				pnlPresenta.setVisible(true);
				pnlCinzaPlus.setVisible(false);
				pnlLuxury.setVisible(false);
				pnlAustria.setVisible(false);
				pnlYungaMix.setVisible(false);
				pnlThalia.setVisible(false);
				break;
		}
	}

}

