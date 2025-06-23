import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Principal {
    public static void main(String[] args) {
        
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Pedro", "Domicilio","555-1234"),
            new Pedido("José", "Domicilio", "555-5678"),
            new Pedido("Alex", "Local", null)
        );

        System.out.println("Procesando confirmaciones...\n");

        pedidos.stream()
                    .filter(p -> p.getTipoEntrega().equalsIgnoreCase("Domicilio"))   //Filtrar solo los pedidos con tipo de entrega "domicilio".
                    .map(Pedido::getTelefono)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map(telefono -> "Confirmación enviada al número: " + telefono)   
                    .forEach(System.out::println);   
    }
    
}
