package LinkedList2;

import java.util.*;

public class LinkedList2
{
public Node head;
public Node tail;

public LinkedList2()
{
  head = null;
  tail = null;
}

public void addInTail(Node a_item)
{
  if (head == null) {
    this.head   = a_item;
    a_item.next = null;
    a_item.prev = null;
  } else {
    this.tail.next = a_item;
    a_item.prev    = tail;
  }
  this.tail = a_item;
}

public Node find(int a_value)
{
  Node node = this.head;

  while( node != null ){
    if ( node.value == a_value ){
      return node;
    } else {
      node = node.next;
    }
  }

  return null;
}

public ArrayList<Node> findAll(int a_value)
{
  ArrayList<Node> nodesResult = new ArrayList<Node>();
  Node node = this.head;
  for( int i = 0; node != null; node = node.next ){
    if ( node.value == a_value ){
      nodesResult.add(i, node);
      i++;
    }
  }
  return nodesResult;
}

public boolean remove(int _value)
{
  if(this.count() == 0){
    return false;
  }
  
  Node node = this.head;
  while (node != null) {



  }


  return false; // если узел был удалён
}
public void removeAll(int _value)
{
  // здесь будет ваш код удаления всех узлов по заданному значению
}
public void clear()
{
  // здесь будет ваш код очистки всего списка
}

public int count()
{
  int count = 0;
  Node node = this.head;
  while (node != null){
    count++;
  }
  return count; 
}

public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
{
  // здесь будет ваш код вставки узла после заданного узла
  // если _nodeAfter = null
  // добавьте новый элемент первым в списке 
}
}

class Node
{
     public int value;
     public Node next;
     public Node prev;

     public Node(int _value) 
     { 
       value = _value; 
       next = null;
       prev = null;
     }
}