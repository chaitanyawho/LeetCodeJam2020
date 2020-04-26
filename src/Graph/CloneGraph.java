package Graph;



import java.util.*;

/**
 * /*
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 *
 *     public Node() {
 *         val = 0;
 *         neighbors = new ArrayList<Node>();
 *     }
 *
 *     public Node(int _val) {
 *         val = _val;
 *         neighbors = new ArrayList<Node>();
 *     }
 *
 *     public Node(int _val, ArrayList<Node> _neighbors) {
 *         val = _val;
 *         neighbors = _neighbors;
 *     }
 * }
 */


public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        Queue<Node> q= new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()){//bfs and add all encountered
            Node t =q.poll();

            for(Node n: t.neighbors){
                if(!visited.containsKey(n)) {
                    Node cloneT = new Node(n.val, new ArrayList<>());
                    visited.put(n, cloneT);
                    q.add(n);
                }
                visited.get(t).neighbors.add(visited.get(n));
            }
        }
        return visited.get(node);

    }
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraphDFS(Node node) {
        visited.put(node, new Node(node.val, new ArrayList<>()));

        for(Node neighbor: node.neighbors){
            if(visited.containsKey(neighbor)){
                visited.get(node).neighbors.add(visited.get(neighbor));
            }else{
                visited.get(node).neighbors.add(cloneGraph(neighbor));
            }
        }

        return visited.get(node);
    }
    public static void main(String[] args){
        CloneGraph cg = new CloneGraph();
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        v1.neighbors.add(v2);
        v1.neighbors.add(v3);
        v2.neighbors.add(v3);
        Node t = cg.cloneGraph(v1);



    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
