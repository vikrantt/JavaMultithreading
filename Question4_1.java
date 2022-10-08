import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.*;
//Implementation of callable
class CallableMessage implements Callable<String> 
{
    public String call() throws Exception
    {
        return "Exception is thrown from call method of callable";
    }
}
public class Question4_1 {
    static ExecutorService executor= Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws Exception{
        CallableMessage task= new CallableMessage();
        Future<String> message= executor.submit(task);
        System.out.println(message.get().toString());
    }
    
}
