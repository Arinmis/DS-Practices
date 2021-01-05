/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.31 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Our implementation of a doubly linked list relies on two sentinel nodes, header
 *  and trailer, but a single sentinel node that guards both ends of the list should
 *  suffice. Reimplement the DoublyLinkedList class using only one sentinel node.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 03.11.2020
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


        private Node sentinel; // sentinel node to protect head and tail
        private int size = 0;

        public DoublyLinkedList() {
            // prev and next of the sentinel is itself
            sentinel = new Node(null, null, null);
            sentinel.setPrev(sentinel); //
            sentinel.setNext(sentinel);
        }

        public int getSize() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public void addFirst(T value) {
            // create node
            Node<T> newest = new Node<>(value, sentinel, sentinel.getNext());

            //set newest's prev's(sentinel's) next as newest
            sentinel.setNext(newest);

            //set newest's next's prev as newest
            newest.getNext().setPrev(newest);

            size++;

        }
        
        public T first() {
          return (T)sentinel.getNext().getValue();
        }

        public T last() {
           return (T)sentinel.getPrev().getValue();
        }

        public void addLast(T value) {
            // create node
            Node<T> newest = new Node<>(value, sentinel.getPrev(), sentinel);
            // set newest's prev's next as newest
            sentinel.getPrev().setNext(newest);
            // set newest's next's(sentinel's) as newest
            sentinel.setPrev(newest);

            size++;
        }

        public T removeFirst() {
            if(isEmpty())
                return null;
            T removedValue = (T)sentinel.getNext().getValue();

            sentinel.setNext(sentinel.getNext().getNext());
            sentinel.getNext().getNext().setPrev(sentinel);

            return removedValue;
        }

        public T removeLast() {
            if(isEmpty())
                return null;

            T removedValue = (T)sentinel.getPrev().getValue();

            sentinel.getPrev().getPrev().setNext(sentinel);
            sentinel.setPrev(sentinel.getPrev().getPrev());

            return removedValue;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("[ ");

            Node<T> temp = this.sentinel.next;

            while(temp != sentinel) {
                result.append(temp.getValue() + " ");
                temp = temp.getNext();
            }

            return result.toString() + "]";
        }
}
