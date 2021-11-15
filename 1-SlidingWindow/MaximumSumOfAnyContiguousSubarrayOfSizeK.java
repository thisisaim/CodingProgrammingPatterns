/*
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.3

Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].

*/

class MaximumSumSubArrayOfSizeK{
    public static int MaxSumSubArray(int[] arr, int k){
        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for(int right = 0; right < arr.length; right++) {
            sum = sum + arr[right];
            if(right >= k - 1) {
                maxSum = Math.max(sum, maxSum);
                sum = sum - arr[left];
                left++;
            }

        }
        return maxSum;
    }

    public static void main(String[] args){
        System.out.println("Maximum sum of a subarray of size K: "
        + MaximumSumSubArrayOfSizeK.MaxSumSubArray(new int[] {2, 1, 5, 1, 3, 2}, 3));
        System.out.println("Maximum sum of a subarray of size K: "
        + MaximumSumSubArrayOfSizeK.MaxSumSubArray(new int[] {2, 3, 4, 1, 5}, 2));
    }
}

//Time: O(N)
//Space: O(1)