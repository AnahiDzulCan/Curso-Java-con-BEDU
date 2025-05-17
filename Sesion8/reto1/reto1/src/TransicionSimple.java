public class TransicionSimple implements TransicionHistoria{

    @Override
    public void transicionar(String decision){

        switch (decision) {
            case "1":
                System.out.println("→ Transición: El héroe entra al castillo.");
                break;
            case "2":
                System.out.println("→ Transición: El héroe se adentra en el bosque oscuro.");
                break;
            default:
                System.out.println("→ Transición: El héroe se queda en el pueblo.");
        }

    }

}
