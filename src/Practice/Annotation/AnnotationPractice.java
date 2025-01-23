package Practice.Annotation;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Check
public class AnnotationPractice {
    public static void main(String[] args) throws NoSuchMethodException {
        String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classpath);
    }
}

@Check
interface face{

}
