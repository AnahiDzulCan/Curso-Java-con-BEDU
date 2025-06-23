public class Articulo extends MaterialCurso{

    int palabras;

    public Articulo(String titulo, String autor, int palabras){
        super(titulo, autor);
        this.palabras = palabras;
    }

    @Override
     public String mostrarDetalle(){
        return "Artículo: " + titulo + " - Autor: " + autor + " - Palabras: " + palabras;
    }
    
}
