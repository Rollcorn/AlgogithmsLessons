package LinkedList2;

import java.util.ArrayList;

public class Main {

    public static void t_printList( LinkedList2 mylist ){
        Node node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        t_printHead(mylist);
        t_printTail(mylist);
        System.out.println();

    }

    public static void t_printHead( LinkedList2 mylist ){
        if( mylist.head == null)         
            System.out.println("This head now is null");
        else 
            System.out.println("This head now is " + mylist.head.value);
    }

    public static void t_printTail( LinkedList2 mylist ){
        if( mylist.tail == null)         
            System.out.println("This tail now is null");
        else 
            System.out.println("This tail now is " + mylist.tail.value);
    }

/***********************************************************/

  
    public static void main(String[] args) {
        

    }


}
