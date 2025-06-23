public class CajaMisteriosa <tipo> {
    private tipo valor;

    public void guardar(tipo nuevoValor){
        this.valor = nuevoValor;
    }
    public tipo sacar(){
        return valor;
    }

    public boolean estaVacia(){
        return valor == null;
    }
}


/*Clase object es el padre de todos
 * tecnicamente es decir que declaramos lo que sea.
 * Se le pone T por el tipo, 
 */