package AlgorithmsLessons.Lesson10;

public class Main {

    public static void main(String[] args) {
        PowerSet pwset = new PowerSet();
        pwset.printTable();

        pwset.put("test");
        pwset.put("hello");
        pwset.put("world");
        pwset.put("hello");

        pwset.printTable();

    }

}
