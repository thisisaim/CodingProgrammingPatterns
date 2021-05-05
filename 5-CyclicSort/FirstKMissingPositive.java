import java.util.*;

class FirstKMissingPositive{
    public static List<Integer> findNumbers(int[] nums, int k){
        int i = 0;
        
        while (i < nums.length){
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
            else{
                i++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();
        for (i = 0; i < nums.length && result.size() < k; i++)
            if (nums[i] != i + 1) {
                result.add(i + 1);
                extraNumbers.add(nums[i]);
            }
        
        for (i = 1; result.size() < k; i++){
            int candidateNum = i + nums.length;

            if(!extraNumbers.contains(candidateNum)){
                result.add(candidateNum);
            }
        }
        return result;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);
    
        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);
    
        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
      }
}