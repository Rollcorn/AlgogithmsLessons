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

// Добавить в конец списка
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

// Поиск элемента по ключу
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

// Поиск всех элементов в списке
public ArrayList<Node> findAll(int a_value)
{
  ArrayList<Node> nodesResult = new ArrayList<Node>();
  Node node = this.head ;
  for( int i = 0; node != null; node = node.next ){
    if ( node.value == a_value ){
      nodesResult.add(i, node);
      i++;
    }
  }
  return nodesResult;
}

// Удалить элемент из списка по ключу
public boolean remove(int a_value)
{
  if(this.count() == 0){
    return false;
  }
  
  Node node = this.head;
  // Проверка головы списка
  if(node.value == a_value){
    this.head = node.next;
    node.next = null;
    node = this.head;
    node.prev = null;
    return true;
  }
  
  // Проверка списка
  while (node != null) {
    if(node.value == a_value){
      node.prev.next = node.next;
      node.next.prev = node.prev;
      return true;
    }
    node = node.next;
  }

  return false; // если узел небыл удалён
}

// Удаление всех элементов из списка по ключу
public void removeAll(int a_value)
{
  if(this.count() == 0){
    
    Node node = this.head;
    // Проверка головы списка
    while(node.value == a_value && node != null){
      this.head = node.next;
      node.next = null;
      node = this.head;
      node.prev = null;
    }
    
    // Проверка списка
    while (node != null) {
      if(node.value == a_value){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if(node.next == null){
          this.tail = node.prev;
        }
        node.next = null;
        node.prev = null;
      }
      node = node.next;
    }
  }
}

// Очистка списка
public void clear()
{
  Node node = this.head;
  while(node != null){
    Node tmp = node.next;
    node.prev = null;
    node.next = null;
    node = tmp;
  }
  this.head = null;
  this.tail = null;
}

// Количество элементов в списке
public int count()
{
  int count = 0;
  Node node = this.head;
  while (node != null){
    count++;
    node = node.next;
  }
  return count; 
}

public void insertAfter(Node a_nodeAfter, Node a_nodeToInsert)
{
  Node node = this.head;
  // Проверка головы списка
  if(node == a_nodeToInsert){
    this.head = node.next;
    node.next = null;
    node = this.head;
    node.prev = null;
  } else while (node != null) {
    if(node == a_nodeToInsert){
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    node = node.next;
  }

  node = this.head;
  if(a_nodeAfter == null) {

    this.head.prev = a_nodeToInsert;
    a_nodeToInsert.next = this.head;
    a_nodeToInsert.prev = null;
    if(this.count() == 1) this.tail = a_nodeToInsert;

  } else while( node != null){
      if ( node == a_nodeAfter ){
        Node tmp = node.next;
        node.next = a_nodeToInsert;
        a_nodeToInsert.next = tmp;
        a_nodeToInsert.prev = node;
        if( tmp == null ){ this.tail = a_nodeToInsert; }
      }
  }
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