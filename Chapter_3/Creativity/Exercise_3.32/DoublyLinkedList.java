/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.32 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Implement a circular version of a doubly linked list, without any sentinels, that
 *  supports all the public behaviors of the original as well as two new update meth-
 *  ods, rotate() and rotateBackward().
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 07.12.2020
 *  
 * */

public class DoublyLinkedList<T> {

    //inner node class
    public static class Node<T>{
        private T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }
    }

    //just tail implemented, tail's next is head
    private Node<T> tail;
    private int size = 0;

    public DoublyLinkedList() {}

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T last() {
        return tail.getValue();
    }

    public void addFirst(T value) {
       if(isEmpty()){
           Node<T> newest = new Node<>(value, null, null);
           tail = newest;
           newest.setPrev(newest); // prev is itself
           newest.setNext(newest); // next is itself
       }
       else{
           //create new node
           Node<T> newest = new Node(value, tail, tail.getNext());

           //updating next prev
           newest.getNext().setPrev(newest);


       }

       size++;
    }

    public void addLast(T value) {

        if(isEmpty()){
            Node<T> newest = new Node<>(value, null, null);
            tail = newest;
            newest.setPrev(newest); // prev is itself
            newest.setNext(newest); // next is itself
        }
        else{
            //create new node
            Node<T> newest = new Node(value, tail, tail.getNext());

            //updating next prev
            newest.getNext().setPrev(newest);

            // updating prev next
            newest.getPrev().setNext(newest);

            tail = newest; // update tail
        }

        size++;

    }

    public T removeFirst() {
        if(isEmpty())
            return null;
        // head will be removed
        return removeNode( tail.next);

    }

    public T removeLast() {
        if(isEmpty())
            return null;
        return removeNode(tail); // tail will be removed
    }

    private T removeNode(Node<T> node) {
        // set next prev as prev
        node.getNext().setPrev(node.getPrev());

        // set prev next as next
        node.getPrev().setNext(node.getNext());

        return node.getValue();
    }



    private T remove(Node<T> node) {
        Node<T> predecessor = node.getPrev();
        Node<T>  successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;

        return node.getValue();
    }

    //shift all element to one the step right
    public void rotate() {
        tail = tail.getPrev();
    }

    //shift all element to one the step left
    public void rotateBackward() {
        tail = tail.getNext();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");

        Node<T> temp = this.tail.next; // accessing head

         do{
            result.append(temp.getValue() + " ");
            temp = temp.getNext();
        }while(temp != this.tail.next); // loop until head

        return result.toString() + "]";
    }

}
