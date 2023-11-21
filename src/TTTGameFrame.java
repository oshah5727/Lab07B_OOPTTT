import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TTTGameFrame extends JFrame {
    private JButton quitBtn;
    private TTTGame game;

    public TTTGameFrame(TTTGame game) {
        this.game = game;
        setLayout(new GridLayout(4,3));

        initializeButtons();

        JPanel quitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(new QuitButtonClickListener());
        quitPanel.add(quitBtn);

        add(new JPanel());
        add(quitPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TTTTileButton button = new TTTTileButton(i, j);
                button.addActionListener(new ButtonClickListener());
                add(button);
                game.setTileButton(i, j, button);
            }
        }
    }


    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TTTTileButton button = (TTTTileButton) e.getSource();
            int row = button.getRow();
            int col = button.getCol();

            game.handleMove(row, col);
        }
    }

    private class QuitButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
      class TTTTileButton extends JButton {
        private int row;
        private int col;

        public TTTTileButton(int row, int col) {
            this.row = row;
            this.col = col;
            setText(" ");
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public void setButtonText(String text) {
            setText(text);
        }
    }

