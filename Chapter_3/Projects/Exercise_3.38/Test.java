/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.38 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Perform the previous project, but use a doubly linked list. Moreover, your imple-
 *  mentation of remove(i) should make the fewest number of pointer hops to get to the
 *  game entry at index i.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since  17.01.2021
 *
 * */
public class Test {
    public static void main(String[] args) throws InterruptedException{

        /* add random entries to scoreboard to test it */
        ScoreBoard board = new ScoreBoard();

        for (int i=2; i<100; i++) {
            GameEntry entry =
                    new GameEntry( "entry" + (i+1), (int)(Math.random() * 100) + 3);

            System.out.println("Generated: " + entry);
            board.add(entry);
            System.out.println("Board: " + board);
            System.out.println("Size: " + board.getNumEntries());
            System.out.println("\n");
        }

    }
}