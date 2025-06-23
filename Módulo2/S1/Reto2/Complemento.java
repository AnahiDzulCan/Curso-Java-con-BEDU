import java.util.List;

public class Complemento {
    
       public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("\nMateriales del curso: ");
        for (MaterialCurso material : lista) {
            System.out.println(material.mostrarDetalle());
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
       int total = 0;
       for (Video video : lista) {
           total += video.getDuracion();
        }
        System.out.println("\nDuración total de videos: " + total + " minutos\n");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
    for (Object obj : lista) {
        if (obj instanceof Ejercicio ejercicio) {
            ejercicio.setRevisado(true);
            System.out.println("Ejercicio '" + ejercicio.getTitulo() + "' marcado como revisado.");
        }
    }

}


}
