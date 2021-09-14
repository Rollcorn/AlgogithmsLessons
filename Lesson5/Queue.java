package AlgorithmsLessons.Lesson5;

import java.util.*;

public class Queue<T>
{
    LinkedList<T> m_list;
    
    public Queue()
    {
        m_list = new LinkedList<T>();
    } 

    // enter element in the end of list 
    public void enqueue(T a_item)
    {
        m_list.addLast(a_item);
    }

    // return first element and remove it 
    public T dequeue()
    {
        return m_list.pollFirst();
    }

    public int size()
    {
        return m_list.size();
    }

    public void turnAround(int N){
        for(int i = 0; i != N; i++){
            m_list.addLast(m_list.pollFirst());
        }
    }

    public void printQueue(){
        LinkedList<T> print = new LinkedList<T>();

        while( m_list.size() != 0 ){
            System.out.print(" [" + m_list.element() + "] ");
            print.addLast(m_list.pollFirst());
        }
        System.out.println();

        while( print.size() != 0 ){
            m_list.addLast(print.pollFirst());
        }
    }



}