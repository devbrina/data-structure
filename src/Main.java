package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntArray array = new IntArray(10);
        array.fillRandomly();
        System.out.println("Before sorting:");
        array.print();
        array.selectionSort();
        System.out.println("\nAfter sorting:");
        array.print();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the value to search for: ");
        int target = scanner.nextInt();

        int result = array.binarySearch(target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the list.");
        }

        scanner.close();
    }
}