public class Hangman {
    public static void main(String[] args){
        if (args.length ==0){
            System.out.println("Usage: java Hangman <answer> ");
            System.err.println("type an answer next to java Hangman");
            System.exit(1);

        }
        for (char letter : (args[0]).toCharArray()) {
            if (!(Character.isLetter(letter))) {
                System.err.printf("the answer should contain only letters!!!! Please enter letters only.");
                System.exit(1);
            }
        }
    Game game = new Game(args[0]);
        Prompter prompter = new Prompter(game);
    while (game.getRemainingTries() > 0 && !game.isWon()) {

        prompter.displayProgress();
        prompter.promptForGuess();
    }
 prompter.displayOutcome();

    }
}