import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class Task implements Runnable
{
    @Override
    public void run()
    {
        for(int i=0;i<3;i++)
        {
            System.out.println("["+Thread.currentThread().getName()+"]"+"Message "+i);
            try
            {
                Thread.sleep(200);
            }
            catch(final InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

//Single Thread Executor

public class Question2 {
    public static void main(String[] args)throws InterruptedException,ExecutionException {
        System.out.println("Thread main Started.....");
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
                TimeUnit.SECONDS.sleep(4);
            }
            catch(InterruptedException ex)
            {
                throw new IllegalStateException(ex);
            }
        };

        Runnable task3= ()->
        {
            System.out.println("Executing task3: "+Thread.currentThread().getName());
            try
            {
                TimeUnit.SECONDS.sleep(8);
            }
            catch(InterruptedException ex)
            {
                throw new IllegalStateException(ex);
            }
        };

        final ExecutorService executorService= Executors.newSingleThreadExecutor();
        System.out.println("Submitting the tasks for executions....");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.shutdown();
        System.out.println("Thread main finished...");
    }
}
