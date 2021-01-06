
public class ScoreBoard {
    // no need to maintain num entiries, it can be accessed via board length
    private SinglyLinkedList<GameEntry> board;

    public ScoreBoard() { // top ten score will be in the board
        board = new SinglyLinkedList<>();
    }

    /* add entries to the singly linked list so that
    the smallest will be head and the highest will be is tail */
    public void add(GameEntry entry) {

        int newScore = entry.getScore();

        if(board.isEmpty()) { //if board is put the entry
            board.addFirst(entry);
            return;
        }
        else { //loop through list until less than or equal entry will be found
            SinglyLinkedList.Node nextNode = board.getHead(); // reference to head for looping
            SinglyLinkedList.Node prevNode = null; // we need to keep prev node
            int i=0;                               // to add new entry between prev and next
            int numEntries = getNumEntries();
            while(i < numEntries + 1 && i < 10) {
                if(entry.getScore() <= ((GameEntry)nextNode.getValue()).getScore()) {
                    if(prevNode == null) {
                        board.addFirst(entry); // first entry less than or equal to given entry
                        return;
                    }else if(i == 10) {
                        board.addLast(entry); // last entry less than or equal to given entry
                        return;
                    }
                    else { //place between prev and next
                        board.insert(i, entry);
                        return;
                    }
                }
                if( getNumEntries() >= 11) { // remove smallest one if there is an element more than 11
                    board.removeFirst();
                    return;
                }

                // update next and prev nodes
                prevNode = nextNode;
                nextNode = nextNode.getNext();

                if( nextNode == null) {
                    board.addLast(entry); //entry has greatest score
                    if( getNumEntries() >= 11) // remove smallest one if there is an element more than 11
                        board.removeFirst();
                    return;
                }
                i++;
            }



        }
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