package AlgorithmsLessons.Lesson4;

public class Main {
    
    public static void t_printStackChar(Stack<Character> a_stack){
        for(int i = a_stack.size(); i != 0; i--){
            System.out.println("[" + i + "] = " + a_stack.pop() );
        }
    }
    public static void t_printStackInt(Stack<Integer> a_stack){
        for(int i = a_stack.size(); i != 0; i--){
            System.out.println("[" + i + "] = " + a_stack.pop() );
        }
    }
    public static void main(String[] args) {
      
        // Создание стека
        Stack<Integer> myStack = new Stack<Integer>();

        // Заполнение стека
        myStack.push(1);
        // Получить верхушку стека
        System.out.println( "[1] = " + myStack.peek() );

        myStack.push(2);
        System.out.println( "[2] = " + myStack.peek() );

        myStack.push(3);
        System.out.println( "[3] = " + myStack.peek() );

        myStack.push(4);
        System.out.println( "[4] = " + myStack.peek() );
        
        myStack.push(5);
        System.out.println( "[5] = " + myStack.peek() );

        System.out.println( );

        // Очистка стека
        t_printStackInt(myStack);
/*
        String checkStr = "(((())))()";
        System.out.println("Frames sequences: " + checkStr );
        System.out.println( Stack.frameBalance(checkStr) );
        System.out.println( );
*/
/*
        System.out.println("Postfix calculating: ");
        Stack<Character> exprStack = new Stack<Character>();
        exprStack.push('=');
        exprStack.push('+');
        exprStack.push('9');
        exprStack.push('*');
        exprStack.push('5');
        exprStack.push('+');
        exprStack.push('2');
        exprStack.push('8');

        // Очистка стека
        // t_printStackChar(exprStack);
        System.out.println("Result is: " + Stack.postfixCalc(exprStack));
*/
    }
}
