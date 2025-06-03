import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(700);
        return"Control Térmico: temperaturas dentro del rango";
    }
}
