package Practice.net;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try(
               Socket socket = new Socket("localhost", 500);

               BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ){
            System.out.println(reader.readLine());
            writer.write("Message from client!\n");
            writer.flush();
        }
    }
}
