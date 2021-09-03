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

    public static void main(String[] args) {
        LinkedList2 mylist = new LinkedList2();

        mylist.addInTail( new Node(1) );
        mylist.addInTail( new Node(2) );
        mylist.addInTail( new Node(3) );
        mylist.addInTail( new Node(4) );
        mylist.addInTail( new Node(5) );
        mylist.addInTail( new Node(6) );
        mylist.addInTail( new Node(3) );
        mylist.addInTail( new Node(8) );
        mylist.addInTail( new Node(9) );
        mylist.addInTail( new Node(10) );

        t_printList(mylist);
        System.out.println(mylist.find(3));
        
// Тест посика всех элементов по ключу
        System.out.println();
        // t_findAll(mylist, 3);

// Тест удаления эелемента по ключу
        //Удаление первого элемента в списке
        t_remove(mylist, 1);
        System.out.println("Элемент перед head: " + mylist.head.prev);
        System.out.println("Элемент после  tail: " + mylist.tail.next);

        //Удаление элеменета из конца списка
        t_remove(mylist, 10);
        System.out.println("Элемент перед head: " + mylist.head.prev);
        System.out.println("Элемент после  tail: " + mylist.tail.next);

        //Удаление элемента из пустого списка
        System.out.println("Удаление элемента из пустого списка");
        LinkedList2  emptylist = new LinkedList2();
        t_remove(emptylist, 3);

        //Удаление последнего элемента списка
        System.out.println("Удаление элемента из списка c одним элементом");
        LinkedList2  oneItemlist = new LinkedList2();
        oneItemlist.addInTail( new Node( 9));
        t_remove(oneItemlist, 9);

// Тест удаления всех элементов по ключу
        // TODO


// Тест вставка элемента после элемента
        // TODO


        System.out.println();
    }


}
