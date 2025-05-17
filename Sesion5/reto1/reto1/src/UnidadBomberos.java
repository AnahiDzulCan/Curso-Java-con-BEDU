public class UnidadBomberos extends UnidadEmergencia {

    @Override
    public void responder(){
        System.out.println("Unidad de bomberos respondiendo a incendio estructural");
    }

    SistemaGPS gps;
    Sirena sirena;
    Operador operador;

    public UnidadBomberos(String nombre, String nombreOperador) {
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
