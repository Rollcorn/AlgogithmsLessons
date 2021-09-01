// package Lesson1;

import java.util.ArrayList;




public class Main {

    public static void t_printList( LinkedList mylist ){
        Node node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        t_printHead(mylist);
        t_printTail(mylist);
        System.out.println();

    }

    public static void t_printHead( LinkedList mylist ){
        if( mylist.head == null)         
            System.out.println("This head now is null");
        else 
            System.out.println("This head now is " + mylist.head.value);
    }

    public static void t_printTail( LinkedList mylist ){
        if( mylist.tail == null)         
            System.out.println("This tail now is null");
        else 
            System.out.println("This tail now is " + mylist.tail.value);
    }

/***********************************************************/

    public static void t_find( LinkedList mylist){
        //[1] Поиск элемента по ключу
        System.out.println("Поиск элемента по ключу");
        System.out.println(mylist.find(3));
        System.out.println(mylist.find(1));
        System.out.println(mylist.find(7));
    }

    public static void t_findAll( LinkedList mylist){
        //[2] Поиск всех элементов по ключу
        System.out.println("Поиск всех элементов по ключу");
        System.out.println(mylist.findAll(1));
        System.out.println(mylist.findAll(3));
        System.out.println(mylist.findAll(7));

        ArrayList<Node> result1 = mylist.findAll(7);
        System.out.println("Результат поиска цифры 7");
        System.out.println(result1);
        for (Node x : result1)
            System.out.println(x.value);

        ArrayList<Node> result2 = mylist.findAll(3);
        System.out.println("Результат поиска цифры 3");
        System.out.println(result2);
        for (Node x : result2)
            System.out.println(x.value);
    }

    public static void t_remove( LinkedList mylist){
        // Создание звеньев
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(3);
        Node seventh = new Node(6);

        //Инициализация звеньев
        mylist.addInTail(first);
        // mylist.addInTail(second);
        // mylist.addInTail(third);
        // mylist.addInTail(fourth);
        // mylist.addInTail(fifth);
        // mylist.addInTail(sixth);
        // mylist.addInTail(seventh);

        //[3] Удаление узла по значению ключа
        t_printList(mylist);
        System.out.println("Удаление узла по значению ключа = 1");
        mylist.remove(1);
        System.out.println("Оставшиеся элементы");
        t_printList(mylist);

        // mylist.addInTail(first);
        // t_printList(mylist);
        // System.out.println("Удаление узла по значению ключа = 3");
        // mylist.remove(3);

        // mylist.addInTail(third);
        // t_printList(mylist);

        // mylist.remove(4);
        // System.out.println("Удаление узла по значению ключа = 4");
        // mylist.addInTail(fourth);
        // t_printList(mylist);
     
        // mylist.remove(6);
        // System.out.println("Удаление узла по значению ключа = 6");
        // mylist.remove(1);
        // System.out.println("Удаление узла по значению ключа = 1");
        // t_printList(mylist);

        // mylist.remove(2);
        // System.out.println("Удаление узла по значению ключа = 2");
        // mylist.remove(3);
        // System.out.println("Удаление узла по значению ключа = 3");
        // t_printList(mylist);

        // mylist.remove(3);
        // t_printList(mylist);

    }

    public static void t_removeAll( LinkedList mylist ){
        // Создание звеньев
        Node first   = new Node(1);
        Node second  = new Node(2);
        // Node third   = new Node(1);
        // Node fourth  = new Node(1);
        // Node fifth   = new Node(1);
        // Node sixth   = new Node(1);
        // Node seventh = new Node(1);

        //Инициализация звеньев
        mylist.addInTail(first);
        // mylist.addInTail(second);
        // mylist.addInTail(third);
        // mylist.addInTail(fourth);
        // mylist.addInTail(fifth);
        // mylist.addInTail(sixth);
        // mylist.addInTail(seventh);

        //[4]Удаление всех элементов с заданным ключем
        t_printList(mylist);
        System.out.println("Удаление всех элементов с ключем = 6");
        mylist.removeAll(1);
        t_printList(mylist);

        mylist.addInTail(first);
        mylist.addInTail(second);
        t_printList(mylist);



        // System.out.println("Удаление всех элементов с ключем = 1");
        // mylist.removeAll(1);
        // t_printList(mylist);

        // System.out.println("Удаление всех элементов с ключем = 3");
        // mylist.removeAll(3);
        // t_printList(mylist);

        // mylist.addInTail(third);
        // t_printList(mylist);
    }
    

    public static void t_clear(LinkedList mylist){
        // Создание звеньев
        Node first   = new Node(1);
        Node second  = new Node(2);
        Node third   = new Node(3);
        Node fourth  = new Node(4);
        Node fifth   = new Node(5);
        Node sixth   = new Node(3);
        Node seventh = new Node(6);

        //Инициализация звеньев
        mylist.addInTail(first);
        mylist.addInTail(second);
        mylist.addInTail(third);
        mylist.addInTail(fourth);
        mylist.addInTail(fifth);
        mylist.addInTail(sixth);
        mylist.addInTail(seventh);
    
        // [6] Очистка списка
        System.out.println("Очистка списка");
        t_printList(mylist);
        mylist.clear();
        System.out.println(mylist);
        t_printList(mylist);
        System.out.println(mylist.count());
        

        // //Инициализация звеньев 2
        // mylist.addInTail(first);
        // t_printList(mylist);

        // System.out.println(mylist.count());
        // System.out.println();
        // mylist.addInTail(second);
        // t_printList(mylist);

        // System.out.println(mylist.count());

        // mylist.addInTail(third);
        // // mylist.addInTail(fourth);
        // // mylist.addInTail(fifth);
        // t_printList(mylist);

        // System.out.println(mylist.count());
        // System.out.println();
        // // mylist.addInTail(sixth);
        // mylist.addInTail(seventh);
        // t_printList(mylist);
        // System.out.println(mylist.count());


    }
        
