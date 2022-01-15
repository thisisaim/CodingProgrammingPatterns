

class RemoveDuplicates{
    public static int remove(int[] arr){
        int nextNonDuplicate = 1; 
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

    return nextNonDuplicate;
    }

    public static void main(String[] args){
        int[] test1 = new int[] {2, 3, 3, 3, 6, 9, 9};
        System.out.println(RemoveDuplicates.remove(test1));   

        int[] test2 = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(test2));   
        
        int[] test3 = new int[] { 1, 2, 3, 4 };
        System.out.println(RemoveDuplicates.remove(test3));
    }
}