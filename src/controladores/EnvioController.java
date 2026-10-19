package controladores;

import vistas.EnvioView;
import servicios.EnvioService;
import modelos.TipoTransporte;
import modelos.DatosEnvio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EnvioController implements ActionListener {

    private EnvioView vista;

    public EnvioController(EnvioView vista) {
        this.vista = vista;

        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);
        this.vista.getBtnRetirar().addActionListener(this);
    }

    public void iniciar() {
        vista.setVisible(true);
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            guardarEnvio();
        } else if (e.getSource() == vista.getBtnCancelar()) {
            vista.limpiarCampos();
        } else if (e.getSource() == vista.getBtnRetirar()) {
            retirarEnvio();
        }
    }

    private void guardarEnvio() {
        try {

            String codigo = vista.getTxtNumero();
            String cliente = vista.getTxtCliente();
            String tipoStr = vista.getCbTipo();

            if (codigo.isEmpty() || cliente.isEmpty() || vista.getTxtPeso().isEmpty()
                    || vista.getTxtDistancia().isEmpty()) {
                vista.mostrarMensaje("Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double peso = Double.parseDouble(vista.getTxtPeso());
            double distancia = Double.parseDouble(vista.getTxtDistancia());

            String tipoEnumStr = tipoStr.toUpperCase().replace("É", "E").replace("Í", "I");
            TipoTransporte tipo = TipoTransporte.valueOf(tipoEnumStr);

            DatosEnvio datos = new DatosEnvio(codigo, cliente, peso, distancia);

            var envio = EnvioService.agregarEnvio(tipo, datos);

            if (envio != null) {
                vista.mostrarMensaje("Envío guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.limpiarCampos();
                actualizarTabla();
            } else {
                vista.mostrarMensaje("Ya existe un envío con el código " + codigo + ".", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("El peso y la distancia deben ser valores numéricos válidos.", "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            vista.mostrarMensaje("Tipo de transporte no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void retirarEnvio() {
        String codigo = vista.getTxtNumero();
        if (codigo.isEmpty()) {
            vista.mostrarMensaje("Por favor, digite el código del envío a retirar en el campo 'Número'.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean retirado = EnvioService.retirarEnvio(codigo);

        if (retirado) {
            vista.mostrarMensaje("Envío retirado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            vista.limpiarCampos();
            actualizarTabla();
        } else {
            vista.mostrarMensaje("El código " + codigo + " no existe en el sistema.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        DefaultTableModel modelo = vista.getModeloTabla();
        modelo.setRowCount(0);

        String[][] datos = EnvioService.getDatos();
        for (String[] fila : datos) {
            modelo.addRow(fila);
        }
    }
}
