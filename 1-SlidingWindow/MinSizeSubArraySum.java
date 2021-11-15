/*
Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].

Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Input: [3, 4, 1, 1, 6], S=8 
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] 
or [1, 1, 6].

*/

class MinSizeSubArraySum{
    public static int findMinSubArraySum(int s, int[] arr) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < arr.length; right++) {
            sum = sum + arr[right];
            while(sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - arr[left];
                left++;
            }
        }
        return minLength;
    }
        
    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArraySum(7, new int[] {2, 1, 5, 2, 3, 2});
        System.out.println("Smallest Subarray Length: " + result );
        result = MinSizeSubArraySum.findMinSubArraySum(7, new int[] {2, 1, 5, 2, 8});
        System.out.println("Smallest Subarray Length: " + result );
        result = MinSizeSubArraySum.findMinSubArraySum(8, new int[] {3, 4, 1, 1, 6});
        System.out.println("Smallest Subarray Length: " + result );
    }
}

//Time O(N + N) => O(N)
//Space O(1)