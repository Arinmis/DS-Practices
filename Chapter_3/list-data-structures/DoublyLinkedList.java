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

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<> (null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(T value) {
        addBetween(value, head, head.next);
    }

    public void addLast(T value) {
        addBetween(value, tail.prev, tail);
    }

    public T removeFirst() {
        if(isEmpty())
            return null;
        return remove(head.getNext());
    }

    public T removeLast() {
        if(isEmpty())
            return null;
        return remove(tail.getPrev());
    }



    private void addBetween(T value, Node<T> predecessor, Node<T> successor) {
        Node<T> newest = new Node<>(value, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private T remove(Node<T> node) {
       Node<T> predecessor = node.getPrev();
       Node<T>  successor = node.getNext();

       predecessor.setNext(successor);
       successor.setPrev(predecessor);
       size--;

       return node.getValue();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");

        Node<T> temp = this.head.next;

        while(temp != this.tail) {
            result.append(temp.getValue() + " ");
            temp = temp.getNext();
        }

        return result.toString() + "]";
    }

}
