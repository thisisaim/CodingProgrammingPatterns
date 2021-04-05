import java.util.PriorityQueue;

class MedianOfAStream {
    PriorityQueue<Integer> maxHeap; //Containing first half of numbers
    PriorityQueue<Integer> minHeap; //Containing second half of numbers
    public MedianOfAStream(){
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    public void insertNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
        
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian(){
        if(minHeap.size() == maxHeap.size()){
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return minHeap.peek();
    }

    public static void main(String[] args){
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
