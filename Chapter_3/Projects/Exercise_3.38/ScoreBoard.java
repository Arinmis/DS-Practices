
public class ScoreBoard {
    // no need to maintain num entries, it can be accessed via board length
    private DoublyLinkedList<GameEntry> board;

    public ScoreBoard() { // top ten score will be in the board
        board = new DoublyLinkedList<>();
    }

    /* add entries to the singly linked list so that
    the smallest will be head and the highest will be is tail */
    public void add(GameEntry entry) {

        if(board.isEmpty()) { //if board is put the entry
            board.addFirst(entry);
            return;
        }
        else { //doubly linked list has 2 sentinel node
            DoublyLinkedList.Node iterator = board.getHead().getNext();

            int index = 0;
            while(iterator != board.getTail() && entry.compareTo((GameEntry) iterator.getValue()) == 1) { // find target index
                index++;
                iterator = iterator.getNext();
            }

            board.insert(index, entry); // insert entry
            check(); // check size of the board

        }

    }

    /* check method will maintain size of the board so that will be maximum 10 */
    private void check() {
        if(board.getSize()  > 10)
            board.remove(10); // remove extra game entry
    }

    public GameEntry remove(int index) {
        return board.remove(index);
    }

    public int getNumEntries() {
        return board.getSize();
    }

    @Override
    public String toString() {
        return board.toString();
    }

}