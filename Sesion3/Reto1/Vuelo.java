public class Vuelo {
    final String codigoVuelo;
    String destino;
   String horaSalida;
   Pasajero asientoReservado;

    public Vuelo(String codigoVuelo, String destino, String horaSalida){
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.asientoReservado = null;
    }

    public boolean reservarAsiento(Pasajero p){
        if(asientoReservado == null){
            asientoReservado = p;
            return true;
        }else{
            return false;
        }
    }

    // Metodo con sobrecarga, reserva con cadena simple
    public boolean reservarAsiento(String nombre, String pasaporte){
        Pasajero nuevoPasajero = new Pasajero(nombre, pasaporte);
        return reservarAsiento(nuevoPasajero);
    }

    public void cancelarReserva(){
        asientoReservado = null;
    }

    public String obtenerItinerario(){
        String informacion = "Intinerario de vuelo: \n";
        informacion+= "Código: " + codigoVuelo + "\n";
        informacion+= "Destino: " + destino + "\n";
        informacion+= "Salida: " + horaSalida + "\n";

        if (asientoReservado != null){
            informacion += "Pasajero: " + asientoReservado.nombre + "\n";
        }else{
            informacion += "Pasajero: [Sin reserva]\n";
        }
        return informacion;
    }

}
