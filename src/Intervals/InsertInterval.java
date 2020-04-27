package Intervals;

import java.util.ArrayList;
import java.util.Collections;

class Interval implements Comparable<Interval>{
    int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public int compareTo(Interval b){
        if(this.start<b.start) return -1;
        else if(this.start>b.start) return 1;
        else return 0;
    }
    public String toString(){
        return "[" + start + "," + end + "]";
    }
}
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Interval> arr = new ArrayList<>();
        for(int[] interval : intervals){
            arr.add(new Interval(interval[0], interval[1]));
        }
        if(arr.isEmpty()) return new int[][]{{newInterval[0], newInterval[1]}};
        Interval ins = new Interval(newInterval[0], newInterval[1]);
        int newStart = -1, newEnd = -1;
        ArrayList<Interval> toRemove = new ArrayList<>();
        for(Interval i: arr){
            if(i.end < ins.start || i.start > ins.end) {
                continue;
            }
            toRemove.add(i);
            if(newStart == -1) newStart = Math.min(i.start, ins.start); //first time
            else newStart = Math.min(i.start, newStart);
            if(newEnd == -1) newEnd = Math.max(i.end, ins.end);
            else newEnd = Math.max(i.end, newEnd);
        }
        arr.removeAll(toRemove);
        if(toRemove.isEmpty())
            arr.add(ins);
        if(newStart!=newEnd) arr.add(new Interval(newStart, newEnd));
        Collections.sort(arr);
        System.out.println(arr);
        int[][] ret = new int[arr.size()][2];
        int k = 0;
        for(Interval i: arr){
            ret[k][0] = i.start;
            ret[k++][1] = i.end;
        }
        return ret;
    }

    public int[][] insertBINSEARCH(int[][] intervals, int[] newInterval) {
        ArrayList<Interval> arr = new ArrayList<>();
        for(int[] interval : intervals){
            arr.add(new Interval(interval[0], interval[1]));
        }
        if(arr.isEmpty()) return new int[][]{{newInterval[0], newInterval[1]}};
        Interval ins = new Interval(newInterval[0], newInterval[1]);
        int newStart = -1, newEnd = -1;
        ArrayList<Interval> toRemove = new ArrayList<>();
        //BINSEARCH TO FIND OVERLAPPING INTERVALS

        int low = 0, high = arr.size()-1;
        while(low<high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid).start >= ins.start)
                high = mid;
            else low = mid+1;
        }
        int p = Math.max(0, high-1);//start overlapping intervals from here
        System.out.println(p);



        for(int j = p; j < arr.size() && !(arr.get(j).start>ins.end)  ;j++){
            Interval i = arr.get(j);
            if(i.end < ins.start || i.start > ins.end) {
                continue;
            }
            toRemove.add(i);
            if(newStart == -1) newStart = Math.min(i.start, ins.start); //first time
            else newStart = Math.min(i.start, newStart);
            if(newEnd == -1) newEnd = Math.max(i.end, ins.end);
            else newEnd = Math.max(i.end, newEnd);
        }
        arr.removeAll(toRemove);
        if(toRemove.isEmpty())
            arr.add(ins);
        if(newStart!=newEnd) arr.add(new Interval(newStart, newEnd));
        Collections.sort(arr);
        System.out.println(arr);
        int[][] ret = new int[arr.size()][2];
        int k = 0;
        for(Interval i: arr){
            ret[k][0] = i.start;
            ret[k++][1] = i.end;
        }
        return ret;
    }
    public static void main(String args[]){
        InsertInterval insi = new InsertInterval();
        int[][] in = new int[][]{{1,3}, {4, 6}, {7, 10}, {11, 16}, {19, 22}};
        int[] ins = new int[]{8, 15};
        in = insi.insert(in, ins);
        in = insi.insertBINSEARCH(in, ins);
        System.out.println(in);
    }

}
