import java.util.*;

class SubarrayProductLessThanK{
    public static List<List<Integer>> findSubarrays(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        int product = 1;
        int start =0;

        for(int end = 0; i < arr.length; i++){
            product = product * arr[end];

            List<Integer> tempList = new LinkedList<>();
          for (int i = end; i >= start; i--){
            tempList.add(0, arr[i]);
            result.add(new ArrayList<>(tempList));
          }
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
      }
}