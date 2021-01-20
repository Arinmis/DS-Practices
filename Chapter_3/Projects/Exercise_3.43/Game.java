/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.43 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  In the children’s game, Duck, Duck, Goose, a group of children sit in a circle.
 *  One of them is elected “it” and that person walks around the outside of the circle.
 *  The person who is “it” pats each child on the head, saying “Duck” each time, until
 *  randomly reaching a child that the “it” person identifies as “Goose.” At this point
 *  there is a mad scramble, as the “Goose” and the “it” person race around the circle.
 *  Whoever returns to the Goose’s former place first gets to remain in the circle.
 *  The loser of this race is the “it” person for the next round of play.  The game
 *  continues like this until the children get bored or an adult tells them it’s snack
 *  time. Write software that simulates a game of Duck, Duck, Goose.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since  20.01.2021
 *
 * */

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        PlayGround playGround = new PlayGround(5); //player will be sit on circle with radius 5
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of player: ");
        int numOfPlayer = input.nextInt();

        Player it = new Player("player1", getRandomSpeed());
        for(int i=2; i<numOfPlayer + 1; i++)
            playGround.addPlayer(new Player("player" + i, getRandomSpeed()));

        boolean isFinished = false;
        while(!isFinished) {
            int index = chooseGoose(numOfPlayer); // choose next 'it' candidate
            Player goose = playGround.getPlayer(index);
            System.out.println("\nCurrent 'It': " + it);
            System.out.println("Selected 'Goose': " + goose);
            System.out.println("Playground: " + playGround);

            if(isItFaster(it, playGround.getPlayer(index), playGround)) { // if goose lose game
               it =  playGround.replace(it, index); // goose became a new 'it'
            }
            System.out.println("\nUpdated 'It': " + it);
            System.out.println("Updated Playground: " + playGround + "\n");
            System.out.print("Do you want to continue to game?(y/n): ");
            isFinished = promptAnswer(input.next());
        }

        System.out.println("Game ended...");
    }

    public static int chooseGoose(int numOfPlayer) {
        return (int)(Math.random() * (numOfPlayer - 1));
    }

    public static boolean promptAnswer(String answer) {
        if(answer.charAt(0) == 'y' || answer.charAt(0) == 'Y')
            return false;
        return true;
    }

    /* return random speed between 10 m/s 20m/s */
    public static int getRandomSpeed() {
        return (int)(Math.random() * 10) + 10;
    }

    /* return true if 'it' rotate circle before the 'goose' */
    public static boolean isItFaster(Player it, Player goose, PlayGround playGround) {

        if(it.compareTo(goose) == -1)
            return false;
        return true;
    }

}