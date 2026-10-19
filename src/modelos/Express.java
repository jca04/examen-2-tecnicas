package modelos;

public class Express extends Envio {

    private static final int TARIFA_POR_KM = 450;
    private static final int TARIFA_POR_KG = 1000;

    public Express(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public Double calcularTarifa() {
        return (getDistancia() * TARIFA_POR_KM) + (getPeso() * TARIFA_POR_KG);
    }

    @Override
    public String[] obtenerDatosEnvio() {
        return new String[] {
                "Express",
                getCodigo(),
                getCliente(),
                String.valueOf(getPeso()),
                String.valueOf(getDistancia()),
                String.valueOf(calcularTarifa())
        };
    }
}