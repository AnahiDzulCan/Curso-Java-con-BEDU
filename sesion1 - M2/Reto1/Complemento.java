import java.util.List;

public class Complemento {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista){
        for(OrdenProduccion orden: lista){
            System.out.println(orden.mostrarResumen());
        }
    }

        //ProcesarOrdenesPersonalizadas
        public static void ProcesarOrdenesPersonalizadas(List<? super OrdenPersonalizada> lista, int CostoAdicional){
            System.out.println("\n Procesando órdenes personalizadas...");
            for(Object obj: lista){
                if(obj instanceof OrdenPersonalizada){
                    OrdenPersonalizada personalizada = (OrdenPersonalizada) obj;
                    System.out.println("Orden " + personalizada.codigo + "ajustado con costo adicional de $" + CostoAdicional);
                }
            }
        }
   
    
}
