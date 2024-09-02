import java.util.Scanner;

public class segegrate_even_odd {
    Node head;
    
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void segregateEvenOdd() {
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node currentNode = head;
        
        while (currentNode != null) {
            int element = currentNode.data;
            
            if (element % 2 == 0) {
                if (evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            currentNode = currentNode.next;
        }
        
        if (oddStart == null || evenStart == null) {
            return;
        }
        
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
    }

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        segegrate_even_odd llist = new segegrate_even_odd();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            llist.push(value);
        }
        
        System.out.println("Original Linked List:");
        llist.printList();
        
        llist.segregateEvenOdd();
        
        System.out.println("Modified Linked List:");
        llist.printList();
        
        scanner.close();
    }
}
