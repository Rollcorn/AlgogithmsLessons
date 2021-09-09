package AlgorithmsLessons.Lesson4;

import java.util.*;

public class Stack<T>
{
    LinkedList<T> m_list;
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
     return 0;
    }

    /**
     * Извлекает последний помещенный в стек элемент
     * @return
     */
    public T pop()
    {
     // ваш код
     return null;  // если стек пустой
    }

    /**
     * Помещает элемент на самый верх стека
     * @param val
     */
    public void push(T val)
    {
     // ваш код
    }

    /**
     * Получить верхний элемент стека, но не удалять его
     * @return
     */
    public T peek()
    {
     // ваш код
     return null; // если стек пустой
    }
}
