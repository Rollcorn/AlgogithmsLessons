package AlgorithmsLessons.Lesson6;

import java.util.*;

public class Deque<T>
{
    LinkedList<T> m_list;

    public Deque()
    {
        m_list = new LinkedList<T>();
    }

    public void addFront(T item)
    {
        m_list.addFirst(item);
    }

    public void addTail(T item)
    {
        m_list.addLast(item);
    }

    public T removeFront()
    {
        return m_list.removeFirst();
    }

    public T removeTail()
    {
     // удаление из хвоста
     return m_list.removeLast();
    }
        
    public int size()
    {
     return m_list.size(); // размер очереди
    }
}