import java.util.concurrent.Callable;

public class SistemaSoportevital implements Callable<String> {
    @Override
    public String call() throws Exception{
        Thread.sleep(1200);
        return"Soporte Vital: Condiciones internas estables.";
    }
}
