import vistas.EnvioView;
import controladores.EnvioController;
import modelos.DatosEnvio;
import modelos.TipoTransporte;
import servicios.EnvioService;

public class App {
    public static void main(String[] args) {

        DatosEnvio datos1 = new DatosEnvio("10001", "Polimeros Colombia", 1200.0, 400.0);
        EnvioService.agregarEnvio(TipoTransporte.TERRESTRE, datos1);

        DatosEnvio datos2 = new DatosEnvio("10002", "Textiles Pepalfa", 500.0, 600.0);
        EnvioService.agregarEnvio(TipoTransporte.TERRESTRE, datos2);

        DatosEnvio datos3 = new DatosEnvio("10003", "Flores Colombia", 1500.0, 2000.0);
        EnvioService.agregarEnvio(TipoTransporte.AEREO, datos3);

        EnvioView vista = new EnvioView();

        EnvioController controlador = new EnvioController(vista);

        controlador.iniciar();
    }
}
