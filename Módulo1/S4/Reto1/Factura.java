import java.util.Objects;

public class Factura {
    String folio;
    String cliente;
    double total;

    //Constructor
    public Factura (String folio, String cliente, double total){
        this.folio =  folio;
        this.cliente = cliente;
        this.total =  total;
    }

    @Override //Mostrar información de la factura
    public String toString() {
        return "Factura [Folio = "+ folio + ", Cliente = " + cliente + ", Total = $" + total + "]";
    }

    @Override //Para comparar las dos facturas
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof  Factura)) return false;
        Factura other = (Factura) obj;
        return  folio.equals(other.folio);
    }

    @Override
    public int hashCode(){
        return Objects.hash(folio);
    }
}
