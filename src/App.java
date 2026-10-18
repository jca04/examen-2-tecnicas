import modelos.DatosEnvio;
import modelos.TipoTransporte;
import servicios.EnvioService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        var datos = new DatosEnvio("10001", "Polimeros colombia", 1200, 400);

        var envio = EnvioService.agregarEnvio(TipoTransporte.TERRESTRE, datos);
        System.out.println("Agregado: " + (envio != null));

        var duplicado = EnvioService.agregarEnvio(TipoTransporte.AEREO, datos);
        System.out.println("Duplicado rechazado: " + (duplicado == null));

        for (String[] fila : EnvioService.getDatos()) {
            System.out.println(String.join(" | ", fila));
        }

        System.out.println("Retirado: " + EnvioService.retirarEnvio("10001"));
        System.out.println("Retirar inexistente: " + EnvioService.retirarEnvio("10001"));
    }
}
