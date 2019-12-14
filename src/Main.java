import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialize objects:
        Board board = new Board();
        Player player1 = new Player(Symbol.CIRCLE);
        Player player2 = new Player(Symbol.CROSS);
        setupPlayer(player1);
        setupPlayer(player2);
        //Start the game:
        boolean winnerPosition = false;
        board.printBoard();
        while (!winnerPosition) {
            player1.play(board);
            board.printBoard();
            winnerPosition = board.evaluate();
            if (winnerPosition) {
                break;
            }
            player2.play(board);
            board.printBoard();
            winnerPosition = board.evaluate();
        }
    }

    private static void setupPlayer(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Choose p for human player and c for computer:");
            String choice = scanner.nextLine();
            choice = choice.toLowerCase();
            if (choice.equals("p")) {
                player.setDecisionMaker(new Human());
                System.out.println("Your symbol in the game is: " + player.getSymbol());
                isValid = true;
            } else if (choice.equals("c")) {
                player.setDecisionMaker(new AI());
                System.out.println("Your symbol in the game is: " + player.getSymbol());
                isValid = true;
            } else {
                System.out.println("This isn't a valid choice. Choose again.");
            }
        }
    }

}
