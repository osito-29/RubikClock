package rubikclock;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RubikClockBoardGUI {

    public JPanel grid = new JPanel(new GridLayout(5,5));
    public static Matrix clocks = new Matrix();

    public RubikClockBoardGUI(){

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
                    button.addActionListener(new RubikClockGUI.ButtonListener(i, j));
                    grid.add(button, i, j);
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
                    grid.add(field, i, j);
                }
            }
        }

    }
/*
    class ButtonListener implements ActionListener{

        private int i, j;
        public ButtonListener(int i, int j){


            this.i = i;
            this.j = j;
        }
        @Override
        public void actionPerformed(ActionEvent e){

            clocks.changeMatrix(i, j);
            System.out.println("Klikk "+ "i: " + i +"j: "+ j);

            System.out.println(clocks.getMatrix()[0][0]);


            JTextField field = new JTextField();

            int number = clocks.getMatrix()[0][0];

            field.setText(String.valueOf(number));
            grid.add(field, 0,0);

//            RubikClockGUI gui2 = new RubikClockGUI();


//            gui2.frame.getContentPane().add(board.grid);
//            gui2.frame.remove(gui2.board);

        }
    }
*/

}