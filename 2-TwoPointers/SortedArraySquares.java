
class SortedArraySquares{
    public static int[] makeSquares(int [] arr){
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;

        for(int j = right; j >= 0; j--){
            if(Math.abs(arr[left]) > Math.abs(arr[right])){
                result[j] = arr[left] * arr[left];
                left++;
            }
            else{
                result[j] = arr[right] * arr[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = SortedArraySquares.makeSquares(new int[] {-2, -1, 0, 2, 3});
        for(int n : test){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}