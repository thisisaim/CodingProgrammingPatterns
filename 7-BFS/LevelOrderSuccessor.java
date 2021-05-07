import java.util.*;

class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    TreeNode(int x){
        val = x;
    }
};

class LevelOrderSuccessor{
    public static TreeNode findSuccessor (TreeNode root, int key){
        if(root == null){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode currentNode = q.poll();

            if(currentNode.left != null){
                q.offer(currentNode.left);
            }

            if(currentNode.right != null){
                q.offer(currentNode.right);
            }

            if(currentNode.val == key){
                break;                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
            }
        }


        return q.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
          System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
          System.out.println(result.val + " ");
    }
}