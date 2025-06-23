import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        
        List<MaterialCurso> materiales = new ArrayList<>();

        materiales.add(new Video("Introducción a java", "Mario", 15));
        materiales.add(new Video("POO en java", "Carla", 20));

        materiales.add(new Articulo("Historia de java'", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));

        materiales.add(new Ejercicio("Variables y tipos", "Luis", false));
        materiales.add(new Ejercicio("Condicionales", "Mario", false));

        Complemento.mostrarMateriales(materiales);
    
            // Duración de videos
        List<Video> soloVideos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video video) soloVideos.add(video);
        }
        Complemento.contarDuracionVideos(soloVideos);

        // Marcar ejercicios revisados
        Complemento.marcarEjerciciosRevisados(materiales);

   
    }
 
}
