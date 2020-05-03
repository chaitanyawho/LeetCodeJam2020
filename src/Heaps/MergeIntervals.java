package Heaps;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Comparator<int[]> cmp  = (Comparator<int[]>) (o1, o2) -> o1[0] - o2[0];
        Arrays.sort(intervals, cmp);
        LinkedList<int[]> m;
        m = new LinkedList<>();
        for(int[] interval : intervals){
            if(m.isEmpty() || m.getLast()[1] < interval[0])
                m.add(interval);
            else{
                m.getLast()[1] = Math.max(m.getLast()[1], interval[1]);
            }
        }
        return m.toArray(new int[m.size()][]);

    }
}
