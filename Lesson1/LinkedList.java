package Lesson1;

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
                if(null == node.next) this.tail = node;
                return true; // если узел был удалён
            } else node = node.next;
        }
        return false;
    }

    public void removeAll(int a_value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node node = this.head;
        while (node.value == a_value){
            this.head = node.next;
            node.next = null;
            node = this.head;
        }
        while (node.next != null) {
            if (node.next.value == a_value){
                Node tmp = node.next;
                node.next = node.next.next;
                tmp.next = null;
                if(node.next.next == null) this.tail = node;
            } 
            node = node.next;
        }
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
        Node node = this.head;
        Node tmp;
        while (node != null) 
        {
            tmp = node;
            node = node.next;
            tmp.next = null;
        }
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) 
        {
            node = node.next;
            count++;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node a_nodeAfter, Node a_nodeToInsert)
    {    
        Node node = this.head;
        if (node == a_nodeToInsert)
        {
            this.head = node.next;
            node.next = null;
            node = this.head;
        }else {
            while (node != null){
                if(a_nodeToInsert == node.next)
                {
                    Node tmp = node.next;
                    node.next = node.next.next;
                    tmp.next = null;
                    if(null == node.next) this.tail = node;
                }
                node = node.next; 
            }         
        }
        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
        if(a_nodeAfter == null)
        {
            Node tmp = this.head;
            this.head = a_nodeToInsert;
            a_nodeToInsert.next = tmp;
        } else if( a_nodeAfter.next != a_nodeToInsert )
        {
            Node tmp = a_nodeAfter.next;
            a_nodeAfter.next = a_nodeToInsert;
            a_nodeToInsert.next = tmp;
            if(null == a_nodeToInsert.next) this.tail = a_nodeToInsert;
        }
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
