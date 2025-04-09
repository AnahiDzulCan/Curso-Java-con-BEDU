public class Principal {
    public static void main(String[] args) {
        //crear objetos
        // 1.Clase a la que pertenece al objeto
        // 2. Identificador
        // 3. new + constructor

        Estudiante estudiante1 =new Estudiante();
        //el contructor se crea por default si no tiene valores.
        estudiante1.nombre = "Anahi";
        estudiante1.edad = 21;
        //llamar a la clase
        estudiante1.saludar();
    }
}
