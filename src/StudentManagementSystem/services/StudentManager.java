package StudentManagementSystem.services;

import StudentManagementSystem.models.Pair;
import StudentManagementSystem.exceptions.IdAlreadyAvailableException;
import StudentManagementSystem.exceptions.NoObjectAvailableException;
import StudentManagementSystem.exceptions.PathInvalidException;
import StudentManagementSystem.exceptions.StudentNotAvailableException;
import StudentManagementSystem.models.Manager;
import StudentManagementSystem.models.Student;
import StudentManagementSystem.utility.Patterns;


import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.regex.Matcher;

import static java.lang.System.out;

public class StudentManager implements Manager<Student> {

    //Using a Pair of Student and File object
    //To reduce creating File object every time while writing the changes
    private Map<Integer, Pair<Student, File>> students;
    private Map<String, Comparator<Student>> comparatorMap;
    private File directory;
    private ExecutorService taskManager;

    public StudentManager(){
        students = new ConcurrentHashMap<>();
        comparatorMap = Map.of(
                "name", (u, v) -> u.getName().compareToIgnoreCase(v.getName()),
                "email", (u, v) -> u.getEmail().compareToIgnoreCase(v.getEmail()),
                "grade", (u, v) -> u.getGrade() - v.getGrade(),
                "age", (u, v) -> u.getAge() - v.getAge(),
                "id", (u, v) -> u.getId() - v.getId() // Default if field is invalid
        );
        taskManager = Executors.newFixedThreadPool(3);
    }

    public Student newStudent(String name, int age, String email, char grade){
        int id = generateId();
        Student newStudent = new Student(id, name, age, email, grade);
        out.println(newStudent.getName() + ", You're Id is " + id);

        return newStudent;
    }

