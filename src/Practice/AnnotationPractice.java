package Practice;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface newAnnotation{
    int value();
}


public class AnnotationPractice {


    public static void main( @newAnnotation(100) String[] args) throws NoSuchMethodException {
        Annotation anno = AnnotationPractice.class.getAnnotation(newAnnotation.class);
        if(anno != null) System.out.println();
    }


}

@FunctionalInterface
interface newInterface{
    public void print();
}
