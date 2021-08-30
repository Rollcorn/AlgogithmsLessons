package ru.lesson;

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
        // Поиск элемента по ключу
        System.out.println("Поиск элемента по ключу");
        System.out.println(mylist.find(3));
        System.out.println(mylist.find(1));
        System.out.println(mylist.find(7));

        // Поиск всех элементов по ключу
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

        // Удаление узла по значению ключа
        System.out.println("Удаление узла по значению ключа");
        mylist.remove(1);
        mylist.remove(4);
        mylist.removeAll(3);

        System.out.println("Оставшиеся элементы");
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }

        mylist.addInTail(first);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }

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
//        mylist.addInTail(second);
//        mylist.addInTail(third);
//        mylist.addInTail(fourth);
//        mylist.addInTail(fifth);
//        mylist.addInTail(sixth);
//        mylist.addInTail(seventh);
        node = mylist.head;
        for (int i = 0; node != null; i++) {
            System.out.println("Element " + i + " = " + node.value);
            node = node.next;
        }
*/


    }
}
