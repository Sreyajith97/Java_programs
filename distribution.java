public class distribution {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 1 };
        int n=arr.length;
        int k=2;
        if(checkcount(arr,n,k)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    static boolean checkcount(int[]arr, int n, int k){
        int count;
        for(int i=0;i<n;i++){
            count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
                if(count>2*k){
                    return false;
                }
            }
        }
        return true;
    }
}
