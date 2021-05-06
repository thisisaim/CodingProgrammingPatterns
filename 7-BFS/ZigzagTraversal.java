import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
};

class ZigzagTraversal{
    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> currentLevel = new LinkedList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = q.poll();

                if(leftToRight){
                    currentLevel.add(currentNode.val);
                }
                else{
                    currentLevel.add(0, currentNode.val);
                }
                
                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}