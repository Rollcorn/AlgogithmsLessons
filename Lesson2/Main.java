package LinkedList2;

import java.util.ArrayList;

public class Main {

    public static void t_printList( LinkedList2 a_mylist ){
        Node node = a_mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        t_printHead(a_mylist);
        t_printTail(a_mylist);
        System.out.println();
    }

    public static void t_printHead( LinkedList2 a_mylist ){
        if( a_mylist.head == null)         
            System.out.println("This head now is " + a_mylist.head);
        else 
            System.out.println("This head now is " + a_mylist.head.value);
    }

    public static void t_printTail( LinkedList2 a_mylist ){
        if( a_mylist.tail == null)         
            System.out.println("This tail now is " + a_mylist.tail);
        else 
            System.out.println("This tail now is " + a_mylist.tail.value);
    }

    public static void t_printPreNext( LinkedList2 a_mylist ){
        System.out.println("Элемент перед head: " + a_mylist.head.prev);
        System.out.println("Элемент после  tail: " + a_mylist.tail.next);
    }

/***********************************************************/
    public static void t_findAll( LinkedList2 a_mylist, int a_value ){
        ArrayList<Node> resultList = new ArrayList<Node>();
        resultList = a_mylist.findAll(a_value);
        
        System.out.println(resultList);

        for (Node x : resultList){
            System.out.println( x + " : " + x.value + " : " + x.prev + " : " + x.next);
        }
        t_printHead(a_mylist);
        t_printTail(a_mylist);
    }
  
    public static void t_remove( LinkedList2 a_mylist, int a_value ){
        System.out.println();
        System.out.println("Удаление элемента по ключу = " + a_value);
        a_mylist.remove(a_value);
        System.out.println("Оставшиеся элементы: ");
        t_printList(a_mylist);

        System.out.println();
    }

    public static void t_removeAll( LinkedList2 a_mylist, int a_value ){
        System.out.println();
        System.out.println("Удаление элемента по ключу = " + a_value);
        t_printList(a_mylist);
        a_mylist.removeAll(a_value);
        System.out.println("Оставшиеся элементы: ");
        t_printList(a_mylist);

        System.out.println();
    }

    public static void t_insertAfter( LinkedList2 a_mylist, Node a_after, Node a_item){
        System.out.println("В список: ");
        t_printList(a_mylist);

        System.out.println("Вставка элемента после звена = " + a_after);
        a_mylist.insertAfter(a_after, a_item);
        System.out.println("Оставшиеся элементы: ");
        t_printList(a_mylist);

        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList2 mylist = new LinkedList2();
        // Инициализация списка
        {
            mylist.addInTail(new Node(1));
            mylist.addInTail(new Node(2));
            mylist.addInTail(new Node(3));
            mylist.addInTail(new Node(5));
            mylist.addInTail(new Node(5));
            mylist.addInTail(new Node(6));
            mylist.addInTail(new Node(5));
            mylist.addInTail(new Node(5));
            mylist.addInTail(new Node(9));
            mylist.addInTail(new Node(10));
        }

        t_printList(mylist);
        System.out.println(mylist.find(3));
        
// Тест посика всех элементов по ключу
        System.out.println();
        // t_findAll(mylist, 3);

// Тест удаления эелемента по ключу
 /*     
        //Удаление первого элемента в списке
        t_remove(mylist, 1);
        t_printPreNext(mylist);


        //Удаление элеменета из конца списка
        t_remove(mylist, 10);
        t_printPreNext(mylist);


        //Удаление элемента из пустого списка
        System.out.println("Удаление элемента из пустого списка");
        LinkedList2  emptylist = new LinkedList2();
        t_remove(emptylist, 3);
        t_printPreNext(mylist);


        //Удаление последнего элемента списка
        System.out.println("Удаление элемента из списка c одним элементом");
        LinkedList2  oneItemlist = new LinkedList2();
        oneItemlist.addInTail( new Node( 9));
        t_remove(oneItemlist, 9);
*/
// Тест удаления всех элементов по ключу
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

// Тест вставка элемента после элемента
        LinkedList2 list4 = new LinkedList2();

        // Инициализация списка list4
        Node elem1 = new Node(1);
        Node elem3 = new Node(3);
        Node elem2 = new Node(2);
        Node elem4 = new Node(4);

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
    }


}
