import java.util.List;

public class Principal {
    public static void main(String[] args) {
        
        //encuestas x sucursal -> lista
        List<Sucursal> sucursales =  List.of(
            new Sucursal("Centro", List.of(
                new Encuesta("Juan", "Buena atención pero el tiempo de espera es largo.", 3),
                new Encuesta("Pepe", null, 3)
            )),
            new Sucursal("Norte", List.of(
                new Encuesta("Pedro", "Falta cuidado", 4),
                new Encuesta("José", "Atención a clientes muy vaga", 3)
            )),
            new Sucursal("Sur", List.of(
                new Encuesta("Andres", null, 3),
                new Encuesta("María", "Poca variedad en medicamentos", 4)
            ))
        );

        System.out.println("\n Seguimientos a los pacientes insatisfechos: \n");

        sucursales.stream()
             .flatMap(sucursal -> 
                    sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .map(encuesta -> new Seguimiento(encuesta,sucursal.getNombre()))
               )

               .filter(seg -> seg.encuesta().getComentario().isPresent())
               .map( seg -> {
                String comentario = seg.encuesta().getComentario().get();
                return "Sucursal " + seg.sucursal() + ": Seguimineto a paciente con comentario:\n \"" + comentario + "\"\n";
               })
               .forEach(System.out::println);
    }

    record Seguimiento(Encuesta encuesta, String sucursal){
    }
    
}
