package rubikclock;

import javax.swing.*;
import java.util.Random;

public class Matrix {
    private int mtx [][] = new int[3][3];
    Random random = new Random();

    public Matrix(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                this.mtx[i][j] = random.nextInt(12)+1;
            }
        }
    }

    public int[][] getMatrix() {
        return mtx;
    }

    public void changeMatrix (int i, int j) {
        mtx[i/2][j/2] +=1;
        mtx[i/2][(j/2)+1] +=1;
        mtx[(i/2)+1][j/2] +=1;
        mtx[(i/2)+1][(j/2)+1] +=1;
    }
}
