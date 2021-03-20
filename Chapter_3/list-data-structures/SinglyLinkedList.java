public class SinglyLinkedList<T> {

    //inner node class
    public static class Node<T>{
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {}

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(T value) {
        this.head = new Node<>(value, this.head);
        if(this.size == 0) {
            this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(T value) {
        Node<T> newest = new Node<>(value, null);
        if(this.isEmpty()) {
            this.head = newest;
        }
        else{
            this.tail.setNext(newest);
        }
        this.tail = newest;
        this.size++;
    }


    public T removeFirst() {
        if(isEmpty())
            return null;

        T answer = this.head.getValue();
        this.head = head.getNext();
        size--;

        if(size == 0)
            this.tail = null;

        return answer;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");

        Node<T> temp = this.head;

        while(temp != null) {
            result.append(temp.getValue() + " ");
            temp = temp.getNext();
        }

        return result.toString() + "]";
    }





}
