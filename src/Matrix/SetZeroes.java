package Matrix;

import java.util.Arrays;

public class SetZeroes {
    public void setZeroes(int[][] matrix){
        boolean xaxis = false, yaxis = false;

        for(int i: matrix[0]) {
            if(i==0)
                xaxis = true;
        }
        for(int i = 0;i<matrix.length; i++) {
            if(matrix[i][0] == 0)
                yaxis = true;
        }

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i<matrix.length;i++){
            if(matrix[i][0]==0)
                for(int j = 1;j<matrix[0].length;j++) matrix[i][j] = 0;
        }
        for(int i = 1;i<matrix[0].length;i++){
            if(matrix[0][i]==0)
                for(int j = 1;j<matrix.length;j++) matrix[j][i] = 0;
        }
        if(xaxis)
            Arrays.fill(matrix[0], 0);
        if(yaxis)
            for(int i = 0;i<matrix.length;i++) matrix[i][0] = 0;

    }

    public static void main(String[] args) {
        int[][] m = {{0}, {1}};
        (new SetZeroes()).setZeroes(m);
        for(int i = 0;i<m.length;i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.print(m[i][j]);
            System.out.println();
        }
    }
}
