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





    }
}
