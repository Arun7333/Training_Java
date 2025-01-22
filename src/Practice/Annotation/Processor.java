package Practice.Annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.util.Set;


@SupportedAnnotationTypes({"newAnnotation"})
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class Processor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        System.out.println("Working");
        for(Element element : roundEnv.getElementsAnnotatedWith(newAnnotation.class)){
            Name className = element.getSimpleName();
            System.out.println(className.toString());

            try{
                Messager messager = processingEnv.getMessager();
                messager.printError("Opened");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        return true;
    }
}
