package LinkedList2;

public class DummyLinkedList {

    public Node head;
    public Node tail;

    public DummyLinkedList()
    {
        DammyNode head = new DammyNode();
        DammyNode tail = new DammyNode();
    }

}
class DammyNode
{
//    public int value;
    public Node next;
    public Node prev;

    public DammyNode()
    {
//        value = _value;
        next = null;
        prev = null;
    }
}

class DNode extends DammyNode
{
    public int value;


    public DNode(int _value)
    {
        value = _value;

    }
}