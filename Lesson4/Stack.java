// package AlgorithmsLessons.Lesson4;

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
     */
    public int size() 
    {
        return m_list.size();
    }

    /*************************************************
     * Извлекает последний помещенный в стек элемент
     */
    public T pop()
    {
        return m_list.pollFirst();
    }

    /****************************************
     * Помещает элемент на самый верх стека
     */
    public void push(T val)
    {
        m_list.addFirst(val);;
    }

    /****************************************************
     * Получить верхний элемент стека, но не удалять его
     */
    public T peek()
    {
        return m_list.peekFirst();
    }

    /************************************************************
     * Определяет сбалансированны ли скобки в переданной строке 
     */
/*    public static boolean frameBalance(String str){
       
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
     * Вычисляет выражение в постфиксной записи "8 2 + 5 * 9"
     */
 /*   public static Integer postfixCalc( Stack<Character> a_expr){

        Stack<Integer> res = new Stack<Integer>();
        int resVar;
        int tmpVar;
        while ( 0 != a_expr.size() ){

            switch(a_expr.peek())
            {
                case '+':
                    a_expr.pop();
                    resVar = res.pop() + res.pop();
                    res.push(resVar);
                    break;
                case '-':
                    a_expr.pop();
                    tmpVar =  res.pop();
                    resVar = res.pop() - tmpVar;
                    res.push(resVar);
                    break;
                case '*':
                    a_expr.pop();
                    resVar = res.pop() * res.pop();
                    res.push(resVar);
                    break;
                case '/':
                    a_expr.pop();
                    tmpVar =  res.pop();
                    resVar = res.pop() / tmpVar;
                    res.push(resVar);
                    break;
                case '=':
                    a_expr.pop();
                    return res.pop();
                default:
                    res.push( Integer.parseInt( String.valueOf(a_expr.pop()) ) );
            }
        }
        return res.pop();
    }
*/
}

