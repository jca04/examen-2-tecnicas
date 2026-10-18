package modelos;

import java.text.DecimalFormat;

public class Aereo extends Envio {

    private static final int TARIFA_POR_KM = 5000;
    private static final int TARIFA_POR_KG = 4000;

    public Aereo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public Double calcularTarifa() {
        return (this.getDistancia() * TARIFA_POR_KM) + (this.getPeso() * TARIFA_POR_KG);
    }

    @Override
    public String[] obtenerDatosEnvio() {
        DecimalFormat df = new DecimalFormat("0.0");
        return new String[] {
                "Aéreo",
                getCodigo(),
                getCliente(),
                df.format(getPeso()),
                df.format(getDistancia()),
                df.format(this.calcularTarifa()),
        };
    }

}
