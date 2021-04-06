class MissingNumber{
    public static int FindMissingNumber(int[] arr){
        int length = arr.length + 1;
        
        int x1 = 1;

        for(int i = 2; i < length; i++){
            x1 = x1 ^ i;
        }

        int x2 = arr[0];
        for(int i = 1; i < length - 1; i++){
            x2 = x2 ^ i;
        }
        return x1 ^ x2;
    }

    //Time Complexity O(N)
    //Space Complexity O(1)
    
    public static void main(String[] args) {
        int[] arr = new int {1, 5, 2, 6, 4};
    }
}