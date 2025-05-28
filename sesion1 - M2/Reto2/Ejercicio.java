public class Ejercicio extends MaterialCurso{
    
    boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado){
        super(titulo, autor);
        this.revisado = revisado;
    }
    
    @Override
    public String mostrarDetalle(){
       return "Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }
}
