// package AlgorithmsLessons.Lesson6;

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
        return m_list.pollFirst();
    }

    public T removeTail()
    {
     return m_list.pollLast();
    }

    public T peekTail()
    {
     return m_list.peekLast();
    }

    public T peekFirst()
    {
        return m_list.peekFirst();
    }
        
    public int size()
    {
     return m_list.size();
    }
    
    public static boolean palindromCheck(String str){
        Deque<Character> charList = new Deque<Character>();
        
        for(int i = 0; i != str.length(); i++){
            charList.addTail(str.charAt(i));
        }

        while( charList.size() != 0 ){
            if( charList.size() == 1 ){
                return true;
            }

            if( charList.peekFirst() == charList.peekTail() ){
                charList.removeFront();
                charList.removeTail();
            } else {
                return false;
            }
        }
        return true;
    }
}