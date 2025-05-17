public class Ambulancia extends UnidadEmergencia {

    SistemaGPS gps;
    Sirena sirena;
    Operador operador;

    public Ambulancia(String nombre, String nombreOperador) {
        super(nombre);
        this.gps = new SistemaGPS();
        this.sirena = new Sirena();
        this.operador = new Operador(nombreOperador);
    }

    public void IniciarOperacion(){
        activarUnidad();
        gps.localizar();
        sirena.activarSirenas();
        operador.reportarse();
        responder();

    }

    @Override
    public void responder() {
        System.out.println("Ambulancia en camino al hospital más cercano.");
    }


}
