package src;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    IntArray array;

    public MenuHandler() {
        this.scanner = new Scanner(System.in);
        this.array = new IntArray(10);
    }

    public void runMenu() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            processChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Fill the array randomly");
        System.out.println("2. Print the array");
        System.out.println("3. Sort the array");
        System.out.println("4. Search for an element");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                array.fillRandomly();
                System.out.println("Array filled randomly.");
                break;
            case 2:
                System.out.println("Array contents:");
                array.print();
                break;
            case 3:
                array.selectionSort();
                System.out.println("Array sorted.");
                break;
            case 4:
                System.out.print("Enter the value to search for: ");
                int target = scanner.nextInt();
                int result = array.binarySearch(target);
                if (result != -1) {
                    System.out.println("Element " + target + " found at index " + result);
                } else {
                    System.out.println("Element " + target + " not found in the list.");
                }
                break;
            case 5:
                scanner.close();
                System.out.println("Exiting the program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
        }
    }
}
