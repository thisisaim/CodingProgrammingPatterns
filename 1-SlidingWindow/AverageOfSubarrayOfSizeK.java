import java.util.Arrays;

class AverageOfSubarrayOfSizeK {
  public static double[] findAverages(int K, int[] arr) {
    double[] result = new double[arr.length - K + 1];
    double windowSum = 0;
    int left = 0;
    for (int right = 0; right < arr.length; right++) {
      windowSum += arr[right]; // add the next element
      // slide the window, we don't need to slide if we've not hit the required window
      // size of 'k'
      if (right >= K - 1) {
        result[left] = windowSum / K; // calculate the average
        windowSum -= arr[left]; // subtract the element going out
        left++; // slide the window ahead
      }
    }
    return result;
  }

  public static void main(String[] args) {
    double[] result = AverageOfSubarrayOfSizeK.findAverages(8, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
  }
}
