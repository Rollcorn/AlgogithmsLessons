// package AlgorithmsLessons.Lesson3;
// package Algorithms.DynArray;




public class Main {

    public static void t_insert( DynArray<Integer> a_myArray, int a_value, int a_index){
        System.out.println("Вставка элемента = " + a_value + " в индекс = " + a_index);
        a_myArray.insert(a_value, a_index);
        t_printArray(a_myArray);
    }

    public static void t_remove( DynArray<Integer> a_myArray, int a_index){
        System.out.println("Удаление элемента из индекса = " + a_index);
        a_myArray.remove(a_index);
        t_printArray(a_myArray);
    }


    public static void t_printArray(DynArray<Integer> m_array){
        for(int i = 0; i != m_array.count(); i++){
            System.out.println("[" + i + "] = " + m_array.getItem(i));
        }
        System.out.println("Количество элементов в массиве - " + m_array.count());
        System.out.println("Размер буфера - " + m_array.capacity());
    }

    public static void main( String[] args ) {
        // Создание массива
        DynArray<Integer> myArray =  new DynArray<Integer>( Integer.class );
        t_printArray(myArray);

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

        t_printArray(myArray);

        /************************************
         * [2] Тест метода вставки - insert
         */
        t_insert(myArray, 10, 2);
        t_insert(myArray, 10, 0);

        /**
         * [3] Тест удаления элемента
         */
        t_remove(myArray, 3);
        t_insert(myArray, 10, myArray.count());
        // t_insert(myArray, 10, -1);
        t_insert(myArray, 10, myArray.count() + 1);
        // t_remove(myArray, -3);
        // t_remove( myArray, myArray.count() );



 /*       
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

        t_printArray(myArray);

        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
        t_remove(myArray, 5);
*/
    }
}
