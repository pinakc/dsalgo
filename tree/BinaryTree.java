package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by infernus on 3/16/2019.
 */
public class BinaryTree {

    /**
     * Strict Binary trees have strictly TWO children or none
     *
     * Full Binary tree has same number of nodes on each node. All leaf nodes should be on same level
     *
     * Complete Binary tree where leaf nodes have equal levels
     */


    private TreeNode root;

    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        STATE state;

        public TreeNode(int data) {
            this.data = data;
            this.state = STATE.NEW;
        }
    }

    private enum STATE{
        NEW,INQ,VISITED
    }

    /**
     * Creates a sample binary tree
     */
    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        root = first; //root --> first
        first.left = second;
        first.right = third;// second <-- first --> third

        second.left = fourth;
        second.right = fifth; // fourth <-- second --> fifth

        third.left = sixth;
    }

    /**
     * Level Order Traversal or BFS for binary tree
     */
    public void bfs(){
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode current = this.root;
        q.offer(current);
        while(!q.isEmpty()) {
            TreeNode tmp = q.poll();
            System.out.println(tmp.data + "--");
            if(tmp.left!=null)
                q.offer(tmp.left);
            if(tmp.right!=null)
                q.offer(tmp.right);
        }
    }

    /**
     * Depth wise traversal or branch wise traversal
     */
    public void dfs(TreeNode node){

        System.out.println(node.data + " ");
        if(node.left!=null)
            dfs(node.left);
        if(node.right!=null)
            dfs(node.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.bfs();

        bt.dfs(bt.root);
    }
}
