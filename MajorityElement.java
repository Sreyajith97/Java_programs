import java.util.*;
class MajorityElement {
    static void findMajority(int arr[], int n) {
        // Use a HashMap to efficiently count element occurrences
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.putIfAbsent(num, 0); // Initialize count to 0 if not present
            int newCount = countMap.get(num) + 1;
            if (newCount > n / 2) {
                System.out.println("Majority Element : "+num);
                return; // No need to further search, majority element found
            }
            countMap.put(num, newCount);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        findMajority(arr, arr.length); // Call findMajority method
        scanner.close();
    }
}
