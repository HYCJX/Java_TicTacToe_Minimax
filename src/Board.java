public class Board {

    public static final int rowLength = 3;
    public static final int columnLength = 3;

    private Symbol[][] board = new Symbol[rowLength][columnLength];

    public Board() {
        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                board[row][column] = Symbol.DEFAULT;
            }
        }
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public void setBoard(int row, int column, Symbol symbol) {
        board[row][column] = symbol;
    }

    public boolean hasMovesLeft() {
        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (board[row][column] == Symbol.DEFAULT) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean evaluate() {
        //Check rows:
        for (int row = 0; row < rowLength; row++) {
            if (board[row][0] ==  Symbol.CIRCLE && board[row][1] == Symbol.CIRCLE && board[row][2] == Symbol.CIRCLE) {
                System.out.println("Player 1 wins");
                return true;
            } else if (board[row][0] ==  Symbol.CROSS && board[row][1] == Symbol.CROSS && board[row][2] == Symbol.CROSS){
                System.out.println("Player 2 wins");
                return true;
            }
        }
        //Check columns:
        for (int col = 0; col < columnLength; col++) {
            if (board[0][col] == Symbol.CIRCLE && board[1][col] == Symbol.CIRCLE && board[2][col] == Symbol.CIRCLE) {
                System.out.println("Player 1 wins");
                return true;
            } else if (board[0][col] == Symbol.CROSS && board[1][col] == Symbol.CROSS && board[2][col] == Symbol.CROSS) {
                System.out.println("Player 2 wins");
                return true;
            }
        }
        //Check diagonals:
        if (board[0][0] == Symbol.CIRCLE && board[1][1] == Symbol.CIRCLE && board[2][2] == Symbol.CIRCLE) {
            System.out.println("Player 1 wins");
            return true;
        } else if (board[0][0] == Symbol.CROSS && board[1][1] == Symbol.CROSS && board[2][2] == Symbol.CROSS) {
            System.out.println("Player 2 wins");
            return true;
        } else if (board[0][2] == Symbol.CIRCLE && board[1][1] == Symbol.CIRCLE && board[2][0] == Symbol.CIRCLE) {
            System.out.println("Player 1 wins");
            return true;
        } else if (board[0][2] == Symbol.CROSS && board[1][1] == Symbol.CROSS && board[2][0] == Symbol.CROSS) {
            System.out.println("Player 2 wins");
            return true;
        }
        //Check tie condition:
        if (!hasMovesLeft()) {
            System.out.println("This is a tie game.");
            return true;
        }
        //Haven't finished:
        return false;
    }

    public void printBoard() {
        for (Symbol[] row : board) {
            for (Symbol c : row) {
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
