import java.util.*;

class AllTasksSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if(tasks <= 0) return;

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < tasks; i++) {
            indegree.put(i, 0);
            adjList.put(i, new ArrayList<>());
        }

        
    } 
}