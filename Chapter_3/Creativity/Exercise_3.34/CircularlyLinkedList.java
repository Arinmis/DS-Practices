
/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.34 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Implement the clone( ) method for the CircularlyLinkedList class.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 04.01.2021
 *
 * */
class CircularlyLinkedList implements Cloneable {

    /**
     * static node class which keep integer as a value
     */
    public static class Node{
        private int value;
        private Node next;

        /**
         * Node constructor
         * @param value store node integer data
         * @param next reference of next node
         */
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * node's value getter
         * @return node's value
         */
        public int getValue() {
            return this.value;
        }

        /**
         * next node of current node
         * @return next's node
         */
        public Node getNext(){
            return this.next;
        }

        /**
         * setter of next property
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node tail;
    private int size;

    /**
     * circularly linked list constructor
     */
    public CircularlyLinkedList() {
        tail = null;
        size = 0;
    }

    /**
     * size property getter
     * @return circularly linked list size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * is list contain element
     * @return true if circularly linked list contain 0 element, else return false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * perform rotate operation if there are more than 1 element
     */
    public void rotate() {
        if(this.size > 1)
            this.tail = this.tail.next;
    }

    /**
     * add new node to head of circularly linked list
     * @param value new node integer value
     */
    public void addFirst(int value) {
        if(this.size == 0) {
            tail = new Node(value, null);
            tail.setNext(tail);
        }else{
            Node newValue = new Node(value, this.tail.getNext());
            tail.setNext(newValue);
        }
        size++;
    }

    /**
     * add new node to head of circularly linked list
     * @param value new node integer value
     */
    public void addLast(int value) {
        this.addFirst(value);   // by calling ad first we added node to the head
        tail = tail.getNext();  // then we change added node as tail, now it became last node
    }

    /**
     * getter method of tail node
     * @return circularly linked list's tail
     */
    public Node getTail() {
        return this.tail;
    }

    /**
     * compare CircularlyLinkedLists node by node
     * @param obj CircularlyLinkedList that will be compared "this"
     * @return whether given CircularlyLinkedList have same content with
     * "this" or not
     */
    @Override
    public boolean equals(Object obj){

        if(obj == null) return false;

        if(obj.getClass() != this.getClass())
            return false;

        CircularlyLinkedList cirList = (CircularlyLinkedList)obj;

        // if sizes are not same return false
        if(cirList.getSize() != this.size )
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

    /**
     * Overrided toString method of CircularlyLinkedList
     * @return string that shows CircularlyLinkedList's values
     */
    @Override
    public String toString() {
        String str = "[ ";

        // head node
        Node temp = this.tail.getNext();
        do{ //loop until head{
            str += (temp.getValue() + " " );
            temp = temp.getNext();
        }while(temp != this.getTail().next); // loop until arrive head again


        return str + "]";
    }

    /******************** Implementation of clone ************************/
    @Override
    public Object clone()  {
        CircularlyLinkedList newList = new CircularlyLinkedList();
        Node tempHead = this.tail.next;
        for(int i=0; i<size; i++) {
            newList.addLast(tempHead.getValue());
            tempHead = tempHead.next;
        }
        return newList;
    }
    /*********************************************************************/


}
