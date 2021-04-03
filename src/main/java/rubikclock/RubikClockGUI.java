package rubikclock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Defines class of the game gui
 */
public class RubikClockGUI {

    private int counter = 0;
    private JFrame frame;

    private JPanel boardPanel;

    private JPanel grid = new JPanel(new GridLayout(5,5));
    private Matrix clocks = new Matrix();

    /**
     * Method to start a new game
     */
    public void startNewGame(){
        SwingUtilities.updateComponentTreeUI(frame);
        counter = 0;
        frame.getContentPane().remove(grid);
        clocks = new Matrix();
        this.refreshGame();
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Method to update game after an event (click on button) happens
     */
    public void refreshGame(){

        this.grid = new JPanel(new GridLayout(5,5));

        for (int i= 0; i<5; i++) {
            int btncounter = 1;
            for (int j = 0; j < 5; j++) {
                if ((i == 1  || i == 3) && (j==1 || j ==3)){
                    JButton button = new JButton();
                    button.setText("+");
                    button.setFont(new Font("Arial", Font.BOLD, 20));
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setPreferredSize(new Dimension(80,50));

                    button.setName(String.valueOf(btncounter));
                    button.addActionListener(new ButtonListener(i, j));
                    this.grid.add(button, i, j);
                    btncounter ++;
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

                        int number = clocks.getMatrix()[i/2][j/2];

                        field.setText(String.valueOf(number));
                        field.setFont(new Font("Arial", Font.BOLD, 20));
                        field.setHorizontalAlignment(SwingConstants.CENTER);
                    }
                    this.grid.add(field, i, j);
                }
            }
        }
    }

    /**
     * Method to implement event action in case of a button click
     */

    public class ButtonListener implements ActionListener {

        private int i, j;
        public ButtonListener(int i, int j){

            this.i = i;
            this.j = j;
        }
        @Override
        public void actionPerformed(ActionEvent e){

            frame.getContentPane().remove(grid);
            clocks.changeMatrix(i, j);
            refreshGame();
            frame.getContentPane().add(grid);
            SwingUtilities.updateComponentTreeUI(frame);
            counter++;


            if(clocks.isFinished()){
                JOptionPane.showMessageDialog(boardPanel, "Congratulations! You won in " +counter+" steps!","Congratulations!", JOptionPane.PLAIN_MESSAGE);
                startNewGame();

            }

        }
    }

    /**
     * Constructor of the game gui
     */

    public RubikClockGUI(){

        /**
         * Creates frame elements
         */
        frame = new JFrame("Rubikclock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Creates menu items
         */

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenuItem newgameMenu = new JMenuItem("New game");
        menuBar.add(newgameMenu);
        newgameMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SwingUtilities.updateComponentTreeUI(frame);
                startNewGame();
            }
        });

        /**
         * Sets exit menu item
         */

        JMenuItem exitMenu = new JMenuItem("Exit");
        menuBar.add(exitMenu);

        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        /**
         * Method call to start a new game
         */

        this.startNewGame();

    }

}
