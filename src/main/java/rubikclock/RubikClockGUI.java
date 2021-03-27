package rubikclock;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RubikClockGUI {



    private JFrame frame;

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

        RubikClockBoardGUI board = new RubikClockBoardGUI();

//Make frames visible

        frame.getContentPane().add(board.grid);
        frame.pack();
        frame.setVisible(true);
    }

    public void Calculate() {

    }

}
