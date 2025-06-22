public abstract class UnidadEmergencia {
    String nombre;

    public UnidadEmergencia(String nombre){
        this.nombre = nombre;
    }

    public abstract void responder();

    public void activarUnidad(){
        System.out.println("\nActivando unidad: " + nombre);
    }

}
