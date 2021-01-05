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


public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // add element to the list's beginning
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        // add element to the end of the list
        list.addLast(4);

        // print the list
        System.out.println(list.toString());
        //remove from the beginning
        System.out.println("Removed value: " + list.removeFirst());
        // remove from the end
        System.out.println("Removed value: " + list.removeLast());
        // print the updated list
        System.out.println(list.toString());


    }
}
