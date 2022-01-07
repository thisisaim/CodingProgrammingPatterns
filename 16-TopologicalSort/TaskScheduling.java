import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<Integer>();
        if(tasks <= 0) {
            return false;
        }

        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        
        // initialze indegree and  adjacency list
        for(int i = 0; i < tasks; i++) {
            indegree.put(i, 0);
            adjList.put(i, new ArrayList<>());
        }

        //build the graph
        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            adjList.get(parent).add(child);
            indegree.put(child, indegree.get(child )+ 1);
        }

        // find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }
        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while(!q.isEmpty()) {
            int vertex = q.poll();
            sortedOrder.add(vertex);
            List<Integer> children = adjList.get(vertex);// get the node's children to decrement their in-degrees
            for(int child : children) {
                indegree.put(child, indegree.get(child) - 1);
                if(indegree.get(child) == 0) {
                    q.add(child);
                }
            }
        }
        // if sortedOrder doesn't contain all tasks, there is a cyclic dependency between tasks, therefore, we
        // will not be able to schedule all tasks
        return sortedOrder.size() == tasks;
    }
    public static void main(String[] args) {
        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
        new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
