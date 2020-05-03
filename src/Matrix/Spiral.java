package Matrix;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length;
        if(bottom == 0) return new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        //for each set of top-right-bottom-left print then shrink
        for(;top<bottom && left <right;){
            for(int i = left; i < right ; i ++)
                list.add(matrix[top][i]);
            top++;
            for(int i = top ; i < bottom ; i++)
                list.add(matrix[i][right-1]);
            right--;
            for(int i = right-1;i>left-1 && top!=bottom;i--)
                list.add(matrix[bottom-1][i]);
            bottom--;
            for(int i = bottom-1 ; i > top-1 && left!=right; i--)
                list.add(matrix[i][left]);
            left++;
        }

        return list;
    }
    public static void main(String[] args){
        int[][] m = new int[][]{{1}, {2}, {3}, {4}

                                };
        Spiral o = new Spiral();
        o.spiralOrder(m);
    }

}
