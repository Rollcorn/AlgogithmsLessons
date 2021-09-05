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
  if(this.count() == 0){ return false; }

  Node node = this.head;

  while (node != null) {
    // Проверка головы списка
    if(node == this.head && node.value == a_value){
      if ( this.head == this.tail ) {
        this.head = null;
        this.tail = null;
      } else {
        this.head = node.next;
        this.head.prev = null;
      }
      node.next = null;
      node.prev = null;

      return true;

    } else {
      if (node.value == a_value) { 
        if(node == this.tail){     // Проверка хвоста списка
          node.prev.next = null;
          this.tail = node.prev;
        }else{
          node.prev.next = node.next; // node.prev.next - не существует для head'a
          node.next.prev = node.prev; // node.next.prev - не существует для tail'a
        }
        node.prev = null;
        node.next = null;
        return true;
      }
      node = node.next;
    }
  }
  return false; // если узел небыл удалён
}

// Удаление всех элементов из списка по ключу
public void removeAll(int a_value)
{

  Node node = this.head;
  while (node != null) {
    //Если список пустой, то ничего не надо делать
    if ( this.count() == 0 ){ break; }

    if ( node.value == a_value ){
      // Проверка головы списка
      if ( node == this.head ){

        if ( this.head == this.tail ) {
          this.head = null;
          this.tail = null;
        } else {
          this.head = node.next;
          this.head.prev = null;
        }
        node.next = null;
        node.prev = null;
        node = this.head;

      } else {
        if (node == this.tail) {     // Проверка хвоста списка
          node.prev.next = null;
          this.tail = node.prev;
        } else {
          node.prev.next = node.next; // node.prev.next - не существует для head'a
          node.next.prev = node.prev; // node.next.prev - не существует для tail'a
        }
        Node tmp = node.next;
        node.prev = null;
        node.next = null;
        node = tmp;
      }
    } else {
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

    // Проверка присутствия втавляемого элемента в списке
    Node node = this.head;

    while (node != null) {
      //Если список пустой, то ничего не надо делать
      if ( this.count() == 0 ){ break; }

      if ( node == a_nodeToInsert ){
        // Проверка головы списка
        if ( node == this.head ){

          if ( this.head == this.tail ) {
            this.head = null;
            this.tail = null;
          } else {
            this.head = node.next;
            this.head.prev = null;
          }
          node.next = null;
          node.prev = null;
          node = this.head;

        } else {
          if (node == this.tail) {     // Проверка хвоста списка
            node.prev.next = null;
            this.tail = node.prev;
          } else {
            node.prev.next = node.next; // node.prev.next - не существует для head'a
            node.next.prev = node.prev; // node.next.prev - не существует для tail'a
          }
          Node tmp = node.next;
          node.prev = null;
          node.next = null;
          node = tmp;
        }
      } else {
        node = node.next;
      }
    }

  // Вставка элемента
  node = this.head;
  if( a_nodeAfter == null ) {
    if( this.head == null ){
      a_nodeToInsert.next = null;
      a_nodeToInsert.prev = null;
      this.tail = a_nodeToInsert;
    } else {
      this.head.prev = a_nodeToInsert;
      a_nodeToInsert.next = this.head;
      a_nodeToInsert.prev = null;
    }
    this.head = a_nodeToInsert;

  } else while( node != null){
      if ( node == a_nodeAfter ){
        Node tmp = node.next;
        node.next = a_nodeToInsert;
        a_nodeToInsert.next = tmp;
        a_nodeToInsert.prev = node;
        if( tmp == null ){ this.tail = a_nodeToInsert; }
      }
      node = node.next;
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