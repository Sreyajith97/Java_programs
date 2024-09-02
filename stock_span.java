import java.util.Arrays;
import java.util.Stack;

public class stock_span {
    public static void main(String[] args) {
        int stock[]={100,80,60,70,60,75,85};
        int n=stock.length;
        Stack <Integer>s=new Stack<>();
        int span[]=new int[n];
        s.push(0);
        span[0]=1;
        for(int i=1;i<n;i++){
            while (!s.isEmpty()&&stock[i]>=stock[s.peek()]) {
                s.pop();
            }
            span[i] = s.isEmpty() ? i + 1 : (i - s.peek());

            s.push(i);
        }
        System.out.println(Arrays.toString(span));
        System.out.println(Arrays.toString(stock));
    }
}
