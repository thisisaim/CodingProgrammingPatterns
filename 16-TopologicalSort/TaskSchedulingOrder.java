import java.util.*;
class TaskSchedulingOrder {
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if(tasks <= 0) {
            return sortedOrder;
        }
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < tasks; i++) {
            indegree.put(i, 0);
            adjList.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            adjList.get(parent).add(child);
            indegree.put(child, indegree.get(child) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet() ) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        while(!q.isEmpty()) {
            int vertex = q.poll();
            sortedOrder.add(vertex);
            List<Integer> children = adjList.get(vertex);
            for(int child : children) {
                indegree.put(child, indegree.get(child) - 1);
                if(indegree.get(child) == 0) {
                    q.add(child);
                }
            }
        }
        if(sortedOrder.size() != tasks) {
            return new ArrayList<>();
        }
        return sortedOrder;
    }
    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
        new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println(result);
    }
}
