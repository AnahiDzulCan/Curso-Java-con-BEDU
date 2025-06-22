public class Patrulla extends UnidadEmergencia{

    @Override
    public void responder(){
        System.out.println("Patrulla atendiendo situación de seguridad ciudadana.");
    }

    SistemaGPS gps;
    Sirena sirena;
    Operador operador;

    public Patrulla(String nombre, String nombreOperador) {
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
}
