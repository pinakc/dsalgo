package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by infernus on 3/16/2019.
 */
public class BinarySearchTree {
    TreeNode root;

    private class TreeNode{
        private int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void add(int data){
        TreeNode node = new TreeNode(data);

        if(root == null){
            root = node;
            return;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while(current!=null){
            parent = current;
            if(node.data >= current.data){
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if(node.data >= parent.data)
            parent.right = node;
        else {
            parent.left = node;
        }
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
            System.out.print(" ");
            if(tmp.left!=null)
                q.offer(tmp.left);
            if(tmp.right!=null)
                q.offer(tmp.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(-5);
        bst.add(16);
        bst.add(-8);
        bst.add(7);
        bst.add(18);

        bst.bfs();


    }


}
