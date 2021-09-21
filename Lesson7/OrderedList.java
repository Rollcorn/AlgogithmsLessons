package AlgorithmsLessons.Lesson7;
import java.util.*;


 class Node<T>
  {
    public T value;
    public Node<T> next, prev;
    

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
  }

 public class OrderedList<T> 
  {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        int cmp;
        if( v1 instanceof Integer ){
            cmp = ( (Integer) v1 ).compareTo( (Integer) v2 );  
            return cmp;
        } else if( v1 instanceof String){
            cmp = ( (String)v1 ).compareTo( (String) v2 );  
            return cmp;
        }
        return 0;
    }

    public void add(T a_value)
    {
        int cmp;
        int asc =  _ascending ? -1 : 1;
        Node<T> nodeToInsert = new Node<T>(a_value);
        Node<T> node = this.head;

        if( count() == 0 ){
            this.head =  nodeToInsert;
            this.tail = nodeToInsert;
        }else {
            do{
                cmp = compare(node.value, a_value) * asc;
                if(cmp > 0) node = node.next;
            }while (cmp > 0 && node != null);

            if(node == null){
                tail.next = nodeToInsert;
                nodeToInsert.next = null;
                nodeToInsert.prev = this.tail;
                this.tail = nodeToInsert;
            }else {
                Node<T> tmp = node.prev;
                node.prev = nodeToInsert;
                nodeToInsert.next = node;
                nodeToInsert.prev = tmp;
                if( tmp == null ){ 
                    this.head = nodeToInsert; 
                } else {
                    tmp.next = nodeToInsert;
                }
            }
        }
    }

    public Node<T> find(T a_value)
    {
        Node<T> node = this.head;

        while( node != null ){
            int cmp = compare(node.value, a_value);
            System.out.println("Find iter " + node.value);
            if( ( _ascending && ( cmp > 0) ) || 
                ( !_ascending && ( cmp < 0) ) ){ break; }

            if ( node.value == a_value ){
              return node;
            } else {
              node = node.next;
            }
        }
      
        return null;
        }

    public void delete(T a_value)
    {

        Node<T> node = this.head;
      
        while (node != null) {
            
            if(this.count() == 0){ break; }
            
            if ( node.value != a_value) {
                node = node.next;
                continue;
            }

            if(node == this.head){
                if ( this.head == this.tail ) {
                    this.head = null;
                    this.tail = null;
                } else {
                    this.head = node.next;
                    this.head.prev = null;
                }
                node.next = null;
                node.prev = null;
            } else {
                if(node == this.tail){     
                    node.prev.next = null;
                    this.tail = node.prev;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                node.prev = null;
                node.next = null;
                node = node.next;
            }
            break;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        Node<T> node = this.head;
        while(node != null){
            Node<T> tmp = node.next;
            node.prev = null;
            node.next = null;
            node = tmp;
        }
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int count = 0;
        Node<T> node = this.head;
        while( node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> arr = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            arr.add(node);
            node = node.next;
        }
        return arr;
    }
  }