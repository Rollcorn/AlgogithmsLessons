package Algorithms.DynArray;



public class Main {

    public static void printArray(DynArray<Integer> m_array){
        for(int i = 0; i != m_array.count(); i++){
            System.out.println(m_array.getItem(i));
        }
        System.out.println("Текущее количество элементов в массиве - " + m_array.count());
    }

    public static void main( String[] args ) {
        // Создание массива
        DynArray<Integer> myArray =  new DynArray<Integer>( Integer.class );
        System.out.println("Текущее количество элементов в массиве - " + myArray.count());

        /**
         * Тест вставки элемента методом append
         */
        myArray.append(1);
        myArray.append(2);
        myArray.append(3);
        myArray.append(4);
        printArray(myArray);

        /**
         * Тест метода вставки - insert
         */
        myArray.insert(7, 0);
        printArray(myArray);
    }
}
