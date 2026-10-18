package modelos;

public abstract class Envio {

    private String codigo;
    private String cliente;
    private Double peso;
    private Double distancia;

    public Envio(String codigo, String cliente, double peso, double distancia) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.peso = peso;
        this.distancia = distancia;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public abstract Double calcularTarifa();

    public abstract String[] obtenerDatosEnvio();

}
