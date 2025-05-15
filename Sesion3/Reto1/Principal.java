public class Principal {
    public static void main(String[] args) {
        Pasajero pasajero = new Pasajero("Ana Martinez","M12345678");
        Vuelo vuelo = new Vuelo("UX123","París","14:30");

        boolean reservado = vuelo.reservarAsiento(pasajero);

        if (reservado){
            System.out.println("Reserva realizada con éxito.\n");
        }else {
            System.out.println("No se pudo realizar la reserva.\n");
        }

        System.out.println(vuelo.obtenerItinerario());

        System.out.println("Cancelando la reserva...\n");
        vuelo.cancelarReserva();

        System.out.println(vuelo.obtenerItinerario());

        vuelo.reservarAsiento("Mario Gonzales","O987654");
        System.out.println(vuelo.obtenerItinerario());
    }
}
