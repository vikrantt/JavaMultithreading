import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableImplementation implements Runnable
{
    public void run()
    {
        System.out.println("Run method is running.....");
    }
}

public class Question4_2 {
    static ExecutorService executor= Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        RunnableImplementation ob1 = new RunnableImplementation();
        Thread thread= new Thread(ob1);
        thread.start();
        executor.submit(ob1);
    }
    
}
