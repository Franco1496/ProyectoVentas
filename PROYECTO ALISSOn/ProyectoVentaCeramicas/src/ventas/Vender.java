package ventas;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.print.attribute.standard.PrinterInfo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Vender extends JInternalFrame implements ActionListener {
    private JLabel lblRegistroVentas;
    private JLabel lblModelo;
    private JComboBox<String> cboModelo;
    private JLabel lblPrecio;
    private JTextField txtPrecio;
    private JLabel lblCantidad;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JButton btnCerrar;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnLimpiar;
    private JButton btnEditar;

    private int contadorVentas = 0;
    private double importeTotalGeneralAcumulado = 0.0;
    private final double cuotaDiaria = 1000.0;

    private DefaultTableModel model;
    private JButton btnVender;

    /**
     * Create the frame.
     */
    public Vender() {
    	setTitle("Vender");
    	setIconifiable(true);
        setBounds(100, 100, 776, 455);
        getContentPane().setLayout(null);

        lblRegistroVentas = new JLabel("Registro de ventas");
        lblRegistroVentas.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRegistroVentas.setBounds(10, 148, 135, 25);
        getContentPane().add(lblRegistroVentas);

        lblModelo = new JLabel("\u2023 Modelo");
        lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblModelo.setBounds(10, 22, 78, 25);
        getContentPane().add(lblModelo);

        cboModelo = new JComboBox<String>();
        cboModelo.setModel(new DefaultComboBoxModel<String>(
                new String[] { "Selecciona", "Cinza Plus", "Luxury", "Austria", "Yunga Mix", "Thalia" }));
        cboModelo.setToolTipText("");
        cboModelo.setForeground(SystemColor.textInactiveText);
        cboModelo.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cboModelo.setBackground(new Color(191, 205, 217));
        cboModelo.setBounds(134, 22, 221, 26);
        getContentPane().add(cboModelo);

        lblPrecio = new JLabel("\u2023 Precio (S/)");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrecio.setBounds(10, 70, 92, 25);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtPrecio.setEnabled(false);
        txtPrecio.setDisabledTextColor(new Color(120, 40, 31));
        txtPrecio.setColumns(10);
        txtPrecio.setCaretColor(Color.BLACK);
        txtPrecio.setBounds(134, 73, 221, 25);
        getContentPane().add(txtPrecio);

        lblCantidad = new JLabel("\u2023 Cantidad");
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCantidad.setBounds(10, 112, 92, 25);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtCantidad.setDisabledTextColor(new Color(120, 40, 31));
        txtCantidad.setColumns(10);
        txtCantidad.setCaretColor(Color.BLACK);
        txtCantidad.setBounds(134, 112, 221, 25);
        getContentPane().add(txtCantidad);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        btnAgregar.setBounds(390, 22, 109, 45);
        getContentPane().add(btnAgregar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        btnCerrar.setBounds(641, 22, 109, 45);
        getContentPane().add(btnCerrar);

        btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        btnEditar.setBounds(641, 101, 109, 45);
        getContentPane().add(btnEditar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        btnLimpiar.setBounds(520, 22, 109, 45);
        getContentPane().add(btnLimpiar);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 184, 740, 230);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("Modelo");
        model.addColumn("Precio");
        model.addColumn("Cant.Adquirida");
        model.addColumn("Imp.Compra");
        model.addColumn("Imp.Descuento");
        model.addColumn("Imp.Pagar");
        model.addColumn("Tipo de obsequio");
        model.addColumn("Ud.Obsequiadas");
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        btnVender = new JButton("Vender");
        btnVender.addActionListener(this);
        btnVender.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        btnVender.setBounds(390, 101, 109, 45);
        getContentPane().add(btnVender);

        cboModelo.addActionListener(this::actualizarPrecio);
        btnAgregar.addActionListener(this::venderProducto);
        btnEditar.addActionListener(this::editarVenta);
        btnLimpiar.addActionListener(this::limpiarCampos);
    }

    private void actualizarPrecio(ActionEvent e) {
        if (e.getSource() == cboModelo) {
            // Obtener el modelo seleccionado
            String modelo = (String) cboModelo.getSelectedItem();

            // Asignar el precio correspondiente al TextField
            switch (cboModelo.getSelectedIndex()) {
                case 1:
                    txtPrecio.setText("92.56");
                    break;
                case 2:
                    txtPrecio.setText("42.77");
                    break;
                case 3:
                    txtPrecio.setText("52.45");
                    break;
                case 4:
                    txtPrecio.setText("55.89");
                    break;
                case 5:
                    txtPrecio.setText("45.00");
                    break;
                default:
                    txtPrecio.setText("");
                    break;
            }
        }
    }

    private void venderProducto(ActionEvent e) {


    	
    	
        if (txtCantidad.getText().isEmpty()){
        	JOptionPane.showMessageDialog(null, "Por favor, Llene las casillas");	
        } 
        
        else {
        	
    		
            // Obtener los valores de los campos
            String modelo = (String) cboModelo.getSelectedItem();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double importe = (precio * cantidad);


            // Agregar los datos a la tabla
            Object[] rowData = { modelo, precio, cantidad ,importe};
            model.addRow(rowData);
            
            if (model.getRowCount() == 5) {
                double importeTotalAcumulado = 0.0;
                int numFilas = model.getRowCount();
                int columnaImpCompra = model.findColumn("Imp.Compra");

                for (int fila = 0; fila < numFilas; fila++) {
                    double impCompra = (double) model.getValueAt(fila, columnaImpCompra);
                    importeTotalAcumulado += impCompra;
                }
                

                double porcentajeCompraDiaria = 30000;
                double cantidadCompraDiaria=(importeTotalAcumulado * 100) / porcentajeCompraDiaria;
                
                System.out.print(porcentajeCompraDiaria);

                
                String mensaje = "Alerta N.5\n";
                mensaje += "Importe total general acumulado: " + importeTotalAcumulado + "\n";
                mensaje += "Porcentaje de la cuota Diaria : " + cantidadCompraDiaria +"%" +"\n";
                

                
                JOptionPane.showMessageDialog(null, mensaje, "Avance de Venta", JOptionPane.INFORMATION_MESSAGE);
            }

        	
        }
	}
        

        // Limpiar los campos
       // limpiarCampos(null);
    

    private double calcularDescuento(double importeCompra, int cantidad) {
        double descuento = 0.0;

        if (cantidad >= 1 && cantidad <= 5) {
            descuento = importeCompra * 1 / 100;  // Rango 1-5: Aplicar descuento porcentaje1
        } else if (cantidad >= 6 && cantidad <= 10) {
            descuento = importeCompra * 2 / 100; // Rango 6-10: Aplicar descuento porcentaje2
        } else if (cantidad >= 11 && cantidad <= 15) {
            descuento = importeCompra * 3 / 100; // Rango 11-15: Aplicar descuento porcentaje3
        } else if (cantidad > 15) {
            descuento = importeCompra * 4 / 100; // Más de 15: Aplicar descuento porcentaje4
        }
        return descuento;
    }

    private String obtenerTipoObsequio(double importeCompra) {
        String tipoObsequio = "Sin obsequio";

        if (importeCompra >= 500 && importeCompra <= 1000) {
            tipoObsequio = "Obsequio tipo A";
        } else if (importeCompra > 1000 && importeCompra <= 1500) {
            tipoObsequio = "Obsequio tipo B";
        } else if (importeCompra > 1500) {
            tipoObsequio = "Obsequio tipo C";
        }
        return tipoObsequio;
    }

    private int obtenerUnidadesObsequiadas(double importeCompra) {
        int unidadesObsequiadas = 0;

        if (importeCompra >= 500 && importeCompra <= 1000) {
            unidadesObsequiadas = 1;
        } else if (importeCompra > 1000 && importeCompra <= 1500) {
            unidadesObsequiadas = 2;
        } else if (importeCompra > 1500) {
            unidadesObsequiadas = 3;
        }
        return unidadesObsequiadas;
    }

    private void limpiarCampos(ActionEvent e) {
        cboModelo.setSelectedIndex(0);
        txtPrecio.setText("");
        txtCantidad.setText("");
        model.setRowCount(0);
    }

    private void editarVenta(ActionEvent e) {
        int filaSeleccionada = table.getSelectedRow(); // Obtener la fila seleccionada
        int columnaModelo = model.findColumn("Modelo"); // Obtener el índice de la columna "Modelo" en el modelo
        int columnaPrecio = model.findColumn("Precio"); // Obtener el índice de la columna "Precio" en el modelo
        int columnaCantAdquirida = model.findColumn("Cant.Adquirida"); // Obtener el índice de la columna "Cant.Adquirida" en el modelo

        if (filaSeleccionada != -1) { // Verificar si hay una fila seleccionada
            Object valorModelo = model.getValueAt(filaSeleccionada, columnaModelo); // Obtener el valor de la columna "Modelo" de la fila seleccionada
            Object valorPrecio = model.getValueAt(filaSeleccionada, columnaPrecio); // Obtener el valor de la columna "Precio" de la fila seleccionada
            Object valorCantAdquirida = model.getValueAt(filaSeleccionada, columnaCantAdquirida); // Obtener el valor de la columna "Cant.Adquirida" de la fila seleccionada
            
            cboModelo.setSelectedItem(valorModelo); // Asignar el valor al combo cboModelo
            txtPrecio.setText(String.valueOf(valorPrecio)); // Asignar el valor al campo de texto txtPrecio
            txtCantidad.setText(String.valueOf(valorCantAdquirida)); // Asignar el valor al campo de texto txtCantidad
        }
        

        
        // Otros procesos o acciones que deseas realizar al editar la venta
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
	}
	private void actionPerformedBtnVender(ActionEvent e) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		double sumaTotal = 0.0;

		int numFilas = model.getRowCount();
		int columnaPrecio = model.findColumn("Precio");

		for (int fila = 0; fila < numFilas; fila++) {
		    double precio = (double) model.getValueAt(fila, columnaPrecio);
		    sumaTotal += precio;
		}

		StringBuilder boleta = new StringBuilder();

		for (int fila = 0; fila < numFilas; fila++) {
		    String modelo = (String) model.getValueAt(fila, 0);
		    double precio = (double) model.getValueAt(fila, columnaPrecio);
		    int cantAdquirida = (int) model.getValueAt(fila, 2);
		    double impCompra = precio * cantAdquirida;

		    boleta.append("Modelo: ").append(modelo).append("\n");
		    boleta.append("Precio: ").append(precio).append("\n");
		    boleta.append("Cantidad Adquirida: ").append(cantAdquirida).append("\n");
		    boleta.append("Importe de Compra: ").append(impCompra).append("\n");
		    boleta.append("\n");

		}

		boleta.append("Importe Total de Compra: ").append(sumaTotal).append("\n");

		JOptionPane.showMessageDialog(null, boleta.toString(), "Boleta de Venta", JOptionPane.INFORMATION_MESSAGE);

	}
}
