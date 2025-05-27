public class Principal {
    public static void main(String[] args) {

        CajaMisteriosa<String> cajita = new CajaMisteriosa();

        cajita.guardar("Hola mundo");
        
        String valor = cajita.sacar(); 

        System.out.println("El valor de la caja  es => " + valor);

        CajaMisteriosa<Integer> cajitaNumeros = new CajaMisteriosa<>();
        cajitaNumeros.guardar(1);
    }
}

//arg = argumentos extra, [] se refiere a un arreglo => un arreglo deargumentos y si lleva ... no se determina la cantida de string
//Polimorfismo -> 
/*
 *  Herencia -> Especializacion, de lo general a lo particular, Arrriba a abajo
 *  polimorfismo -> Generalizacion, Michi -> animal, de abajo hacia arriba, de un gato hacia un animal.
 * 
 * Datos primitivos, que nacieron con el lenguaje de progranmación, los basicos, int, float, double, byte, boolena, short.
 * 
 * String NO es un tipo de dato primitivo.  
 * 
 * Wrapper Class -> version objeto de los tipos de datos primitivos
 * int -> Integer
 * float -> Float
 * double-> Double
 * boolean -> Boolean
 * short -> Short
 * char-> Char
 */