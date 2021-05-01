class HappyNumber{
    public static boolean find(int num){
        int fast = num;
        int slow = num;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        return slow == 1;
    }

    public static int findSquare(int num){
        int sum = 0;
        int digit = 0;

        while(num > 0){
            digit = num % 10;
            sum = sum + digit * digit;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(59));
        
    }
}

//Time O(LogN)
//Space O(1)

