import java.util.*;

class ListNode{
    int value;
    ListNode next;

    ListNode(int value){
        this.value = value;
    }
}

class MergeKSortedLists{
    public static ListNode merge(ListNode[] lists){
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> a.value - b.value);

        for(ListNode list : lists){
            while(list != null){
                minHeap.add(list);
            }
        }

        ListNode resultHead = null;
        ListNode resultTail = null;

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if(resultHead == null){
                resultTail = node;
                resultHead = resultTail;
            }
            else{
                resultTail.next = node;
                resultTail = resultTail.next;
            }

            if(node.next != null){
                minHeap.add(node.next);
            }
        }
        return resultHead;
    }
//Time Complexity O(N LogK), N = Number of elements, K = number of input arrays
//Space Complexity O(K)

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] {l1, l2, l3});
        System.out.print("Merged List: ");
        while(result != null){
            System.out.print(result.value + " ");
            result = result.next;
        }

    }
}