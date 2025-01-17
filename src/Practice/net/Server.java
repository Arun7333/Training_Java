package Practice.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try(
                ServerSocket server = new ServerSocket(500);
                Socket socket = server.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ){
            writer.write("Message from server!\n");
            writer.flush();
            System.out.println(reader.readLine());
        }
        catch (Exception e){

        }


    }
}
