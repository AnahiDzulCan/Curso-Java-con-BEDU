public abstract class OrdenProduccion {

    protected String codigo;
    protected int cantidad;

    //constructor
    public OrdenProduccion(String codigo, int cantidad){
        this.codigo = codigo;
        this.cantidad =  cantidad;
    }


    //getter y setter   
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //metodo
    public abstract String mostrarResumen();



}