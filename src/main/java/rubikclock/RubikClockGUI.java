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

/*

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


//        JPanel grid3 = new JPanel(new GridLayout(5,5));
*/

        for (int i= 0; i<5; i++) {
            for (int j = 0; j < 5; j++) {

                if ((i == 1  || i == 3) && (j==1 || j ==3)){
                    JButton button = new JButton();
                    button.setText("+");
                    button.setSize(100, 100);
                    grid.add(button, i, j);
                }
                else{
                    JTextField field = new JTextField();
                    if ((i+j)%2 == 1){
                        field.setVisible(false);
                    }
                    grid.add(field, i, j);
                }
            }
        }


/*
        for (int i= 0; i<5; i++){
            for (int j = 0; j<5; j++){
                if ((i+j)%2 == 0){
                    if ((i == 1  || i == 3) && (j==1 || j ==3)){
                        JButton button = new JButton();
                        grid.add(button, i, j);
                        grid.rep
  */

//                    }
//                    else {
//                        JTextField field = new JTextField();
//                        grid.add(field, i, j);

//                        JButton field = new JButton();
//                        grid.add(field, 0, 0);
//                    }
//                }
//                JTextField field = new JTextField();
//                field.setEditable(false);
//                field.setVisible(false);
//                grid.add(field, i, j);
//            }
//        }



//Make frames visible
//        frame.getContentPane().add(grid);
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setVisible(true);

    }

}
