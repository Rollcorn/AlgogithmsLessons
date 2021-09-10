package AlgorithmsLessons.Lesson4;

public class Main {
    
    public static void t_printStack(Stack<Integer> a_stack){
        for(int i = a_stack.size(); i != 0; i--){
            System.out.println("[" + i + "] = " + a_stack.pop() );
        }
    }
    public static void main(String[] args) {
        // �������� �����
        Stack<Integer> myStack = new Stack<Integer>();

        // ���������� �����
        myStack.push(1);
        // �������� �������� �����
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

        // ������� �����
        t_printStack(myStack);

    }
}
