package StudentManagementSystem.models;

import java.util.Optional;
import java.util.Random;

public interface Manager<T> {
    public Random idGenerator = new Random();

    public void add(T value);

    public void remove(int id);

    public Optional<T> get(int id);
}
