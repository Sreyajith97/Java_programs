import java.util.Arrays;
import java.util.Scanner;

public class Permutation {

    static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++)
            f *= i;
        return f;
    }

    static void print(char[] temp) {
        for (char c : temp)
            System.out.print(c);
        System.out.println();
    }

    static int calculateTotal(char[] temp) {
        int f = factorial(temp.length);
        int[] count = new int[256]; 
        for (char c : temp)
            count[c]++;
        for (int x : count)
            if (x > 1)
                f /= factorial(x);
        return f;
    }

    static void nextPermutation(char[] temp) {
        int i = temp.length - 1;
        while (i > 0 && temp[i] <= temp[i - 1])
            i--;
        if (i <= 0)
            return;
        int j = temp.length - 1;
        while (temp[j] <= temp[i - 1])
            j--;
        char temp_to_swap = temp[i - 1];
        temp[i - 1] = temp[j];
        temp[j] = temp_to_swap;
        Arrays.sort(temp, i, temp.length);
        print(temp);
    }

    static void printAllPermutations(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        print(temp);
        int total = calculateTotal(temp);
        for (int i = 1; i < total; i++)
            nextPermutation(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String my_str = scanner.nextLine();
        scanner.close();

        System.out.println("The sorted unique permutations of the string are:");
        printAllPermutations(my_str);
    }
}
