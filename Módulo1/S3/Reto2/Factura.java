import java.util.Optional;

public class Factura {
    double monto;
    String descripcion;
    Optional<String> rfc;

    Factura(double monto, String descripcion, String rfc){
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc);
    }

    public String getResumen(){
        String ResumenFactura;
        ResumenFactura = " \n 📃 Factura generada \n" + "Descripción: " + descripcion + "\n" + "Monto: " + monto + "\n" + "RFC: " + (rfc.isPresent() ? rfc.get() : "[No proporcionado]");
        return ResumenFactura;
    }

}
