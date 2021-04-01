package rubikclock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RubikClockGUI {

    public static JFrame frame;
    public static RubikClockBoardGUI board;

    public RubikClockGUI(){

//Create frame elements
        frame = new JFrame("Rubikclock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//Create menu items
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu newgameMenu = new JMenu("New game");
        menuBar.add(newgameMenu);
        JMenu exitMenu = new JMenu("Exit");
        menuBar.add(exitMenu);

//Create game board

        board = new RubikClockBoardGUI();

//Make frames visible

        frame.getContentPane().add(board.grid);
        frame.pack();
        frame.setVisible(true);
    }

    public void Calculate() {

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

//            System.out.println("Klikk "+ "i: " + i +"j: "+ j);

//            System.out.println(RubikClockBoardGUI.clocks.getMatrix()[0][0]);

//            int number = RubikClockBoardGUI.clocks.getMatrix()[0][0];

            frame.remove(board.grid);
//            frame.remove()

//            SwingUtilities.updateComponentTreeUI(frame);

            board = new RubikClockBoardGUI();

            frame.getContentPane().add(board.grid);

            SwingUtilities.updateComponentTreeUI(frame);

        }
    }

}
