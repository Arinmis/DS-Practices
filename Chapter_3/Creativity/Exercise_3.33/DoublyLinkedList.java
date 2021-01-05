/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.33 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Solve the previous problem using inheritance, such that a DoublyLinkedList class
 *  inherits from the existing CircularlyLinkedList, and the DoublyLinkedList.Node
 *  nested class inherits from CircularlyLinkedList.Node.
 *  --------------------------------------------------------------------------------
 *
 *  NOTE: Since Doubly linked list Node must have previous node ,which doubly linked
 *  list node doesn't have, inheritance does not help too much except the value and size
 *  part of the doubly linked list.
 *
 *  @author Mustafa Arinmis
 *  @since 03.01.2021
 *
 * */

public class DoublyLinkedList extends CircularlyLinkedList{


    public static class Node extends CircularlyLinkedList.Node {
        private Node prev;
        private Node next; // create DoublyLinkedList.Node instance

        public Node(int value, Node prev, Node next) {
            super(value, null);
            this.prev = prev;
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }


    private Node head = null;
    private Node tail = null;

    public DoublyLinkedList() {}


    @Override
    public void addFirst(int value) {

        if(super.getSize() == 0) {
            Node newest = new Node(value, null, null);

            //set head and tail as newest node
            head = newest;
            tail = newest;

            //set newest's prev and next as itself
            newest.setPrev(newest);
            newest.setNext(newest);
        }else{
            Node newest = new Node(value, tail, head);

            tail.setNext(newest); //set prev next newest
            head.setPrev(newest); //set next prev newest
            head = newest; //update head
        }
        super.setSize(super.getSize() + 1);
    }

    @Override
    public  void  addLast(int value) {
        addFirst(value); // add values to the first
        tail = tail.next; // then shift both tail and head to forward
        head = head.next;
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head ) {
        this.head = head;
    }

    @Override
    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    //shift all element to one the step right
    public void rotate() {
        head = tail;
        tail = tail.prev;
    }

    //shift all element to one the step left
    public void rotateBackward() {
        tail = head;
        head = head.next;
    }

    @Override
    public String toString() {
        String str = "[ ";

        // head node
        CircularlyLinkedList.Node temp = this.head;
        do{ //loop until head{
            str += (temp.getValue() + " " );
            temp = temp.getNext();
        }while(temp != this.head); // loop until arrive head again

        return str + "]";
    }

    @Override
    public boolean equals(Object obj){

        if(obj == null) return false;

        if(!(obj instanceof DoublyLinkedList))
            return false;

        DoublyLinkedList cirList = (DoublyLinkedList)obj;

        // if sizes are not same return false
        if(cirList.getSize() != super.getSize() )
            return false;

        Node walkA = cirList.tail.next; //head node of cirList
        Node walkB = this.tail.next;    // head node of this

        do{
            if(walkA.getValue() != walkB.getValue())
                return false;   // nodes are different

            walkA = walkA.getNext(); //assign next nodes to walkA and walkB
            walkB = walkB.getNext();
        }while(walkA != cirList.getTail().getNext()); // loop until encourage cirList head

        return true; //all elements are same

    }
}
