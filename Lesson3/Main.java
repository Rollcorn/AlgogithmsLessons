package Algorithms.DynArray;



public class Main {

    public static void printArray(DynArray<Integer> m_array){
        for(int i = 0; i != m_array.count(); i++){
            System.out.println(m_array.getItem(i));
        }
        System.out.println("Количество элементов в массиве - " + m_array.count());
        System.out.println("Размер буфера - " + m_array.capacity());
    }

    public static void main( String[] args ) {
        // Создание массива
        DynArray<Integer> myArray =  new DynArray<Integer>( Integer.class );
        System.out.println("Текущее количество элементов в массиве - " + myArray.count());

        /**
         * [1] Тест вставки элемента методом append
         */
        myArray.append(1);
        myArray.append(2);
        myArray.append(3);
        myArray.append(4);
        myArray.append(5);
        myArray.append(6);
        myArray.append(7);
        myArray.append(8);

        printArray(myArray);

        /**
         * [2] Тест метода вставки - insert
         */
        System.out.println("Вставка элемента = 7 в индекс = 0");
        myArray.insert(7, 0);
        printArray(myArray);

        /**
         * [3] Тест удаления элемента
         */
        System.out.println("Удаление элемента из индекса = 2");
        myArray.remove(2);
        printArray(myArray);

        myArray.append(9);
        myArray.append(10);
        myArray.append(11);
        myArray.append(12);
        myArray.append(13);
        myArray.append(14);
        myArray.append(15);
        myArray.append(16);
        myArray.append(17);
        myArray.append(18);

        printArray(myArray);

        myArray.remove(5);
        myArray.remove(5);
        myArray.remove(5);
        myArray.remove(5);
        myArray.remove(5);

        printArray(myArray);

        myArray.remove(5);
        myArray.remove(5);
        myArray.remove(5);

        printArray(myArray);



    }
}
