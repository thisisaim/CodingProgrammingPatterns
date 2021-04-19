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
        int maxSum = 0;
        int windowSum =0;
        int start = 0

        for(int end = 0; end < arr.length; end++){
            windowSum = windowSum + arr[end];
            if(windowSum >= k -1){
                maxSum = Math.max(maxSum, windowSum);
                windowSum = windowSum - arr[start];
                start++;
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