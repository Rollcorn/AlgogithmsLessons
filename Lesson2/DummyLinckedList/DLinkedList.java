package AlgorithmsLessons.Lesson2.DummyLinckedList;

public class DLinkedList<T> {

    private DNode<T> m_dhead;
    private DNode<T> m_dtail;

    /***************
     * Конструктор
     */
    public DLinkedList()
    {
        m_dhead = new DNode<T>(null);
        m_dtail = new DNode<T>(null);
        m_dhead.next = m_dtail;
        m_dtail.prev = m_dhead;
    }

    /****************
     * Начало списка
     */
    public DNode<T> head(){
        return m_dhead.next;
    }

    /****************
     * Конец списка
     */
    public DNode<T> tail(){
        return m_dtail.prev;
    }

    /****************************
    * Добавление в конец списка
    */
    public void addInTail(DNode<T> a_item)
    {
        if ( m_dhead.next == m_dtail) {
            a_item.next = m_dtail;
            a_item.prev = m_dhead;
            m_dhead.next = a_item;
        } else {
            m_dtail.prev.next = a_item;
            a_item.prev = m_dtail.prev;
            a_item.next =  m_dtail;
        }
        m_dtail.prev = a_item;
    }



    /*************************************
     * Удалить элемент из списка по ключу
     */
    public boolean remove(T a_value)
    {
      if(m_dhead.next == m_dtail){ return false; }

        DNode<T> node = this.m_dhead.next;
        while (node != m_dtail) {
            if(node.value == a_value){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return true;
            }
          node = node.next;
        }
      return false; // если узел небыл удалён
    }

    /**********************************************
     * Удаление всех элементов из списка по ключу
     */
    public void removeAll(T a_value)
    {

        DNode<T> node = m_dhead.next;
        while (node != m_dtail) {
            if(node.value == a_value){
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node = node.next;
        }
    }

/**
 * Вставка a_nodeToInsert после звена a_nodeToInsert
 */
public void insertAfter(DNode<T> a_nodeAfter, DNode<T> a_nodeToInsert)
{
// Проверка присутствия втавляемого элемента в списке
DNode<T> node = this.m_dhead.next;
while (node != m_dtail) {
  //Если список пустой, то закончить
  if ( this.count() == 0 ){ break; }
  if ( node == a_nodeToInsert ){
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.next = null;
    node.prev = null;
  }
    node = node.next;
}

// Вставка элемента
node = this.m_dhead.next;
if( a_nodeAfter == null ) {
  a_nodeToInsert.next = m_dhead.next;
  a_nodeToInsert.prev = m_dhead;
  m_dhead.next.prev = a_nodeToInsert;
  m_dhead.next = a_nodeToInsert;
} else {
      while( node != m_dtail ){
          if ( this.count() == 0 ){ break; }
          if ( node == a_nodeToInsert ){
              a_nodeToInsert.next = node.next;
              node.next.prev = a_nodeToInsert;
              node.next = a_nodeToInsert;
              a_nodeToInsert.prev = node;
          }
          node = node.next;
      }
}
}

/********************************
 * Количество элементов в списке
 */
public int count()
{
  int count = 0;
  DNode<T> node = m_dhead.next;
  while (node != m_dtail){
    count++;
    node = node.next;
  }
  return count; 
}

}

class DNode<T>
{
    public T value;
    public DNode<T> next;
    public DNode<T> prev;

    public DNode() 
    {  
      next = null;
      prev = null;
    }

    public DNode(T a_value) 
    { 
      value = a_value; 
      next = null;
      prev = null;
    }
}



