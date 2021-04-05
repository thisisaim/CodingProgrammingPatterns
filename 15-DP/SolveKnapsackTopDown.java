class Knapsack{
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][weights.length + 1];

        return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    public static int knapsackRecursive(Integer[][] dp, int profits, int[] weights, int capacity, int currentIndex){
        if(capacity <= 0 || currentIndex >= profits.length){
            return 0;
        }

        if(dp[currentIndex][capacity] != null){
            return dp[currentIndex][capacity];
        }

        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
        profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }
//Time O(N * C), N = number of items, C = knapsack  capacity
//Space  O(N * C)
    public static void main(String[] args) {
        Knapsack ks = new Knapsack()
        int[] profits = new int {1, 6, 10, 16};
        int[] weights = new int {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total Knapsack profits: " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total Knapsack profits: " + maxProfit);
        
    }
}