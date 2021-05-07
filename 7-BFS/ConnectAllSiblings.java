import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x){
        val = x;
        left = right = next = null;
    }

    public void printTree(){
        TreeNode current = null;
        System.out.println("Traversal using  next pointer: ");
        
        while(current != null){
            System.out.println(current.val + " ");
            current = current.next;
        }
    }
};

class ConnectAllSiblings{
    public static void connect(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode currentNode = null;
        TreeNode previousNode = null;

        while (!q.isEmpty()) {
            currentNode = q.poll();
            if (previousNode != null){
                previousNode.next = currentNode;
            }
            previousNode = currentNode;
      
            // insert the children of current node in the queue
            if (currentNode.left != null)
              q.offer(currentNode.left);
            if (currentNode.right != null)
              q.offer(currentNode.right);
          }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);
        root.printTree();
    }
}