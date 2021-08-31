package Lesson1;

public class Summary{

public static LinkedList ListSummary( LinkedList a_list1, LinkedList a_list2 ) {
    LinkedList result = new LinkedList();
    Node node_1 = a_list1.head;
    Node node_2 = a_list2.head;
    if(a_list1.count() == a_list2.count()){
        while( node_1 != null){
            int sum = node_1.value + node_2.value;
            result.addInTail(new Node(sum));
            node_1 = node_1.next;
            node_2 = node_2.next;
        }
    }
    return result;
}

}
