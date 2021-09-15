package AlgorithmsLessons.Lesson4;

import java.util.*;

public class Stack<T>
{
    private LinkedList<T> m_list;

    public Stack()
    {
        m_list = new LinkedList<T>();
        
    } 

    public int size() 
    {
        return m_list.size();
    }

    public T pop()
    {
        return m_list.pollFirst();
    }

    public void push(T val)
    {
        m_list.addFirst(val);;
    }

    public T peek()
    {
        return m_list.peekFirst();
    }

    public static boolean frameBalance(String str){
       
        Stack<Character> myStack = new Stack<Character>();

        for ( int i = 0; i < str.length(); i++ ) {

            if ( (str.charAt(i) == ')') &&  (myStack.peek().equals('(')) ) {
                myStack.pop();
            } else if( ( str.charAt(i) == '(') || (str.charAt(i) == ')') ){
                myStack.push( str.charAt(i) );
            }

        }
        return ( myStack.size() == 0 )? true : false;
    }

    public static Integer postfixCalc( Stack<Character> a_expr){

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
}

