//deadlock case
import java.util.concurrent.*;
import java.util.*;
class Thread1 extends Thread
{
    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    public void run()
    {
        synchronized(Question5.resource1)
        {
            System.out.println("Desktop "+" locked:"+Question5.resource1);
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {

            }
        }

        System.out.println("Desktop "+"waiting for "+Question5.resource2+"...............");
        synchronized(Question5.resource2)
        {
            System.out.println("Desktop "+"Locked"+Question5.resource2);
        }
    }
}

class Thread2 extends Thread
{
    public void run()
    {
        synchronized(Question5.resource2)
        {
            System.out.println("Desktop "+" locked:"+Question5.resource2);
            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {

            }
        }

        System.out.println("Desktop "+"waiting for "+Question5.resource1+"...............");
        synchronized(Question5.resource1)
        {
            System.out.println("Desktop "+"Locked"+Question5.resource1);
        }
    }
}

public class Question5
{
    public static String resource1= "printer";
    public static String resource2= "scanner";
    public static void main(String[] args) {
        Thread1 th1= new Thread1();
        Thread2 th2= new Thread2();
        th1.start();
        th2.start();
    }
}
