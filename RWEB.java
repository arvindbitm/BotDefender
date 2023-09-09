import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class RWEB 
    {

    public static void main(String[] args) 
      {
       try 
           {
            URL url = new URL("http://dacafdataset.com/state.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            line = in.readLine();
            System.out.println(line);
            in.close();
           }
        catch (Exception e) { }
        }
    }