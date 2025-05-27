import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        
    List<OrdenProduccion> listaOrdenes = new ArrayList<>();    

    //Ordenes de tipo en masa
    listaOrdenes.add(new OrdenMasa("A123", 500));
    listaOrdenes.add(new OrdenMasa("A124",750));
    listaOrdenes.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
    listaOrdenes.add(new OrdenPersonalizada("P789", 150, "ClienteY"));
    listaOrdenes.add(new OrdenPrototipo("T789", 10, "Diseño"));
    listaOrdenes.add(new OrdenPrototipo("T790", 5, "Pruebas"));

     // Mostrar por tipo
        System.out.println("📋 Órdenes registradas:");
        listaOrdenes.stream().filter(o -> o instanceof OrdenMasa)
                .forEach(o -> System.out.println(o.mostrarResumen()));

        System.out.println("\n📋 Órdenes registradas:");
        listaOrdenes.stream().filter(o -> o instanceof OrdenPersonalizada)
                .forEach(o -> System.out.println(o.mostrarResumen()));

        System.out.println("\n📋 Órdenes registradas:");
        listaOrdenes.stream().filter(o -> o instanceof OrdenPrototipo)
                .forEach(o -> System.out.println(o.mostrarResumen()));

        // Procesar personalizadas
        Complemento.ProcesarOrdenesPersonalizadas(listaOrdenes, 200);

        // Resumen
        long totalMasa = listaOrdenes.stream().filter(o -> o instanceof OrdenMasa).count();
        long totalPers = listaOrdenes.stream().filter(o -> o instanceof OrdenPersonalizada).count();
        long totalProt = listaOrdenes.stream().filter(o -> o instanceof OrdenPrototipo).count();

        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + totalMasa);
        System.out.println("🛠️ Personalizadas: " + totalPers);
        System.out.println("🧪 Prototipos: " + totalProt);
    }
}
