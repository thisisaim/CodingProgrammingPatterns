import java.util.HashMap;
import java.util.Map;


public class PairWithTargetSum {
    public static int[] search(int[] arr, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(target - arr[i])){
                result[0] = i;
                result[1] = map.get(target - arr[i]);
            }
            map.put(arr[i], i);
        }
        return result;
    }

    public static void Main(String[] args){
        int[] result = PairWithTargetSum.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 6);
        System.out.println(("[" + result[0] + "," + result[1] + ""));
    }
}


//Time Complexity: O(n)