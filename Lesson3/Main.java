package Algorithms.DynArray;



public class Main {
    

    
    public static void main(String[] args) {
        // Создание массива
        DynArray<Integer> myArray =  new DynArray<Integer>(Integer.class);
        myArray.append(1);
        myArray.append(2);
        myArray.append(3);
        myArray.append(4);
            
        for(int i = 0; i != myArray.count(); i++){
            System.out.println(myArray.getItem(i));
        }
        
    }
}
