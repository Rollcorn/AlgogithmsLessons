package AlgorithmsLessons.Lesson4;

import java.util.*;

public class Stack<T>
{
    private LinkedList<T> m_list;

    /**
     * Конструктор - инициализация внутреннего хранилища стека
     */
    public Stack()
    {
        m_list = new LinkedList<T>();
        
    } 

    /**
     * Размер текущего стека		  
     * @return
     */
    public int size() 
    {
        if( m_list.isEmpty() ){
            return 0;
        } else {
            return m_list.size();
        }
    }

    /**
     * Извлекает последний помещенный в стек элемент
     * @return
     */
    public T pop()
    {
        if( m_list.isEmpty() ){
            return null;  // если стек пустой
        } else {
            return m_list.removeLast();
        }
    }

    /**
     * Помещает элемент на самый верх стека
     * @param val
     */
    public void push(T val)
    {
        m_list.addLast(val);
    }

    /**
     * Получить верхний элемент стека, но не удалять его
     * @return
     */
    public T peek()
    {
        if(m_list.isEmpty()){
            return null; // если стек пустой
        } else {
            return m_list.getLast();
        }
    }
}
