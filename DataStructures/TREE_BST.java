//JAVA DOESNT HAVE A SPECIFIC TREE UTIL TO IMPORT 
//USES TREEMAP WHICH HAS KEYVALUE PAIRS THAT ACT AS NODES AND THE VALUE OF THE NODE

import java.util.LinkedList;
import java.util.Queue;

public class TREE_BST {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        tree.levelorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


class BinaryTree
{
    //PRE ORDER TRAVERSAL (ROOT --> LEFT --> RIGHT) OR YOU START AT ROOT AND "TOUCH" EACH ONE ONCE
    public void preorder(TreeNode root)
    {
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //IN ORDER TRAVERSAL (LEFT --> ROOT --> RIGHT) OR YOU START AT ROOT AND "TOUCH" EACH ONE TWICE
    public void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    //POST ORDER TRAVERSAL (LEFT --> RIGHT --> ROOT) OR YOU START AT ROOT AND "TOUCH" EACH ONE 3 TIMES 
    public void postorder(TreeNode root)
    {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");  
    }

    //LEVEL ORDER TRAVERSAL USING QUEUE (BFS)
    public void levelorder(TreeNode root)
    {
        if(root == null) return;

        //Queue to manage the BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);                                      //enqueue the root or add to the back 
        
        while(!queue.isEmpty())
        {
            TreeNode current = queue.poll();                    //dequeue
            System.out.print(current.val + " ");

            if(current.left != null) queue.offer(current.left);         //enqueue the left child
            if(current.right != null) queue.offer(current.right);       //enqueue the right child
        }
    }

}