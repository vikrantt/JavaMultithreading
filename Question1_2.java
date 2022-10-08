// Create and Run a Thread using Runnable Interface and Thread class and show 
// usage of sleep and join methods in the created threads.
class Thread1 implements Runnable
{
    public void run()
    {
        System.out.println("Thread1 running....");
    }
}


class Thread2 implements Runnable
{
    public void run()
    {
        System.out.println("Thread2 running....");
    }
}

class Thread3 implements Runnable
{
    public void run()
    {
        System.out.println("Thread3 running....");
    }
}


public class Question1_2
{
    public static void main(String[] args) throws InterruptedException {
        Thread1 ob1= new Thread1();
        Thread2 ob2= new Thread2();
        Thread3 ob3= new Thread3();
        //We need to create object of thread class and pass because runnable interface
        //don't have start method and without start method we can't execute thread
        Thread t1= new Thread(ob1);
        t1.start();
        Thread t2= new Thread(ob2);
        Thread.sleep(2000);
        t2.start();

        Thread t3= new Thread(ob3);
        t2.join();
        t3.start();
    }
}