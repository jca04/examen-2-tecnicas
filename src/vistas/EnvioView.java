package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EnvioView extends JFrame {

    //formulario composición
    private JTextField txtNumero, txtCliente, txtPeso, txtDistancia;
    private JComboBox<String> cbTipo;
    private JButton btnGuardar, btnCancelar, btnRetirar; // Añadí btnRetirar por tu duda anterior

    //componentes de la tabla
    private JTable tablaEnvios;
    private DefaultTableModel modeloTabla;

    public EnvioView() {
        setTitle("Operador Logístico - Técnicas de Programación");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setLayout(new BorderLayout(10, 10));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        //panel superior: formulario y botones
        JPanel panelFormulario = new JPanel(new GridLayout(3, 4, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Registro de Envío"));

        panelFormulario.add(new JLabel("Número (Código):"));
        txtNumero = new JTextField();
        panelFormulario.add(txtNumero);

        panelFormulario.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Terrestre", "Aéreo", "Marítimo", "Express"});
        panelFormulario.add(cbTipo);

        panelFormulario.add(new JLabel("Cliente:"));
        txtCliente = new JTextField();
        panelFormulario.add(txtCliente);

        panelFormulario.add(new JLabel("Distancia en Km:"));
        txtDistancia = new JTextField();
        panelFormulario.add(txtDistancia);

        panelFormulario.add(new JLabel("Peso en Kg:"));
        txtPeso = new JTextField();
        panelFormulario.add(txtPeso);

        //el panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        btnRetirar = new JButton("Retirar (por Código)"); // Botón para cumplir el requerimiento de retirar

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnRetirar);

        // juntar formulario y botones
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelFormulario, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);

        // panel inferior
        String[] columnas = {"Tipo", "Código", "Cliente", "Peso", "Distancia", "Costo"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEnvios = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaEnvios);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Listado de Envíos"));

        add(scrollTabla, BorderLayout.CENTER);
    }

    //geetters del controlador para acceder a los campos y botones del formulario
    
    public String getTxtNumero() { return txtNumero.getText(); }
    public String getTxtCliente() { return txtCliente.getText(); }
    public String getTxtPeso() { return txtPeso.getText(); }
    public String getTxtDistancia() { return txtDistancia.getText(); }
    public String getCbTipo() { return (String) cbTipo.getSelectedItem(); }
    
    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    public JButton getBtnRetirar() { return btnRetirar; }
    
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    //limpiar el formulario
    public void limpiarCampos() {
        txtNumero.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistancia.setText("");
        cbTipo.setSelectedIndex(0);
    }
    
    //motrar los mensajes
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }
}
