class DutchFlag{
    public static void sort(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                swap(arr, i, left);
                i++;
                left++;
            }
            else if (arr[i] == 1){
                i++;
            }
            else{
                swap(arr, i, right);
                right--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        for(int num : arr){
            System.out.print(num + " ");
            System.out.println();
        }

        int arr1[] = new int[] {2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr1);
        for(int num : arr1){
            System.out.print(num + " ");
            System.out.println();
        }
         
    }
}