    public static void t_insertAfter(LinkedList mylist){
       
        // Создание звеньев
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
       /* 
        //Инициализация звеньев
        mylist.addInTail(first);
        mylist.addInTail(second);
        mylist.addInTail(third);
        mylist.addInTail(fourth);
        mylist.addInTail(fifth);
        mylist.addInTail(sixth);
        mylist.addInTail(seventh);
        */
        //[5] Вставка после элемента
        t_printList(mylist);
        System.out.println(" Вставка после хэда");
        System.out.println("Число эллементов = " + mylist.count());
        mylist.insertAfter(mylist.head, first);
        t_printList(mylist);

        System.out.println("Число эллементов = " + mylist.count());
        System.out.println();
        
        System.out.println(" Вставка после null числа = 2");
        mylist.insertAfter(null, second);
        t_printList(mylist);

        System.out.println(mylist.count());
        System.out.println();

        System.out.println(" Вставка после 2 числа = 5");
        mylist.insertAfter(second, fifth);
        t_printList(mylist);
        System.out.println(mylist.count());
        System.out.println();

        System.out.println(" Вставка после 2 числа = 1");
        mylist.insertAfter(second, first);
        t_printList(mylist);
        System.out.println(mylist.count());
        System.out.println();

        System.out.println(" Вставка после null числа = 5");
        mylist.insertAfter(null, fifth);
        t_printList(mylist);
        System.out.println(mylist.count());
        System.out.println();

        System.out.println(" Вставка после 2 числа = 3");
        mylist.insertAfter(second, third);
        t_printList(mylist);
        System.out.println();

        System.out.println(" Вставка после 3 числа = 4");
        mylist.insertAfter(third, fourth);
        t_printList(mylist);
        System.out.println();

        System.out.println(" Вставка после 5 числа = 6");
        mylist.insertAfter(fifth, sixth);
        t_printList(mylist);
        System.out.println();
        
        System.out.println(" Вставка после 5 числа = 6");
        mylist.insertAfter(first, second);
        t_printList(mylist);
        System.out.println();

    }

    public static void t_summary(LinkedList mylist){
                // Создание ПЕРВОГО списка
                LinkedList list_1 = new LinkedList();

                //Инициализация звеньев
                list_1.addInTail(new Node(1));
                list_1.addInTail(new Node(1));
                list_1.addInTail(new Node(1));
                list_1.addInTail(new Node(1));
                list_1.addInTail(new Node(2));
                list_1.addInTail(new Node(2));
                list_1.addInTail(new Node(2));
        
                // Создание ВТОРОГО списка
                LinkedList list_2 = new LinkedList();       
                
                //Инициализация звеньев
                list_2.addInTail(new Node(1));
                list_2.addInTail(new Node(1));
                list_2.addInTail(new Node(1));
                list_2.addInTail(new Node(2));
                list_2.addInTail(new Node(2));
                list_2.addInTail(new Node(2));
                list_2.addInTail(new Node(2));
        
        
                LinkedList summ = Summary.ListSummary(list_1, list_2); 
                Node node = summ.head;
                for (int i = 0; node != null; i++) {
                    System.out.println("Element " + i + " = " + node.value);
                    node = node.next;
                }
                System.out.println("This head now is " + summ.head.value);
                System.out.println("This tail now is " + summ.tail.value);
                summ.count();
        
                System.out.println();
                // ArrayList<Node> result = summ.findAll(4);
                summ.removeAll(4);
                node = summ.head;
                for (int i = 0; node != null; i++) {
                    System.out.println("Element " + i + " = " + node.value);
                    node = node.next;
                }
                
                // for(Node x : result)
                    // System.out.println(x.value );
                // System.out.println("This head now is " + summ.head.value);
                // System.out.println("This tail now is " + summ.tail.value);
                // summ.count();
    }

    public static void main(String[] args) {

        // Создание списка
        LinkedList mylist = new LinkedList();
/*
        // Создание звеньев
        Node first   = new Node(1);
        Node second  = new Node(2);
        Node third   = new Node(3);
        Node fourth  = new Node(4);
        Node fifth   = new Node(5);
        Node sixth   = new Node(3);
        Node seventh = new Node(6);

        //Инициализация звеньев
        mylist.addInTail(first);
        mylist.addInTail(second);
        mylist.addInTail(third);
        mylist.addInTail(fourth);
        mylist.addInTail(fifth);
        mylist.addInTail(sixth);
        mylist.addInTail(seventh);
*/
        //Выведение всех элементов списка
        System.out.println("Выведение всех элементов списка");
        t_printList(mylist);

        t_removeAll(mylist);
        

    }


}
