package Day17;


@FunctionalInterface
public interface StudentsFactory {
    public Student create(String name, int marks);
}
