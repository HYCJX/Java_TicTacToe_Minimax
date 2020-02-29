public class AI implements DecisionMaker {

  @Override
  public void play(Symbol symbol, Board playBoard) {
    int bestValue = -1000;
    int row = -1;
    int column = -1;
    Symbol[][] board = playBoard.getBoard();
    for (int i = 0; i < Board.rowLength; i++) {
      for (int j = 0; j < Board.columnLength; j++) {
        if (board[i][j].equals(Symbol.DEFAULT)) {
          playBoard.setBoard(i, j, symbol);
          int value = minimax(symbol, playBoard, 0, false);
          playBoard.setBoard(i, j, Symbol.DEFAULT);
          if (value > bestValue) {
            row = i;
            column = j;
            bestValue = value;
          }
        }
      }
    }
    playBoard.setBoard(row, column, symbol);
  }

  // The implementation of the minimax algorithm:
  private int minimax(Symbol symbol, Board playBoard, int depth, boolean isMax) {
    // Determine opponent symbol:
    Symbol opponentSymbol;
    if (symbol.equals(Symbol.CIRCLE)) {
      opponentSymbol = Symbol.CROSS;
    } else {
      opponentSymbol = Symbol.CIRCLE;
    }
    // Evaluate moves:
    Symbol[][] board = playBoard.getBoard();
    // Evaluate current situation:
    int score = evaluate(symbol, board);
    // Base case - the board is full:
    if (score == 10 || score == -10 || !playBoard.hasMovesLeft()) {
      return score;
    }
    // Recursive evaluationsL
    int result;
    if (isMax) {
      // Maximiser branch:
      result = -1000;
      for (int row = 0; row < Board.rowLength; row++) {
        for (int column = 0; column < Board.columnLength; column++) {
          if (board[row][column].equals(Symbol.DEFAULT)) {
            playBoard.setBoard(row, column, symbol);
            result = Math.max(result, minimax(symbol, playBoard, depth + 1, false));
            playBoard.setBoard(row, column, Symbol.DEFAULT);
          }
        }
      }
    } else {
      // Minimiser branch:
      result = 1000;
      for (int row = 0; row < Board.rowLength; row++) {
        for (int column = 0; column < Board.columnLength; column++) {
          if (board[row][column].equals(Symbol.DEFAULT)) {
            playBoard.setBoard(row, column, opponentSymbol);
            result = Math.min(result, minimax(symbol, playBoard, depth + 1, true));
            playBoard.setBoard(row, column, Symbol.DEFAULT);
          }
        }
      }
    }
    return result;
  }

  // Evaluation heuristics:
  private int evaluate(Symbol symbol, Symbol[][] board) {
    Symbol opponentSymbol;
    if (symbol.equals(Symbol.CIRCLE)) {
      opponentSymbol = Symbol.CROSS;
    } else {
      opponentSymbol = Symbol.CIRCLE;
    }
    // Check rows:
    for (int row = 0; row < Board.rowLength; row++) {
      if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
        return 10;
      } else if (board[row][0] == opponentSymbol
          && board[row][1] == opponentSymbol
          && board[row][2] == opponentSymbol) {
        return -10;
      }
    }
    // Check columns:
    for (int col = 0; col < Board.columnLength; col++) {
      if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol) {
        return 10;
      } else if (board[0][col] == opponentSymbol
          && board[1][col] == opponentSymbol
          && board[2][col] == opponentSymbol) {
        return -10;
      }
    }
    // Check diagonals:
    if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
      return 10;
    } else if (board[0][0] == opponentSymbol
        && board[1][1] == opponentSymbol
        && board[2][2] == opponentSymbol) {
      return -10;
    } else if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
      return 10;
    } else if (board[0][2] == opponentSymbol
        && board[1][1] == opponentSymbol
        && board[2][0] == opponentSymbol) {
      return -10;
    }
    return 0;
  }
}
