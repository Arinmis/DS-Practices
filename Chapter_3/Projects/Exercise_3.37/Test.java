/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.37 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Write a class that maintains the top ten scores for a game application, implement-
 *  ing the add and remove methods of Section 3.1.1, but using a singly linked list
 *  instead of an array.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since  06.01.2021
 *
 * */
public class Test {
    public static void main(String[] args) throws InterruptedException{

        /* add random entries to scoreboard to test it */
        ScoreBoard board = new ScoreBoard();


        for (int i=0; i<2000; i++) {
            GameEntry entry =
                    new GameEntry( "entry" + (i+1), (int)(Math.random() * 100) + 1);

            System.out.println("Generated: " + entry);
            board.add(entry);
            System.out.println("Board: " + board);
            System.out.println("Size: " + board.getNumEntries());
            System.out.println("\n");
        }

    }
}