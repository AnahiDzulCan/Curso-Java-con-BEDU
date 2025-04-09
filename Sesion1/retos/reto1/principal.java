public class principal {
    public static void main(String[] args) {

        Paciente paciente1 = new Paciente();

        paciente1.paciente = "Alexander";
        paciente1.edad = 12;
        paciente1.numExpediente = "EXP202409";

        paciente1.mostrarInformacion();
    }
}
