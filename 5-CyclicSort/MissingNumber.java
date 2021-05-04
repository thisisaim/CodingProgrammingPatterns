class MissingNumber{
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] < nums.length  && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }
            else{
                i++;
            }
        }
        
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public static int missingNumber(int[] nums){
        int xor = 0;
        int i = 0;

        for(i = 0; i < nums.length; i++){
            xor = xor ^ i ^ nums[i];
        }
        return i ^ xor;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        System.out.println("Cyclic Sort: ");
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
        System.out.println();
        System.out.println("Bitwise XOR: ");
        System.out.println(MissingNumber.missingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.missingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
      }
}