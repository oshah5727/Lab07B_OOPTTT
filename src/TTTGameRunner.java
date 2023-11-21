import javax.swing.*;

public class TTTGameRunner {
    public static void main(String[] args) {
        TTTGameFrame tttGameFrame = new TTTGameFrame(new TTTGame());
        tttGameFrame.setTitle("OOP Tic Tac Toe Game");
        tttGameFrame.setSize(800,800);
        tttGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tttGameFrame.setVisible(true);
    }
}