package modelos;

import java.text.DecimalFormat;

public class Terrestre extends Envio {

    private static final int TARIFA_POR_KM = 1500;
    private static final int TARIFA_POR_KG = 2000;

    public Terrestre(String codigo, String cliente, double peso, double distancia) {
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
                "Terrestre",
                getCodigo(),
                getCliente(),
                df.format(getPeso()),
                df.format(getDistancia()),
                df.format(this.calcularTarifa()),
        };
    }
}
