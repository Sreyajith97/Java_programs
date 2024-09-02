class mergesortdll {
    static class Node{  
        int data;  
        Node prev;  
        Node next;  
   
        public Node(int data) {  
            this.data = data;  
        }  
    }  
   
    static Node head,tail = null;  
   
    public static Node addNode(int item) {  
        Node newNode = new Node(item);  
   
        if(head == null) {  
            head = tail = newNode;  
            head.prev = null;  
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;  
            newNode.prev = tail;  
            tail = newNode;  
            tail.next = null;  
        }  


        return head;
    }


    static void print(Node node) {
        Node temp = node;
        System.out.println("Forward Traversal using next pointer");
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }


   
    static Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next.prev=null;
        slow.next = null;
        return temp;
    }
    static Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);
        node = mergeSort(node);
        second = mergeSort(second);
        return merge(node, second);
    }


    static Node merge(Node first, Node second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;  
            return second;
        }
    }


   
    public static void main(String[] args) {
        head=addNode(10);
        head=addNode(30);
        head=addNode(3);
        head=addNode(4);
        head=addNode(20);
       
       
        Node node = null;
        node = mergeSort(head);
        System.out.println("Linked list after sorting :");
        print(node);


    }
}

