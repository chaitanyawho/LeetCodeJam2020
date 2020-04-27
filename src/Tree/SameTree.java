package Tree;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inOrder(p, q);
    }
    private boolean inOrder(TreeNode p, TreeNode q){
        System.out.println(p.val +" "+ q.val);
        if(p==null || q==null)
            return (p == null && q == null);

        boolean result;
        result = inOrder(p.left, q.left);
        result = result & (p.val==q.val);
        result = result & inOrder(p.right, p.right);
        System.out.println("res:" + result);
        return result;
    }
    public static void main(String[] args){
        TreeNode s = new TreeNode(10);
        s.left = new TreeNode(5);
        s.right = new TreeNode(15);
        TreeNode t = new TreeNode(10);
        t.left = new TreeNode(5);
        t.right = null;
        SameTree st = new SameTree();
        System.out.println(st.isSameTree(s, t));

    }


}
