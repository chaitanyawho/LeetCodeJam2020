package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //dfs, check for back edges to determine if it is cyclic
        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
        for(int i = 0;i < numCourses ; i++)
            adjList.put(i, new LinkedList<>());
        for (int[] edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
        }

        HashSet<Integer> recStk = new HashSet<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        boolean ret = true;
        for(int i = 0;i<numCourses;i++){
            if(dfs(i, adjList, visited, recStk))
                return true;
        }
        return false;


    }
    private boolean dfs(int v, HashMap<Integer, LinkedList<Integer>> adjList, HashSet<Integer> visited, HashSet<Integer> recStk){
        if(recStk.contains(v)) return false;
        if(visited.contains(v)) return true;//no problem here
        visited.add(v);
        recStk.add(v);
        for(int n : adjList.get(v)){
            if(dfs(n, adjList, visited, recStk))
                return true;
        }
        recStk.remove(v);
        return false;

    }
    public static void main(String[] args){
        CourseSchedule cs = new CourseSchedule();
        int[][] pr = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {2, 4},
                {4, 3}
        };
        System.out.println(cs.canFinish(5, pr));
    }

}
