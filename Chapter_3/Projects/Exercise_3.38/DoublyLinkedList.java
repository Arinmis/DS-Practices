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


    public void insert(int index, T value) {
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
        else { // we need to loop with considering where the target node
            if(accessFromHead(index)) { // target index at the first half of list
                   Node backNode = this.head;
                   for(int i=0; i<index; i++) {
                       backNode = backNode.getNext();
                   }
                   addBetween(value, backNode, backNode.next);
            }else { // target at the last half
                Node frontNode = this.tail.getPrev();
                for(int i=size-1; i>index; i--) {
                    frontNode = frontNode.getPrev();
                }
                addBetween(value, frontNode.getPrev(), frontNode);
            }
        }
    }

    //remove methods
    public T remove(int index) {
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException(index);

        if(index == 0) {
            return removeFirst();
        }

        if(index == size - 1) {
            return removeLast();
        }

        Node removedNode = null;
        if(accessFromHead(index)) { //remove from head
            removedNode = this.head.next;
            for(int i=0; i<index; i++)
                removedNode = removedNode.getNext();

        }else {
            removedNode = this.tail.getPrev();
            for(int i=size - 1; i>index; i--)
                removedNode = removedNode.getPrev();
        }

        size--;
        return (T)removedNode.getValue();
    }

    /* determine whether given index more close head or tail*/
    private boolean accessFromHead(int index) {
        int middle = size / 2;
        if(index <= middle)
            return true;
        return false;
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

    public Node<T> getTail() {
        return tail;
    }

    public Node<T> getHead() {
        if(size == 0) {
            return null;
        }
        return head;
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
