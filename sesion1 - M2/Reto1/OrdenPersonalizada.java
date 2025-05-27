public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo, cantidad);
        this.cliente = cliente;
    }
    
    @Override
    public String mostrarResumen(){
        return "Orden Personalizada -  Código: " + codigo + " - Cantidad: " + cantidad;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    
}
