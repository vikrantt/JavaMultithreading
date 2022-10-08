import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//cached thread pool
public class Question2_1 {
    public static void main(final String []args) throws InterruptedException,ExecutionException
    {
        System.out.println("Thread main started");
        Runnable task1= ()->
        {
            System.out.println("Executing task1: "+Thread.currentThread().getName());
            try
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch(InterruptedException ex)
            {
                throw new IllegalStateException(ex);
            }
        };
        Runnable task2= ()->
        {
            System.out.println("Executing task2: "+Thread.currentThread().getName());
            try
            {
                TimeUnit.SECONDS.sleep(3);
            }
            catch(InterruptedException ex)
            {
                throw new IllegalStateException(ex);
            }
        };
        final ExecutorService executorService= Executors.newCachedThreadPool();
        System.out.println("Submitting the tasks for execution");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.shutdown();
        System.out.println("Thread main finished");

    }
}
