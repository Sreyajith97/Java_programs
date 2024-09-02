import java.util.*;
public class Leaders {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        findLeaders(arr,arr.length);
    }
    static void findLeaders(int arr[],int n){
        int rightMax=arr[arr.length-1];
        System.out.print(rightMax+" ");
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>rightMax){
                rightMax=arr[i];
                System.out.println(rightMax+" ");
            }
        }
    }
}
