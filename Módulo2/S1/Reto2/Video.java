public class Video extends MaterialCurso {

    int duracion;

    public Video(String titulo, String autor, int duracion){
        super(titulo,autor);
        this.duracion =  duracion;
    }
    
    @Override
    public String mostrarDetalle() {
        return "Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min";
    }

    public int getDuracion() {
        return duracion;
    }

}
