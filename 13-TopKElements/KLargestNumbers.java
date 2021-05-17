import java.util.*;

class KLargestNumbers{
    public static List<Integer> FindKLargestNumbers(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        
        //Load all the numbers in nums into minHeap
        for(int i = 0; i < k; i++){
            minHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }
//Time Complexity O(N LogK)
//Space Complexity O(K)
    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.FindKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    
        result = KLargestNumbers.FindKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
      }
}