package AlgorithmsLessons.Lesson5;

import AlgorithmsLessons.Lesson4.Stack;

public class Main {

    public static void t_printStackInt(Stack<Integer> a_stack){
        for(int i = a_stack.size(); i != 0; i--){
            System.out.println("[" + i + "] = " + a_stack.pop() );
        }
    }

    public static void main(String[] args) {
        
        // Create queue
        Queue<Integer> myQueue = new Queue<Integer>();

        myQueue.enqueue(1);
        myQueue.printQueue();


        myQueue.enqueue(2);
        myQueue.printQueue();

        myQueue.enqueue(3);
        myQueue.printQueue();

        myQueue.enqueue(4);
        myQueue.printQueue();

        myQueue.enqueue(5);
        myQueue.printQueue();

        myQueue.enqueue(6);
        myQueue.printQueue();

        System.out.println( );

        // Print queue
        myQueue.printQueue();

        myQueue.turnAround(121);

        myQueue.printQueue();

        myQueue.dequeue();

        myQueue.printQueue();

        myQueue.dequeue();

        myQueue.printQueue();





    }
}
