package Practice.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class netPractice {
    public static void main(String[] args) throws IOException {
        URL url = null;
        URLConnection conn = null;
        BufferedReader reader = null;

        try{
            url = new URL("https://en.wikipedia.org/wiki/India");
            conn = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String temp = null;
            while((temp = reader.readLine()) != null){
                System.out.println(temp);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(reader != null) reader.close();
        }

    }
}
