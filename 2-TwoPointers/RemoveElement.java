

class RemoveElement{
    public static int remove(int[] arr, int key){
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != key){
                arr[j] = arr[i];
                j++;
            }
        }
        return  j;
    }

    public static void main(String[] args) {
        int[] test1 = new int[] {3, 2, 3, 6, 3, 10, 9, 3};
        int key1 = 3;
        System.out.println(RemoveElement.remove(test1, key1));

        int[] test2 = new int[] { 2, 11, 2, 2, 1 };
        int key2 = 2;
        System.out.println(RemoveElement.remove(test2, key2));
    }
}