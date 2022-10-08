import java.util.*;

class Thread1 extends Thread
{
    Table t;
    Thread1(Table t)
    {
        this.t=t;
    }
    public void run()
    {
        t.printTable(3);
    }
}

class Thread2 extends Thread
{
    Table t;
    Thread2(Table t)
    {
        this.t=t;
    }
    public void run()
    {
        t.printTable(4);
    }
}
 
class Table
{
    void printTable(int n)
    {
        synchronized(this)  //synchronized block
        {
            for(int i=1;i<=5;i++)
            {
                System.out.println(n*i);
                try
                {
                    Thread.sleep(30);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
}

//synchronized block
public class Question3_1 {
    public static void main(String[] args) {
        Table ob1 = new Table();
        Thread1 t1= new Thread1(ob1);
        Thread t2= new Thread2(ob1);
        t1.start();
        t2.start();
    }
}
