import java.util.*;

class Line{
    synchronized public void getLine()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(i);
            try{
                Thread.sleep(30);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class Train extends Thread
{
    Line line;
    Train(Line line)
    {
        this.line= line;
    }
    public void run()
    {
        line.getLine();
    }
}


public class Question3 {
    public static void main(String[] args) {
        Line ob= new Line();
        Train train1= new Train(ob);
        Train train2= new Train(ob);

        train1.start();
        train2.start();
    }
}
