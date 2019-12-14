import java.util.Scanner;

public class Human implements DecisionMaker {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void play(Symbol symbol, Board playBoard) {
        boolean isValid = false;
        Symbol[][] board = playBoard.getBoard();
        while (!isValid) {
            System.out.println("Input row number:");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.println("Input column number:");
            int column = Integer.parseInt(scanner.nextLine());
            if (board[row][column] == Symbol.DEFAULT) {
                playBoard.setBoard(row, column, symbol);
                isValid = true;
            } else {
                System.out.println("This position is already taken.");
            }
        }
    }

}
