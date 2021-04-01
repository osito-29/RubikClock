package rubikclock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RubikClockGUI {

    public static JFrame frame;
    public static RubikClockBoardGUI board;

    public static JPanel boardPanel;

    public RubikClockGUI(){

//Create frame elements
        frame = new JFrame("Rubikclock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//Create menu items
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenuItem newgameMenu = new JMenuItem("New game");
        menuBar.add(newgameMenu);

        newgameMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.remove(board.grid);
                board = new RubikClockBoardGUI();
                board.clocks = new Matrix();
                frame.getContentPane().add(board.grid);
                SwingUtilities.updateComponentTreeUI(frame);
                frame.pack();
                frame.setVisible(true);
            }
        });

        JMenuItem exitMenu = new JMenuItem("Exit");
        menuBar.add(exitMenu);

        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });



//Create game board

        board = new RubikClockBoardGUI();

//Make frames visible

        frame.getContentPane().add(board.grid);
        frame.pack();
        frame.setVisible(true);

//Setup exit button action

    }


    static class ButtonListener implements ActionListener {

        private int i, j;
        public ButtonListener(int i, int j){

            this.i = i;
            this.j = j;
        }
        @Override
        public void actionPerformed(ActionEvent e){

            RubikClockBoardGUI.clocks.changeMatrix(i, j);

            frame.remove(board.grid);

            board = new RubikClockBoardGUI();

            frame.getContentPane().add(board.grid);

            SwingUtilities.updateComponentTreeUI(frame);

//            board.clocks.isFinished() = true;

            if(true){
                JOptionPane.showMessageDialog(boardPanel, "Congartulations! You won the game!","Congratulations!", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

}
