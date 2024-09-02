import java.util.Scanner;
public class Maneuvering {
    static int numberOfPaths(int m, int n){
        if(m==1 || n==1){
            return 1;
        }
        return numberOfPaths(m-1,n) + numberOfPaths(m,n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(numberOfPaths(m, n));
    }
}
