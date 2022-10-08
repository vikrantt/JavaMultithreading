import java.util.concurrent.locks.ReentrantLock;

//Using reentrant lock to avoid deadlock

class Thread1 extends Thread
{
    final ReentrantLock lockA= new ReentrantLock();
    final ReentrantLock lockB= new ReentrantLock();

    public void run()
    {
        if(lockA.tryLock())
        {
            System.out.println("Desktop "+": acquired locked on"+Question5_1.resource1);
        }
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {

        }

        if(lockB.tryLock())
        {
            System.out.println("Desktop "+": Waiting for "+Question5_1.resource2+".....");
            System.out.println("Desktop "+": acquired locked on"+Question5_1.resource2);
        }
    }
}

class Thread2 extends Thread
{
    final ReentrantLock lockA= new ReentrantLock();
    final ReentrantLock lockB= new ReentrantLock();

    public void run()
    {
        if(lockA.tryLock())
        {
            System.out.println("Desktop "+": acquired locked on"+Question5_1.resource2);
        }
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {

        }

        if(lockB.tryLock())
        {
            System.out.println("Desktop "+": Waiting for "+Question5_1.resource1+".....");
            System.out.println("Desktop "+": acquired locked on"+Question5_1.resource1);
        }
    }
}

public class Question5_1 {
    public static String resource1= "printer";
    public static String resource2= "scanner";
    public static void main(String[] args) {
        Thread1 th1= new Thread1();
        Thread2 th2= new Thread2();
        th1.start();
        th2.start();
    }
}
