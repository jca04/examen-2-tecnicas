package modelos;

public class Express extends Envio {

    public Express(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public Double calcularTarifa() {
        return (getDistancia() * 6000) + (getPeso() * 5000);
    }

    @Override
    public String[] obtenerDatosEnvio() {
        return new String[]{
            "Express",
            getCodigo(),
            getCliente(),
            String.valueOf(getPeso()),
            String.valueOf(getDistancia()),
            String.valueOf(calcularTarifa())
        };
    }
}