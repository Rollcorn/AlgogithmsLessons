package AlgorithmsLessons.Lesson8;

public class Main {
    
    public static void t_find(HashTable ht, String val){
        System.out.println("The find slot = " + val + " : " + ht.find(val));

    }

    public static void main(String[] args) {


        
        HashTable mHTable = new HashTable(17, 3);

        mHTable.put("Hello");
        mHTable.put("my");
        mHTable.put("name");
        mHTable.put("is");
        mHTable.put("Sarah");
        mHTable.put("i");
        mHTable.put("am");
        mHTable.put("from");
        mHTable.put("California");
        mHTable.put("And");
        mHTable.put("i");
        mHTable.put("am");
        mHTable.put("very");
        mHTable.put("pleased");
        mHTable.put("to");
        mHTable.put("meet");
        mHTable.put("you");

        System.out.println("The hashcode = " + mHTable.hashFun("H"));

        mHTable.printTable();

        t_find(mHTable, "meet" );

        HashTable mHTable2 = new HashTable(17, 3);

        mHTable2.put("1");
        mHTable2.put("2");
        mHTable2.put("3");
        mHTable2.put("4");
        mHTable2.put("5");
        mHTable2.put("6");
        mHTable2.put("7");
        mHTable2.put("8");
        mHTable2.put("9");
        mHTable2.put("10");
        mHTable2.put("11");
        mHTable2.put("12");
        mHTable2.put("13");
        mHTable2.put("14");
        mHTable2.put("15");
        mHTable2.put("16");
        mHTable2.put("17");

        mHTable2.printTable();





    }
}
