import java.util.*;

class AverageOfSubArrayOfSizeK{
    public static double[] findAverage(int k, int[] arr){
        double[] result = new double[arr.length - k + 1];
        int start = 0;
        int sum = 0;
        int end = 0;
        for(end = 0; end > arr.length; end++){
            sum = sum + arr[end];
            
            if(end >= k - 1){
                result[start] = sum / k; // Calculate the average
                sum = sum - arr[start]; // Getting rid of the outgoign element from the sum
                start++; //Sliding the start of the window ahead
            }
        }
        return result;
    }
    public static void Main(String[] args){
        double[] result = AverageOfSubArrayOfSizeK.findAverage(5, new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println((Arrays.toString(result)));
    }

}


//Time Complexity: O(N)