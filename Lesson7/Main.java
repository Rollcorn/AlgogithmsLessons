package AlgorithmsLessons.Lesson7;
import java.util.*;

public class Main {
    
    public static void t_printList(OrderedList<Integer> a_list){
        int i = 0;
        ArrayList<Node<Integer>> arr = a_list.getAll();
        for(Node<Integer> node : arr){
            System.out.println("[" + i + "] = " + node.value);
            i++;
        }
        if(a_list.head == null){
            System.out.println("Head = " + a_list.head);
        }else System.out.println("Head = " + a_list.head.value);
        if(a_list.tail == null){
            System.out.println("Head = " + a_list.tail);
        }else System.out.println("Tail = " + a_list.tail.value);
        System.out.println("Количество элементов в списке: " + a_list.count());
    }

    public static void t_find(OrderedList<Integer> a_list, Integer a_val){
        System.out.println("Резуьтат поиска числа " + a_val + " = " + 
                            a_list.find(a_val));
    }

    public static void t_delete(OrderedList<Integer> a_list, Integer a_val){
        System.out.println("Удалить число " + a_val);
        a_list.delete(a_val);
    }

    public static void t_clear(OrderedList<Integer> a_list){
        System.out.println("Очистка списка");
        a_list.clear(true);
    }


    public static void main(String[] args) {
        OrderedList<Integer> mList = new OrderedList<Integer>(false);
       
        t_printList(mList);
        mList.add(6);
        mList.add(8);
        mList.add(3);
        mList.add(9);
        mList.add(4);
        mList.add(5);
        mList.add(4);
        mList.add(2);
        mList.add(1);
        t_printList(mList);

        t_find(mList, 7);
/*
        t_delete(mList, 2);
        t_printList(mList);

        t_clear(mList);
        t_printList(mList);
        t_find(mList, 7);

        t_delete(mList, 5);
        t_printList(mList);

        mList.add(3);
        t_printList(mList);
        t_delete(mList, 3);
        t_printList(mList);

        mList.add(9);
        mList.add(4);
        mList.add(5);
        mList.add(6);
        mList.add(8);
        mList.add(3);
        t_printList(mList);

        t_delete(mList, 3);
        t_printList(mList);
        t_delete(mList, 9);
        t_printList(mList);
*/

    }
}
