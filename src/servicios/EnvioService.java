package servicios;

import java.util.HashMap;
import fabricas.EnvioFactory;
import modelos.DatosEnvio;
import modelos.Envio;
import modelos.TipoTransporte;

public class EnvioService {

    private static final String[] encabezados = { "Tipo", "Código", "Cliente", "Peso", "Distancia", "Costo" };

    private static HashMap<String, Envio> envios = new HashMap<>();

    public static Envio agregarEnvio(TipoTransporte tipo, DatosEnvio datos) {
        if (envios.containsKey(datos.codigo())) {
            return null;
        }
        var envio = EnvioFactory.getFactory(tipo).crearEnvio(datos);
        if (envio != null)
            envios.put(datos.codigo(), envio);
        return envio;
    }

    public static boolean retirarEnvio(String codigo) {
        if (envios.containsKey(codigo)) {
            envios.remove(codigo);
            return true;
        }
        return false;
    }

    public static String[][] getDatos() {
        String[][] datos = new String[envios.size()][encabezados.length];
        int fila = 0;
        for (var envio : envios.values()) {
            int columna = 0;
            for (var dato : envio.obtenerDatosEnvio()) {
                if (columna < encabezados.length) {
                    datos[fila][columna] = dato;
                }
                columna++;
            }
            fila++;
        }
        return datos;
    }

}
