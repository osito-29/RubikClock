package rubikclock;

import javax.swing.*;
import java.awt.*;

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
        JPanel grid = new JPanel(new GridLayout(5,5));
//        grid.add(new JButton(), 0, 1);



        JPanel boardPanel = new JPanel();

        for (int i= 0; i<5; i++){
            for (int j = 0; j<5; j++){
                JTextField field = new JTextField();
                grid.add(field, i, j);
            }
        }

        JPanel grid2 = new JPanel(new GridLayout(5,5));

        for (int i= 0; i<5; i+=2){
            for (int j = 0; j<5; j++){
                JButton button = new JButton();
                grid2.add(button, i, j);
            }
        }



//Make frames visible
//        frame.getContentPane().add(grid);
        frame.getContentPane().add(grid2);
        frame.pack();
        frame.setVisible(true);

    }

}
