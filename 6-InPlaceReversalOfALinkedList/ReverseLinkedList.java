class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
      this.value = value;
    }
  }
  
  class ReverseLinkedList {
  
    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
    
        while(current != null){
            next = current.next; //temporarily store the next node
            current.next = prev; // reverse the current node
            prev = current; // before moving on to the next node, point the previous to the current node
            current = next; // move on to the next node
        }
        return head;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(2);
      head.next = new ListNode(4);
      head.next.next = new ListNode(6);
      head.next.next.next = new ListNode(8);
      head.next.next.next.next = new ListNode(10);
  
      ListNode result = ReverseLinkedList.reverse(head);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
        System.out.print(result.value + " ");
        result = result.next;
      }
    }
  }