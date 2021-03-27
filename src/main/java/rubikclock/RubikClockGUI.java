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
        JPanel grid = new JPanel(new GridLayout(5,5));

        Random random = new Random();

        for (int i= 0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i == 1  || i == 3) && (j==1 || j ==3)){
                    JButton button = new JButton();
                    button.setText("+");
                    button.setFont(new Font("Arial", Font.BOLD, 20));
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setPreferredSize(new Dimension(80,50));
                    grid.add(button, i, j);
                }
                else{
                    JTextField field = new JTextField();
                    if ((i+j)%2 == 1){
                        field.setPreferredSize(new Dimension(80, 50));
                        field.setVisible(false);
                    }
                    else{
                        field.setPreferredSize(new Dimension(100, 70));
                        field.setEditable(false);
                        int randnumber = random.nextInt(12)+1;

                        field.setText(String.valueOf(randnumber));
                        field.setFont(new Font("Arial", Font.BOLD, 20));
                        field.setHorizontalAlignment(SwingConstants.CENTER);
                    }
                    grid.add(field, i, j);
                }
            }
        }

//Make frames visible
//        frame.getContentPane().add(grid);
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setVisible(true);

    }

}
