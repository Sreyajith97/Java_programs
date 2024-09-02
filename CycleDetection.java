class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class CycleDetection {
  public boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) {
          return false; // No cycle if the list is empty or has only one node
      }

      ListNode tortoise = head;
      ListNode hare = head;

      while (hare != null && hare.next != null) {
          tortoise = tortoise.next; // Tortoise moves one step
          hare = hare.next.next; // Hare moves two steps

          // If hare and tortoise meet, there's a cycle
          if (hare == tortoise) {
              return true;
          }
      }

      // If hare reaches the end of the list, no cycle exists
      return false;
  }

  public static void main(String[] args) {
      // Example usage:
      ListNode head = new ListNode(3);
      head.next = new ListNode(2);
      head.next.next = new ListNode(0);
      head.next.next.next = new ListNode(-4);
      // Creating a cycle
      head.next.next.next.next = head.next;

      CycleDetection cycleDetection = new CycleDetection();
      System.out.println("Does the list have a cycle? " + cycleDetection.hasCycle(head));
  }
}


