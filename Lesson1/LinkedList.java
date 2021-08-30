package ru.lesson;

import java.util.*;



public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node a_item) {
        if (this.head == null)
            this.head = a_item;
        else
            this.tail.next = a_item;
        this.tail = a_item;
    }

    public Node find(int a_value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == a_value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int a_value) {
        // здесь будет ваш код поиска всех узлов
        ArrayList<Node> findRes = new ArrayList<Node>();
        Node node = this.head;
        int i = 0;
        while (node != null) {
            if (node.value == a_value){
                findRes.add(i, node);
                ++i;
            }
            node = node.next;
        }
        return findRes;
    }

    public boolean remove(int a_value)
    {
        Node node = this.head;
        if (node.value == a_value){
            this.head = node.next;
            node.next = null;
            return true;
        }

        while (node.next != null) {
            if (node.next.value == a_value){
                Node tmp = node.next;
                node.next = node.next.next;
                tmp.next = null;
                return true; // если узел был удалён
            } else node = node.next;
        }
        return false;
    }

    public void removeAll(int a_value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node node = this.head;
        if (node.value == a_value){
            this.head = node.next;
            node.next = null;
        }

        while (node.next != null) {
            if (node.next.value == a_value){
                Node tmp = node.next;
                node.next = node.next.next;
                tmp.next = null;
            } else node = node.next;
        }
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
        Node node = this.head;
        Node tmp = node;
        while (node != null) {
            node = node.next;
            tmp.next = null;
        }
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }


}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
