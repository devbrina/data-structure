package src;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private IntArray array;
    private Stack stack;

    public MenuHandler() {
        this.scanner = new Scanner(System.in);
        this.array = new IntArray(10);
        this.stack = new Stack(10);
    }

    public void runMenu() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            processChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\nMenu:"
                +"\n1. Set the size of the array"
                +"\n2. Fill the array randomly"
                +"\n3. Print the array"
                +"\n4. Sort the array"
                +"\n5. Search for an element"
                +"\n6. Stacking options"
                +"\n7. Exit"
                +"\nEnter your choice: ");
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter the size of the array: ");
                int size = scanner.nextInt();
                array = new IntArray(size);
                System.out.println("Array size set to " + size + ".");
                break;
            case 2:
                array.fillRandomly();
                System.out.println("Array filled randomly.");
                break;
            case 3:
                System.out.println("Array contents:");
                array.print();
                break;
            case 4:
                array.selectionSort();
                System.out.println("Array sorted.");
                break;
            case 5:
                System.out.print("Enter the value to search for: ");
                int target = scanner.nextInt();
                int result = array.binarySearch(target);
                if (result != -1) {
                    System.out.println("Element " + target + " found at index " + result);
                } else {
                    System.out.println("Element " + target + " not found in the list.");
                }
                break;
            case 6:
                stack.fillFromArray(array);
                System.out.println("\nStack filled with array elements.");
                runStackMenu();
                break;
            case 7:
                scanner.close();
                System.out.println("Exiting the program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
        }
    }
    private void runStackMenu() {
        boolean stackMenuRunning = true;
        while (stackMenuRunning) {
            displayStackMenu();
            int stackChoice = scanner.nextInt();
            stackMenuRunning = processStackChoice(stackChoice);
        }
    }
    private void displayStackMenu() {
        System.out.println("\nStack Menu: "
                +"\n1. Push to Stack"
                +"\n2. Pop from Stack"
                +"\n3. Top of Stack"
                +"\n4. Back to Main Menu"
                +"\nEnter your choice: ");
    }
    private boolean processStackChoice(int stackChoice) {
        try {
            switch (stackChoice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int valueToPush = scanner.nextInt();
                    stack.push(valueToPush);
                    System.out.println("Value pushed to Stack.");
                    break;
                case 2:
                    stack.pop();
                    System.out.println("Value popped from Stack.");
                    break;
                case 3:
                    int topValue = stack.top();
                    System.out.println("Top of Stack: " + topValue);
                    break;
                case 4:
                    System.out.println("Stack contents:");
                    stack.print();
                    break;
                case 5:
                    return false; // Sair do menu do Stack e voltar ao menu principal
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

}
