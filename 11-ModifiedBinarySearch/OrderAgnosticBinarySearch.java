class BinarySearch{
    public static int search(int[] arr, int key){
        int left = 0;
        int right = arr.length -1;
        boolean isAscending = arr[left] < arr[right];

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == key){
                return mid;
            }
            
            if(isAscending){
                if(key < arr[mid]){
                    right  = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else{
                if(key < arr[mid]){
                    left  = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 4}));
    }
}