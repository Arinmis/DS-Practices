/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.23 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Suppose you are designing a multiplayer game that has n ≥ 1 000 players, num-
 *  bered 1 to n, interacting in an enchanted forest. The winner of this game is the
 *  first player who can meet all the other players at least once (ties are allowed).
 *  Assuming that there is a method meet(i, j), which is called each time a player i
 *  meets a player j (with i 6 = j), describe a way to keep track of the pairs of meeting
 *  players and who is the winner.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 20.11.2020
 *
 * */


public class Player{
    //we need to store meeted Players
    private Player[] meetedPlayer;
    private int numOfMeeted = 0;

    public Player(int totalPlayer) {
        // to winning, total - 1 player meeting needed
        meetedPlayer = new Player[totalPlayer - 1];
    }

    public void meet(Player j) {
        //this class belong to Player i

        //player cannnot met with himself/herself.
        if(!this.equals(j)) {

            // if i j haven't meeted with j yet, we need to store j
            if(!isMeeted(j)){
                meetedPlayer[numOfMeeted] = j;
                numOfMeeted++;

                //we also need to i to j meetedPlayers
                j.meet(this);
            }
        }

    }

    public boolean isMeeted(Player player) {
        // check for player i already met j
        for(int i=0; i<numOfMeeted; i++) {
            if(player.equals(meetedPlayer[i]))
                return true;
        }
        return false;
    }

    public boolean isWin() {
        // check for player meet all other player in the game
        return numOfMeeted == meetedPlayer.length;
    }
}
