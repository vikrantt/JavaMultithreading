// Create and Run a Thread using Runnable Interface and Thread class and show 
// usage of sleep and join methods in the created threads.
class Thread1 extends Thread
{
    public void run()
    {
        System.out.println("Thread1 running....");
    }
}


class Thread2 extends Thread
{
    public void run()
    {
        System.out.println("Thread2 running....");
    }
}

class Thread3 extends Thread
{
    public void run()
    {
        System.out.println("Thread3 running....");
    }
}


public class Question1
{
    public static void main(String[] args) throws InterruptedException {
        Thread1 ob1= new Thread1();
        Thread2 ob2= new Thread2();
        Thread3 ob3= new Thread3();
        ob1.start();
        ob1.join();
        //until thread1 will not finish it's operation thread2 will wait.
        ob2.start();
        ob2.join();
        Thread.sleep(2000);
        ob3.start();
    }
}