/**
 * The implementation of circularly linked list class
 *
 *
 */
class CircularlyLinkedList<T> {

    /**
     * static node class which keep generic as a value
     */
    public static class Node<T>{
        private T value;
        private Node next;

        /**
         * Node constructor
         * @param value store node T data
         * @param next reference of next node
         */
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * node's value getter
         * @return node's value
         */
        public T getValue() {
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

        public void setValue(T value) {
           this.value = value;
        }
    }

    private Node tail = null;
    private int size = 0;

    /**
     * circularly linked list constructor
     */
    public CircularlyLinkedList() {}

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
        if(this.size > 1)
     * perform rotate operation if there are more than 1 element
                */
        public void rotate() {
            this.tail = this.tail.next;
    }

    /**
     * add new node to head of circularly linked list
     * @param value new node integer value
     */
    public void addFirst(T value) {
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
     * @param value new node T value
     */
    public void addLast(T value) {
        this.addFirst(value);   // by calling ad first we added node to the head
        tail = tail.getNext();  // then we change added node as tail, now it became last node
    }

    /**
     * getter method of tail node
     * @return circularly linked list's tail
     */
    public Node<T> getTail() {
        return this.tail;
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
}