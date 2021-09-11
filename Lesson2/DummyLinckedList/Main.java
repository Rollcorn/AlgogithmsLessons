package AlgorithmsLessons.Lesson2.DummyLinckedList;

public class Main {

    public static void t_printList( DLinkedList<Integer> a_mylist ){
        DNode<Integer> node = a_mylist.head();
        for (int i = 0; i != a_mylist.count(); i++) {
            System.out.println("[" + i + "] = " + node.value);
            node = node.next;
        }
        t_printHead(a_mylist);
        t_printTail(a_mylist);
        System.out.println();
    }

    public static void t_printHead( DLinkedList<Integer> a_mylist ){
        System.out.println("This head now is " + a_mylist.head().value);
    }

    public static void t_printTail( DLinkedList<Integer> a_mylist ){
        System.out.println("This tail now is " + a_mylist.tail().value);
    }

/**********************************************************************************/
     // Распечатать текущий список
    public static void t_remove( DLinkedList<Integer> a_mylist, int a_value ){
        System.out.println();
        System.out.println("Удаление элемента по ключу = " + a_value);
        a_mylist.remove(a_value);
        System.out.println("Оставшиеся элементы: ");
        t_printList(a_mylist);

        System.out.println();
    }

    // Тест удаления всех элементов по ключу
    public static void t_removeAll( DLinkedList<Integer> a_mylist, Integer a_value ){
        System.out.println();

        System.out.println("Удаление элемента по ключу = " + a_value);
        t_printList(a_mylist);
        a_mylist.removeAll(a_value);
        System.out.println("Оставшиеся элементы: ");
        t_printList(a_mylist);

        System.out.println();
    }

    // Тест вставка элемента a_item после a_after
    public static void t_insertAfter( DLinkedList<Integer> a_mylist, 
                                      DNode<Integer> a_after, 
                                      DNode<Integer> a_item){
        System.out.println("В список: ");
        t_printList(a_mylist);

        System.out.println("Вставка элемента" + a_item.value + " после звена = " + ((a_after == null)? a_after: a_after.value));
        a_mylist.insertAfter(a_after, a_item);
        System.out.println("Оставшиеся элементы: ");
        t_printList(a_mylist);

        System.out.println();
    }

