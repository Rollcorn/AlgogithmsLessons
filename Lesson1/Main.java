package Lesson1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Создание списка
        LinkedList mylist = new LinkedList();

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
        mylist.addInTail(second);
        mylist.addInTail(third);
        mylist.addInTail(fourth);
        mylist.addInTail(fifth);
        mylist.addInTail(sixth);
        mylist.addInTail(seventh);

        //Выведение всех элементов списка
        System.out.println("Выведение всех элементов списка");
        Node node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
/*
        //[1] Поиск элемента по ключу
        System.out.println("Поиск элемента по ключу");
        System.out.println(mylist.find(3));
        System.out.println(mylist.find(1));
        System.out.println(mylist.find(7));

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
*/
/*
        //[3] Удаление узла по значению ключа
        System.out.println("Удаление узла по значению ключа");
//        mylist.remove(1);
//        mylist.remove(4);
//        mylist.remove(3);

        System.out.println("Оставшиеся элементы");
       node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println();

        mylist.addInTail(first);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println();

        mylist.addInTail(third);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println();

        mylist.addInTail(fourth);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        
        mylist.remove(6);
        mylist.remove(1);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();

        mylist.remove(2);
        mylist.remove(3);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();

        mylist.remove(3);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();
*/
/*
        //[4]Удаление всех элементов с заданным ключем
        System.out.println("Удаление всех элементов с заданным ключем");

        mylist.removeAll(6);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();

        mylist.removeAll(1);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();

        mylist.removeAll(3);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();

        mylist.addInTail(third);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();
*/

/*
        System.out.println("Очистка списка");
        mylist.clear();
        System.out.println(mylist);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        //Инициализация звеньев 2
        mylist.addInTail(first);
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());
        System.out.println();
        mylist.addInTail(second);
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());
        System.out.println();
//        mylist.addInTail(third);
//        mylist.addInTail(fourth);
        mylist.addInTail(fifth);
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());
        System.out.println();
//        mylist.addInTail(sixth);
        mylist.addInTail(seventh);
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());
        System.out.println();
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println();
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println();
*/
        
        //[5] Вставка после элемента
        System.out.println();
        mylist.insertAfter(second, seventh);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());
/*
        System.out.println();
        mylist.insertAfter(second, seventh);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());

        System.out.println();
        mylist.insertAfter(second, fifth);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());

        System.out.println();
        mylist.insertAfter(second, first);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());

        System.out.println();
        mylist.insertAfter(null, fifth);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + mylist.head.value);
        System.out.println("This tail now is " + mylist.tail.value);
        System.out.println(mylist.count());
        */

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

        // Создание ПЕРВОГО списка
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
        node = summ.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
        System.out.println("This head now is " + summ.head.value);
        System.out.println("This tail now is " + summ.tail.value);
        summ.count();

        System.out.println();
        // ArrayList<Node> result = summ.findAll(4);
        summ.removeAll(2);
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


}
