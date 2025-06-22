import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class RegistroMuestras {

    public static void main(String[] args) {
        // Paso 1: ArrayList para registrar todas las especies en orden
        ArrayList<String> muestras = new ArrayList<>();
        muestras.add("Homo sapiens");
        muestras.add("Mus musculus");
        muestras.add("Arabidopsis thaliana");
        muestras.add("Homo sapiens"); // repetida por replicación

        // Paso 2: HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(muestras);

        // Paso 3: HashMap para asociar ID de muestra con investigador
        HashMap<String, String> idInvestigador = new HashMap<>();
        idInvestigador.put("M-001", "Dra. López");
        idInvestigador.put("M-002", "Dr. Hernández");
        idInvestigador.put("M-003", "Dra. Ramírez");
        idInvestigador.put("M-004", "Dr. Torres");

        // Paso 4: Mostrar resultados
        System.out.println("Lista completa y ordenada de muestras:");
        for (String especie : muestras) {
            System.out.println("- " + especie);
        }

        System.out.println("\nEspecies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        System.out.println("\nRelación ID de muestra → Investigador:");
        for (String id : idInvestigador.keySet()) {
            System.out.println(id + " → " + idInvestigador.get(id));
        }

        // Búsqueda por ID
        String buscarID = "M-002";
        System.out.println("\nBúsqueda de investigador por ID de muestra (" + buscarID + "):");
        if (idInvestigador.containsKey(buscarID)) {
            System.out.println(buscarID + " → " + idInvestigador.get(buscarID));
        } else {
            System.out.println("ID no encontrado.");
        }
    }
}

