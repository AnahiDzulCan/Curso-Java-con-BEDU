import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

public class TemarioMensual {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();
        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));

        Collections.sort(temas); // Usa compareTo()
        System.out.println("\nTemas ordenados alfabéticamente:");
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("\nTemas ordenados por prioridad:");
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medioambiente");

        System.out.println("\nRecursos por tema:");
        for (String titulo : recursos.keySet()) {
            System.out.println(titulo + " → " + recursos.get(titulo));
        }
    }
}
