package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntArray array = new IntArray(10);
        array.fillRandomly();
        System.out.println("Antes da ordenação:");
        array.print();
        array.selectionSort();
        System.out.println("\nDepois da ordenação:");
        array.print();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o valor a ser pesquisado: ");
        int target = scanner.nextInt();

        int result = array.binarySearch(target);
        if (result != -1) {
            System.out.println("Elemento " + target + " encontrado no índice " + result);
        } else {
            System.out.println("Elemento " + target + " não encontrado na lista.");
        }

        scanner.close();
    }
}
