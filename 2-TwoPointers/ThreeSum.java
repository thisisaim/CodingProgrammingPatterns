import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i + 2 < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int low = i + 1;
            int high = nums.length -1;
            int target = -nums[i];
            
            while(low < high){
                if(nums[low] + nums[high] == target){
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                
                    while (low < high && nums[low] == nums[low - 1]){
                        low++;
                    }
                   while (low < high && nums[high] == nums[high + 1]){
                        high--;
                    }
                }
                else if (nums[low] + nums[high] > target){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
        return result;
    }
    
  public static void main(String[] args) {
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
  }
}