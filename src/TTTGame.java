import javax.swing.JOptionPane;
public class TTTGame {
    private static final int ROW = 3;
    private static final int COL = 3;
    private int currentPlayer;
    private static int moveCnt = 0;
    private static final int MOVES_FOR_WIN = 5;
    private final int MOVES_FOR_TIE = 7;
    private TTTTileButton[][] board;

    private TTTBoard boardTiles;

    public TTTGame() {
        board = new TTTTileButton[ROW][COL];
        boardTiles = new TTTBoard();
        currentPlayer = 1;
    }

    public void setTileButton(int row, int col, TTTTileButton button) {
        boardTiles.setTileButton(row, col, button);
    }

    public void handleMove(int row, int col) {
        if (isValidMove(row, col)) {
            boardTiles.setButtonText(row, col, currentPlayer == 1 ? "X" : "O");
            moveCnt++;

            if (isWin()) {
                JOptionPane.showMessageDialog(null, "Player " + (currentPlayer == 1 ? "X" : "O") + " wins!");
                resetGame();
            } else if (isTie()) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                resetGame();
            } else {
                switchPlayer();
            }
            }
        else {
            JOptionPane.showMessageDialog(null, "Invalid move! Try again.");
        }
    }

    private boolean isValidMove(int row, int col) {
        return boardTiles.getButtonText(row, col).equals(" ") && !isWin() && !isTie();
    }

    private boolean isWin() {
        if (moveCnt < MOVES_FOR_WIN) {
            return false;
        }

        return isColWin("X") || isRowWin("X") || isDiagonalWin("X") ||
                isColWin("O") || isRowWin("O") || isDiagonalWin("O");
    }

    private boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (boardTiles.getButtonText(0, col).equals(player) &&
                    boardTiles.getButtonText(1, col).equals(player) &&
                    boardTiles.getButtonText(2, col).equals(player))  {
                return true;
            }
        }
        return false;
    }

    private boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (boardTiles.getButtonText(row, 0).equals(player) &&
                    boardTiles.getButtonText(row, 1).equals(player) &&
                    boardTiles.getButtonText(row, 2).equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin(String player) {
        return (boardTiles.getButtonText(0, 0).equals(player)  &&
                boardTiles.getButtonText(1, 1).equals(player) &&
                boardTiles.getButtonText(2, 2).equals(player))  ||
                (boardTiles.getButtonText(0, 2).equals(player) &&
                        boardTiles.getButtonText(1, 1).equals(player) &&
                        boardTiles.getButtonText(2, 0).equals(player));
    }

    private boolean isTie() {
        return (moveCnt == ROW * COL && !isWin()) || (moveCnt >= MOVES_FOR_TIE && isFull());
    }

    private boolean isFull() {
        return moveCnt >= ROW * COL;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }


    private void resetGame() {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            moveCnt = 0;
            currentPlayer = 1;
            boardTiles.clearBoard();
        }
        else {
            System.exit(0);
        }
    }
}

