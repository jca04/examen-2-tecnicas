package fabricas;

import modelos.DatosEnvio;
import modelos.Envio;
import modelos.Express;

public class ExpressFactory extends EnvioFactory {

    @Override
    public Envio crearEnvio(DatosEnvio datos) {
        return new Express(datos.codigo(), datos.cliente(), datos.peso(), datos.distancia());
    }
}