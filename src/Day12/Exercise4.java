package Day12;

import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;

public class Exercise4 {
    public static void main(String[] args) throws InterruptedException {
        charBuffer();
        intBuffer();
    }

    public static void charBuffer(){
        CharBuffer buffer = CharBuffer.allocate(12);
        String str = "DemoString";

        System.out.println("CharBuffer states before writing to it:");
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());

        for(int i = 0; i < str.length(); i++){
            buffer.put(str.charAt(i));
        }

        buffer.flip();

        System.out.println("CharBuffer states after writing to it:");
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());

        while(buffer.position() < buffer.limit()){
            System.out.print(buffer.get());
        }
    }

    public static void intBuffer(){
        IntBuffer buffer = IntBuffer.allocate(12);
        String str = "DemoString";

        System.out.println("IntBuffer states before writing to it:");
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());

        for(int i = 0; i < str.length(); i++){
            buffer.put(str.charAt(i));
        }

        buffer.flip();

        System.out.println("IntBuffer states after writing to it:");
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());

        while(buffer.position() < buffer.limit()){
            System.out.print((char)buffer.get());
        }
    }
}
