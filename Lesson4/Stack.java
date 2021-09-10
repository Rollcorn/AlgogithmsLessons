package AlgorithmsLessons.Lesson4;

import java.util.*;

public class Stack<T>
{
    private LinkedList<T> m_list;

    /**
     * ����������� - ������������� ����������� ��������� �����
     */
    public Stack()
    {
        m_list = new LinkedList<T>();
        
    } 

    /**
     * ������ �������� �����		  
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
     * ��������� ��������� ���������� � ���� �������
     * @return
     */
    public T pop()
    {
        if( m_list.isEmpty() ){
            return null;  // ���� ���� ������
        } else {
            return m_list.removeLast();
        }
    }

    /**
     * �������� ������� �� ����� ���� �����
     * @param val
     */
    public void push(T val)
    {
        m_list.addLast(val);
    }

    /**
     * �������� ������� ������� �����, �� �� ������� ���
     * @return
     */
    public T peek()
    {
        if(m_list.isEmpty()){
            return null; // ���� ���� ������
        } else {
            return m_list.getLast();
        }
    }
}
