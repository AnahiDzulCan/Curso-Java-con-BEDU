public class OrdenMasa extends OrdenProduccion {

    public OrdenMasa(String codigo,int cantidad){
        super(codigo,cantidad);
    }

    @Override
    public String mostrarResumen(){
        return "OrdenMasa - Código: " + codigo + "- Cantidad: " + cantidad;
    }
}
