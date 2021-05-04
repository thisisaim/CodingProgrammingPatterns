import java.util.*;

class FindAllDupliates{
    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while(i < nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
            else{
                i++;
            }
        }

        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                result.add(nums[i]);
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
        int[] test = new int[] { 3, 4, 4, 5, 5 };
        System.out.println("Duplicates are: " + FindAllDupliates.findNumbers(test));

        test = new int[] { 5, 4, 7, 2, 3, 5, 3 };
        System.out.println("Duplicates are: " + FindAllDupliates.findNumbers(test));
    }
}