    @Override
    public void add(Student student) {
        //check id duplication
        if(students.containsKey(student.getId())){
            throw new IdAlreadyAvailableException();
        }

        //inserting into the map
        students.put(student.getId(), new Pair<>(student, new File(directory, student.getId() + ".txt")));
        taskManager.submit(() ->{
            try {
                writeToFile(student.getId());
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        });
    }

    @Override
    public void remove(int id) {
        if(!students.containsKey(id)){
            throw new StudentNotAvailableException();
        }

        File file = students.get(id).getValue();
        students.remove(id);

        //delete the file from the directory
        taskManager.submit(() ->{
            try {
                deleteFile(file);
            } catch (IOException e) {
                out.println(e.getMessage());
            }
        });
    }

    @Override
    public Optional<Student> get(int id) {
        Pair<Student, File> pair = students.get(id);
        if(pair == null){
            return Optional.empty();
        }

        return Optional.of(pair.getKey());
    }

    public Optional<File> getFile(int id){
        Pair<Student, File> pair = students.get(id);
        if(pair == null){
            return Optional.empty();
        }

        return Optional.of(pair.getValue());
    }

    public void updateName(int id, String name){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setName(name);
        taskManager.submit(() ->{
            try {
                writeToFile(student.get().getId());
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        });
    }

    public void updateEmail(int id, String email){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setEmail(email);
        taskManager.submit(() ->{
            try {
                writeToFile(student.get().getId());
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        });
    }

    public void updateGrade(int id, char grade){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setGrade(grade);
        taskManager.submit(() ->{
            try {
                writeToFile(student.get().getId());
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        });
    }

    public void updateAge(int id, int age){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setAge(age);
        taskManager.submit(() ->{
            try {
                writeToFile(student.get().getId());
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        });
    }

    public void showAll(){
        if(!students.isEmpty()) {
            out.println("~~~~~~~~~~~~List of Students~~~~~~~~~~~~");
            for (Integer id : students.keySet()) {
                Student student = students.get(id).getKey();
                out.println(student);
            }
        }
        else{
            out.println("There are no students data available!");
        }
    }

    public void sortByField(String field){
        if(students.isEmpty()){
            out.println("There are no students data available!");
            return;
        }

        out.println("~~~~Students after sorted~~~~");
        students.values().stream()
                .map(Pair::getKey)
                .sorted(comparatorMap.getOrDefault(field, comparatorMap.get("id")))
                .forEach(out::println);
    }

    public void filterByField(String field, int key){
        Predicate<Student> filterFunc;

        //setting the filter function dynamically
        if(field.equals("grade")){
            filterFunc = student -> student.getGrade() == key;
        }
        else{
            filterFunc = student -> student.getAge() == key;
        }

        out.println("~~~~Students after filtered~~~~");
        students.values().stream()
                .map(Pair::getKey)
                .filter(filterFunc)
                .forEach(out::println);
    }

    public int generateId(){
        int randomID = idGenerator.nextInt(1000);
        while(students.containsKey(randomID)){
            randomID = idGenerator.nextInt(1000);
        }

        return randomID;
    }

    public void setDirectory(String directoryPath) throws IOException {
        //validating the directory path
        Matcher pathMatcher = Patterns.directoryPattern.matcher(directoryPath);
        if(!pathMatcher.matches()){
            throw new PathInvalidException("Given directory path is invalid!");
        }

        directory = new File(directoryPath);

        //checking the directory availability
        checkDirectory();
        out.println("Directory successfully changed.....");
    }

    public void checkDirectory() throws IOException {
        //if the directory not exists, make a new one
        if (!directory.exists()) {
            if(!directory.mkdirs()){
                directory = null;
                throw new IOException("There is some mistakes in directory path, check it and Try again!");
            }
            out.println("Directory created!");
        }

        //check is it a directory
        if(!directory.isDirectory()){
            directory = null;
            throw new IOException("The given path is not a directory, check it and Try again!");
        }
    }

    public void writeToFile(int id) throws IOException {
        //null check of the directory
        if(directory == null){
            throw new IOException("First set the directory and Try again!");
        }

        //getting the student object for writing
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        //getting the file object from the pair and write the object to it
        File newFile = getFile(id).orElse(new File(id + ".txt"));

        //only one thread can write to the file at a time
        synchronized (newFile) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newFile))) {
                oos.writeObject(student.get());
            } catch (IOException e) {
                throw new IOException("Can't write into a file");
            }
        }
    }

    public void deleteFile(File newFile) throws IOException {
        //null check of the directory
        if(directory == null){
            throw new IOException("First set the directory and Try again!");
        }

        if(!newFile.delete()){
            throw new IOException("can't the delete the file " + newFile.getName());
        }
    }

    public void readFromFile(String fileName) throws IOException {
        //checks the validity of the file name
        Matcher pathMatcher = Patterns.textFilePattern.matcher(fileName);
        if(!pathMatcher.matches()){
            throw new PathInvalidException("Given text file path is invalid!");
        }

        //reading the file object and add it to the map
        File file = new File(fileName);
        if(!file.exists()) throw new FileNotFoundException("File not found!");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            Optional<Student> student = Optional.ofNullable((Student)ois.readObject());
            student.ifPresentOrElse(this::add, () ->{
                throw new NoObjectAvailableException("Student object is null in this file!");
            });
        }
        catch (IOException e){
            throw new IOException("can't read from the file");
        } catch (ClassNotFoundException e) {
            throw new NoObjectAvailableException("No Student object available in this file!");
        }
    }

    public void readFromDirectory(String directoryPath) throws IOException {
        //validating the directory path
        Matcher pathMatcher = Patterns.directoryPattern.matcher(directoryPath);
        if(!pathMatcher.matches()){
            throw new PathInvalidException("Given path is invalid!");
        }

        File directory = new File(directoryPath);
        //checking the directory existence
        if(!directory.exists() || !directory.isDirectory()){
            throw new PathInvalidException("There is no directory called " + directoryPath + " is available!");
        }

        //read all the text files
        File[] files = directory.listFiles();
        if(files != null) {
            for (File currFile : files) {
                if (currFile.isFile() && currFile.getName().endsWith(".txt")) {
                    try {
                        out.print(currFile.getName() + " ------> ");
                        readFromFile(currFile.getPath());
                        out.println("~~successfully read~~");
                    }
                    catch (Exception e){
                        out.println("Caught : " + e.getMessage());
                    }
                }
            }
        }
    }

    public void completeTasks(){
        taskManager.shutdown();
        try {
            while (!taskManager.isTerminated()) {
                out.print(".");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
