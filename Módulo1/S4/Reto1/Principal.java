public class Principal {
    public static void main(String[] args) {
        //Facturas
        Factura factura1 = new Factura("FAC001","Juan Pérez", 145.0);
        Factura factura2 =  new Factura("FAC001","Comercial XYZ", 145.0);

        //Muestra toString()
        System.out.println("\n" + factura1.toString());
        System.out.println(factura2.toString());

        //Comprara los equals
        System.out.println("\n Las facturas son iguales: " + factura1.equals(factura2));
    }
}
