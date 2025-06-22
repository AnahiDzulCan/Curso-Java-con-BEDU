public class Entrada{
    String nameEvento;
    double precioEntrada;

    public Entrada(String nameEvento, double precioEntrada){
        this.nameEvento = nameEvento;
        this.precioEntrada = precioEntrada;
    }
    public void mostrarInformacion(){
        System.out.println("Evento: " + nameEvento + "  |  Precio: " + precioEntrada);
    }
}
