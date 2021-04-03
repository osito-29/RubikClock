package rubikclock;

import java.util.Random;

/**
 * Defines the matrix class of the clocks in the game
 */
public class Matrix {
    private int mtx [][] = new int[3][3];
    Random random = new Random();

    /**
     * Class constructor to create the matrix and fill it with random numbers from 1-12
     */
    public Matrix(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                this.mtx[i][j] = random.nextInt(12)+1;
            }
        }
    }

    /**
     * Getter of the matrix class
     */
    public int[][] getMatrix() {
        return mtx;
    }

    /**
     * Increases the matrix values, specified by the clicked button
     */

    public void changeMatrix (int i, int j) {
        mtx[i/2][j/2] = mtx[i/2][j/2]%12 +1;
        mtx[i/2][(j/2)+1] = mtx[i/2][(j/2)+1]%12 +1;
        mtx[(i/2)+1][j/2] = mtx[(i/2)+1][j/2]%12 +1;
        mtx[(i/2)+1][(j/2)+1] = mtx[(i/2)+1][(j/2)+1]%12 +1;
    }

    /**
     * Method checks if all element of the matrix is 12, so the game is ended or not
     *
     */

    public boolean isFinished(){
        boolean finished = true;
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if (this.mtx[i][j] !=12){
                    finished = false;
                }
            }
        }
        return finished;
    }
}
