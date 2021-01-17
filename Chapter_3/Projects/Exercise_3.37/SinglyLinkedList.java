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

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
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

    /* insert given node given index */
    public  void insert(int index, T value) {
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException(index);



        if(index == 0) {
            addFirst(value);
            return;
        }
        else if(index == size) {
            addLast(value);
            return;
        }
        else {

            Node tempPrev = null;
            Node tempNext = head;
            for (int i = 0; i < index; i++) {
                tempPrev = tempNext;
                tempNext = tempNext.next;
            }

            Node newest = new Node(value, tempNext);
            tempPrev.setNext(newest);
            size++;
        }

    }

    /* remove given index and return the removed value */
    public T remove(int index) {
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException(index);

        if(index == 0) {
            return removeFirst();
        }

        Node tempPrev = null;
        Node removedNode = head;
        for(int i=0; i<index; i++) {
            tempPrev = removedNode;
            removedNode = removedNode.next;
        }

        if(index == size - 1) {
            tail = tempPrev;
            tempPrev.setNext(null);
        }
        else
            tempPrev.setNext(removedNode.getNext());

        size--;
        return (T)removedNode.getValue();

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
