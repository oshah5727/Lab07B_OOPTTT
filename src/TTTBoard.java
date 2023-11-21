public class TTTBoard {
    private TTTTileButton[][] tiles;
    public TTTBoard() {
        tiles = new TTTTileButton[3][3];
    }
    public void setTileButton(int row, int col, TTTTileButton button) {
        tiles[row][col] = button;
    }
    public String getButtonText(int row, int col) {
        return tiles[row][col].getText();
    }
    public void setButtonText(int row, int col, String text) {
        tiles[row][col].setButtonText(text);
    }
    public void clearBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].setButtonText(" ");
            }
        }
    }
}
