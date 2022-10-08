import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//fixed thread pool
public class Question2_2 {
    public static void main(final String []args) throws InterruptedException,ExecutionException
    {
        System.out.println("Thread main started");
        final ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.shutdown();
        System.out.println("Thread main finished.....");
    }
    
}
