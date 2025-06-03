import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(1300);
        return "Comunicaciones: Enlace con estación terrestre establecido.";
    }
}
