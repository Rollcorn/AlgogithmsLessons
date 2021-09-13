package AlgorithmsLessons.Lesson4;

import java.util.*;

public class Stack<T>
{
    private LinkedList<T> m_list;

    /***********************************************************
     * Конструктор - инициализация внутреннего хранилища стека
     */
    public Stack()
    {
        m_list = new LinkedList<T>();
        
    } 

    /*************************
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

    /*************************************************
     * Извлекает последний помещенный в стек элемент
     * @return
     */
    public T pop()
    {
        return m_list.pollFirst();
    }

    /****************************************
     * Помещает элемент на самый верх стека
     * @param val
     */
    public void push(T val)
    {
        m_list.addFirst(val);;
    }

    /****************************************************
     * Получить верхний элемент стека, но не удалять его
     * @return
     */
    public T peek()
    {
        return m_list.peekFirst();
    }

    /************************************************************
     * Определяет сбалансированны ли скобки в переданной строке 
     */
    public static boolean frameBalance(String str){
       
        Stack<Character> myStack = new Stack<Character>();
        for(int i = 0; i < str.length(); i++){

            if( (myStack.size() == 0)){
                if( (str.charAt(i) == '(' || str.charAt(i) == ')')){
                    myStack.push( str.charAt(i) );
                } else {
                    continue;
                }
            } else {
                if ( (myStack.peek() == '(') && ( str.charAt(i) == ')' ) ) {
                    myStack.pop();
                } else if( (str.charAt(i) == '(') || (str.charAt(i) == ')') ){
                    myStack.push( str.charAt(i) );
                }
            }
        }

        return ( myStack.size() == 0 )? true : false;
    }

    /************************************************************
     *  
     */
}