    public static void main(String[] args) {
        DLinkedList<Integer> mylist = new DLinkedList<Integer>();
        // Инициализация списка
        {
            mylist.addInTail(new DNode<Integer>(1));
            mylist.addInTail(new DNode<Integer>(2));
            mylist.addInTail(new DNode<Integer>(3));
            mylist.addInTail(new DNode<Integer>(5));
            mylist.addInTail(new DNode<Integer>(5));
            mylist.addInTail(new DNode<Integer>(6));
            mylist.addInTail(new DNode<Integer>(5));
            mylist.addInTail(new DNode<Integer>(5));
            mylist.addInTail(new DNode<Integer>(9));
            mylist.addInTail(new DNode<Integer>(10));
        }

        t_printList(mylist);
        
/***************************************
 * Тест удаления эелемента по ключу
 ***************************************/
/*   
        //Удаление первого элемента в списке
        t_remove(mylist, 1);
 
        //Удаление элеменета из конца списка
        t_remove(mylist, 10);

        //Удаление элемента из пустого списка
        System.out.println("Удаление элемента из пустого списка");
        DLinkedList<Integer>  emptylist = new DLinkedList<Integer>();
        t_printList(emptylist);
        t_remove(emptylist, 3);


        //Удаление последнего элемента списка
        System.out.println("Удаление элемента из списка c одним элементом");
        DLinkedList<Integer>  oneItemlist = new DLinkedList<Integer>();
        oneItemlist.addInTail( new DNode<Integer>( 9));
        t_printList(oneItemlist);
        t_remove(oneItemlist, 9);
*/

/******************************************
 *  Тест удаления всех элементов по ключу
 ******************************************/
/*
        // Удаление элементов из центра (середина)
        t_removeAll(mylist, 5);

        // Удаление нескольких элементов из начала списка [начало - середина)
        LinkedList2 list1 = new LinkedList2();
        // Инициализация списка list1
        {
            list1.addInTail(new Node(2));
            list1.addInTail(new Node(2));
            list1.addInTail(new Node(2));
            list1.addInTail(new Node(2));
            list1.addInTail(new Node(2));
            list1.addInTail(new Node(6));
            list1.addInTail(new Node(5));
            list1.addInTail(new Node(5));
            list1.addInTail(new Node(9));
            list1.addInTail(new Node(10));
        }
        t_removeAll(list1, 2);

        // Удаление элемента в конце списка (середина - конец]
        LinkedList2 list2 = new LinkedList2();
        // Инициализация списка list2
        {
            list2.addInTail(new Node(1));
            list2.addInTail(new Node(2));
            list2.addInTail(new Node(3));
            list2.addInTail(new Node(4));
            list2.addInTail(new Node(5));
            list2.addInTail(new Node(6));
            list2.addInTail(new Node(6));
            list2.addInTail(new Node(6));
            list2.addInTail(new Node(6));
            list2.addInTail(new Node(6));
        }
        t_removeAll(list2, 6);


        // Удаление элемента из списка с одинаковыми элементами [начало - конец]
        LinkedList2 list3 = new LinkedList2();
        // Инициализация списка list3
        {
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
            list3.addInTail(new Node(2));
        }
        t_removeAll(list3, 2);

        // Удаление последнего элемента из списка
        LinkedList2 list4 = new LinkedList2();
        // Инициализация списка list3
        {
            list4.addInTail(new Node(7));

        }
        t_removeAll(list4, 7);
*/

/*****************************************
 *  Тест вставка элемента после элемента
 ******************************************/
/*
        DLinkedList<Integer> list4 = new DLinkedList<Integer>();

        // Инициализация списка list4
        DNode<Integer> elem1 = new DNode<Integer>(1);
        DNode<Integer> elem3 = new DNode<Integer>(3);
        DNode<Integer> elem2 = new DNode<Integer>(2);
        DNode<Integer> elem4 = new DNode<Integer>(4);

        // Вставка элемента в пустой список
        t_insertAfter(list4, null, elem1);

        // Вставка элемента в список с одним элементом
        t_insertAfter(list4, elem1, elem2);

        // Вставка элемента после null
        t_insertAfter(list4, null, elem3);

        // Вставка элемента в центр списка
        t_insertAfter(list4, elem1, elem4);

//        list4.addInTail(elem1);
//        list4.addInTail(elem3);
//        list4.addInTail(elem2);

        // Вставка в центр
//        t_insertAfter(list4, elem2, elem4);

        System.out.println();
*/

/*****************************************
 *  Тест удаления всех элементов по ключу
 ******************************************/
        DLinkedList<Integer> list5 = new DLinkedList<Integer>();

        // Инициализация списка list4
        DNode<Integer> elem1 = new DNode<Integer>(4);
        DNode<Integer> elem2 = new DNode<Integer>(4);
        DNode<Integer> elem3 = new DNode<Integer>(1);
        DNode<Integer> elem4 = new DNode<Integer>(1);
        DNode<Integer> elem5 = new DNode<Integer>(2);
        DNode<Integer> elem6 = new DNode<Integer>(1);
        DNode<Integer> elem7 = new DNode<Integer>(5);
        DNode<Integer> elem8 = new DNode<Integer>(5);

        list5.addInTail(elem1);
        list5.addInTail(elem2);
        list5.addInTail(elem3);
        list5.addInTail(elem4);
        list5.addInTail(elem5);
        list5.addInTail(elem6);
        list5.addInTail(elem7);
        list5.addInTail(elem8);

        t_removeAll(list5, 4);
        t_removeAll(list5, 5);
        t_removeAll(list5, 2);
        t_removeAll(list5, 1);



    }
}
