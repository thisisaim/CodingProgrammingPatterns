import java.util.*;

class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));

        for(int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.poll();
    }

    public static void main(String[] args){
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] {1, 5, 12, 2, 11, 5}, 3);
        System.out.println("Kth Smallest Number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);  
    }
}