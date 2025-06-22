public class CentralEmergencias {
    public static void main(String[] args) {
        Ambulancia ambulancia =  new Ambulancia("Ambulancia", "Pedro");
        ambulancia.IniciarOperacion();

        Patrulla patrulla = new Patrulla("Patrulla", "Pedro");
        patrulla.IniciarOperacion();

        UnidadBomberos unidadBomberos = new UnidadBomberos("UnidadBomberos", "Pedro");
        unidadBomberos.IniciarOperacion();

    }


}
