import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {

    private String nombre;
    private ReentrantLock lock;

    public RecursoMedico(String nombre){
        this.nombre = nombre;
        this.lock =  new ReentrantLock();
    }

    public void usar(String profesional){
        //Para que solo ueda entrar un hilo a la vez
        lock.lock();
        try{
            System.out.println(profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000);//simular el uso del recurso
            System.out.println(profesional + " ha salido de " + nombre);
        }catch(InterruptedException e){
            System.out.println(profesional + "fue interrumpido.");
        }finally{
            lock.unlock();//liberar recurso
        }
    }

 //dios nos acompañe   
}