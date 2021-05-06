import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
};

class LevelAverage{
    public static List<Double> findLevelAverages(TreeNode root){
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            double levelSum = 0;

            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = q.poll();
                levelSum = levelSum + currentNode.val;

                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }
                
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }

            }
        
            result.add(levelSum / levelSize);

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
      }

}