package fabricas;

import modelos.DatosEnvio;
import modelos.Envio;
import modelos.TipoTransporte;

public abstract class EnvioFactory {

    public abstract Envio crearEnvio(DatosEnvio datos);

    public static EnvioFactory getFactory(TipoTransporte tipo) {
    return switch (tipo) {
        case AEREO -> new AereoFactory();
        case TERRESTRE -> new TerrestreFactory();
        case MARITIMO -> new MaritimoFactory();
        case EXPRESS -> new ExpressFactory();
    };
}
}
