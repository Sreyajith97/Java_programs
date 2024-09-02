import java.util.*;
import java.util.stream.*;
public class Equlibrium{
    static int findMaxSum(int arr[], int n)
	{
		int sum = IntStream.of(arr).sum();
		int prefix_sum = 0,
		res = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++){
			prefix_sum += arr[i];
			
			if (prefix_sum == sum)
				res = Math.max(res, prefix_sum);
			sum -= arr[i];
		}
		
		return res;
	}
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int arr[]=new int[n];
	    for(int i=0;i<n;i++){
	        arr[i]=sc.nextInt();
	    }
	   System.out.print(findMaxSum(arr, n));
	}
}