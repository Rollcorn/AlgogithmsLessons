package AlgorithmsLessons.Lesson10;

public class Main {

    public static void main(String[] args) {


        PowerSet pwset1 = new PowerSet();

        System.out.println("Set1");
        pwset1.put("test");
        pwset1.put("hello");
        pwset1.put("world");
        pwset1.put("hello");

        pwset1.printTable();

        PowerSet pwset2 = new PowerSet();

        System.out.println("Set2");
        pwset2.put("test");
        pwset2.put("hello");
        pwset2.put("my");
        pwset2.put("dear");

        pwset2.printTable();


        PowerSet pwsetEmpty = new PowerSet();
        
        /*********************************************
         * Check Difference
         */
        System.out.println("Difference set1 - set2");
        PowerSet pwset3 = pwset1.difference(pwset2);
        pwset3.printTable();

        System.out.println("Difference with empty set");
        PowerSet pwset7 = pwset1.difference(pwsetEmpty);
        pwset7.printTable();

        System.out.println("Difference set2 - set1");
        PowerSet pwset12 = pwset2.difference(pwset1);
        pwset12.printTable();

        System.out.println("Difference set1 - set1");
        PowerSet pwset17 = pwset1.difference(pwset1);
        pwset17.printTable();

        /*********************************************
         * Check Intersection
         */
        System.out.println("Intersection");
        PowerSet pwset4 = pwset1.intersection(pwset2);
        pwset4.printTable();
        
        System.out.println("Intersection set1 with empty set");
        PowerSet pwset8 = pwset1.intersection(pwsetEmpty);
        pwset8.printTable();

        System.out.println("Intersection empty with set1");
        PowerSet pwset13 = pwsetEmpty.intersection(pwset1);
        pwset13.printTable();

        System.out.println("Intersection set1 with set1");
        PowerSet pwset14 = pwset1.intersection(pwset1);
        pwset14.printTable();
        
        
        /*********************************************
         * Check Union
         */
        System.out.println("Union");
        PowerSet pwset6 = pwset1.union(pwset2);
        pwset6.printTable();

        System.out.println("Union with empty set");
        PowerSet pwset9 = pwset1.union(pwsetEmpty);
        pwset9.printTable();

        System.out.println("Union set1 with set1");
        PowerSet pwset15 = pwset1.union(pwset1);
        pwset15.printTable();

        /*********************************************
         * Check Subset
         */
        System.out.println("Subset with \"false\"");
        boolean subsetCheck = pwset1.isSubset(pwset2);
        System.out.println("Subset check = " + subsetCheck);

        System.out.println("Subset with empty set");
        boolean subsetCheck2 = pwset1.isSubset(pwset2);
        System.out.println("Subset check = " + subsetCheck2);

        System.out.println("Subset with   \"true\"");
        PowerSet pwset11 = new PowerSet();
        pwset11.put("test");
        pwset11.put("hello");
        boolean subsetCheck3 = pwset1.isSubset(pwset11);
        System.out.println("Subset check = " + subsetCheck3);

        System.out.println("Subset set1 and set1");
        boolean subsetCheck4 = pwset1.isSubset(pwset1);
        System.out.println("Subset check = " + subsetCheck4);

    }

}
