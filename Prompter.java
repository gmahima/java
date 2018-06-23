import java.util.Scanner;
public class Prompter{
    private Game game;

    public Prompter (Game game){
        this.game = game;
    }
    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAccepltable = false;
        do {
            System.out.printf("guess a letter:         \n");
            String guessInput = scanner.nextLine();



            try {
                isHit = game.applyGuess(guessInput);
                isAccepltable = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s, please tryagain!!!!", iae.getMessage());
            }
        } while(! isAccepltable);

        return isHit;
    }
    public void displayProgress() {
        System.out.printf("you can make a maximum of %d misses!!!", game.getRemainingTries());
        System.out.printf("take a guess : %s  \n ", game.getCurrentProgress());


    }
    public void displayOutcome() {
        if (game.isWon()) {
            System.out.printf("Congrats!! You won it!!!!! You had %d tries remaining.\n", game.getRemainingTries());
        }
        else {
            System.out.printf("Oops!! You ran out of tries! The answer was '%s'. Better luck next time!!", game.getAnswer());
        }
    }

}