import java.util.Scanner;

public class Combination {

    static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }
        if (i >= n)
            return;

        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);

        combinationUtil(arr, n, r, index, data, i + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the value of 'r':");
        int r = scanner.nextInt();

        combinationUtil(arr, size, r, 0, new int[r], 0);
        
        scanner.close();
    }
}

