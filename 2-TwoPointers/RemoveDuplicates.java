class RemoveDuplicates{
    public static int remove(int[] arr){
        int i = 0;

        if(arr.length == 0){
            return 0;
        }

        for(int j = 1; j < arr.length; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+ 1;
    }

    public static void main(String[] args){
     int[] test1 = new int[] {2, 3, 3, 3, 6, 9, 9};
     System.out.println(RemoveDuplicates.remove(test1));   

     int[] test2 = new int[] { 2, 2, 2, 11 };
     System.out.println(RemoveDuplicates.remove(test2));   
    }
}