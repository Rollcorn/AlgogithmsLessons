package AlgorithmsLessons.Lesson9;

public class Main {
 
    public static void main(String[] args) {
        NativeDictionary<Integer> dict = new NativeDictionary<Integer>(17, Integer.class);

        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);
        dict.put("five", 5);
        dict.put("six", 6);
        dict.put("seven", 7);
        dict.put("eaght", 8);
        dict.put("nine", 9);
        dict.put("ten", 10);
        dict.put("eleven", 11);
        dict.put("twelth", 12);
        dict.put("thirteen", 13);
        dict.put("fourteen", 14);
        dict.put("fifteen", 15);
        dict.put("sixteen", 16);
        dict.put("seventeen", 17);

        dict.printTable();

        System.out.println(dict.get("four"));
        System.out.println(dict.get("sixteen"));
        System.out.println(dict.get("fourteen"));
        System.out.println(dict.get("hello"));

        System.out.println(dict.isKey("four"));
        System.out.println(dict.isKey("Hello"));

        dict.put("sixteen", 61);
        dict.printTable();



    }
}
