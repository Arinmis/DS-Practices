import java.util.concurrent.TimeUnit;

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


        ScoreBoard board = new ScoreBoard();
        GameEntry entry1 = new GameEntry( "first", 10);
        GameEntry entry2 = new GameEntry( "second", 20);
        GameEntry entry3 = new GameEntry( "third", 30);
        GameEntry fifteen = new GameEntry( "oneAndHalf", 15);


        for (int i=0; i<2000; i++) {
            GameEntry entry =
                    new GameEntry( "entry" + (i+1), (int)(Math.random() * 100) + 1);

            System.out.println("Generated: " + entry);
            board.add(entry);
            System.out.println("Board: " + board);
            System.out.println("Size: " + board.getNumEntries());
            System.out.println("\n");
        }

        System.out.println(board.remove(2));
        System.out.println(board.remove(8));


    }
}