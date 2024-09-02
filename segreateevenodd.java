import java.util.Scanner;

public class segreateevenodd {
    Node head;
   static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
            next=null;
        }
    }

    void push(int val){
        Node new_node=new Node(val);
        new_node.next=head;
        head=new_node;
    }
    void printlist(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    void segregate(){
        Node evenstart=null;
        Node evenend=null;
        Node oddstart=null;
        Node oddend=null;
        Node currentNode=head;
        while (currentNode!=null) {
            int element=currentNode.data;
            if(element%2==0){
                if(evenstart==null){
                    evenstart=currentNode;
                    evenend=evenstart;
                }else{
                    evenend.next=currentNode;
                    evenend=evenend.next;
                }
            }else{
                if(oddstart==null){
                    oddstart=currentNode;
                    oddend=oddstart;
                }else{
                    oddend.next=currentNode;
                    oddend=oddend.next;
                }
            }
            currentNode=currentNode.next;
        }
        if(evenstart==null||oddstart==null){
            return;
        }

        evenend.next=oddstart;
        oddend.next=null;
        head=evenstart;
    }

    public static void main(String[] args) {
        segreateevenodd sg=new segreateevenodd();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            sg.push(a);
        }

        sg.segregate();
        sg.printlist();
    }
}
