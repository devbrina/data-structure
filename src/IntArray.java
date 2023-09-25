package src;

public class IntArray {
    private int[] arr;
    private int capacity;
    private int size;

    public IntArray(int capacity) {
        arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return arr[i];
    }

    public void set(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        arr[i] = n;
    }

    public void add(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (size == capacity) {
            // Resize the arr to double the current capacity.
            int newCapacity = capacity * 2;
            int[] newIntArray = new int[newCapacity];

            // Copy elements up to position 'i' to the new arr.
            for (int j = 0; j < i; j++) {
                newIntArray[j] = arr[j];
            }

            // Insert the new element.
            newIntArray[i] = n;

            // Copy elements after position 'i' to the new arr.
            for (int j = i; j < size; j++) {
                newIntArray[j + 1] = arr[j];
            }
            arr = newIntArray;
            capacity = newCapacity;

        } else {
            // Shift elements to make space for the new element.
            for (int j = size - 1; j >= i; j--) {
                arr[j + 1] = arr[j];
            }

            arr[i] = n;
        }
        size++;
    }

    public void remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        // Shift elements after position 'i' to fill the gap.
        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }

        size--;
    }

    public int linearSearch(int n) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == n) {
                return i; // Return the index of the first occurrence of 'n'.
            }
        }
        return -1; // Return -1 if 'n' is not found.
    }
    public int binarySearch(int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Verifique se o elemento do meio é igual ao alvo
            if (arr[mid] == target) {
                return mid; // Elemento encontrado, retorne o índice
            }

            // Se o elemento do meio for menor que o alvo, procure na metade direita
            if (arr[mid] < target) {
                left = mid + 1;
            } else { // Se for maior, procure na metade esquerda
                right = mid - 1;
            }
        }

        return -1; // Elemento não encontrado
    }

    public void fillRandomly() {
        while (size < arr.length) {
            int element = getRandomElement();
            arr[size] = element;
            size++;
        }
    }

    // Selection Sort algorithm to sort the arr
    void selectionSort() {
        int i, j, temp, minIndex;
        for (i = 0; i < size - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // Generate random elements without repetition
    int getRandomElement() {
        int element;
        do {
            element = (int) (Math.random() * 100);
        } while (isElementRepeated(element));
        return element;
    }

    // Check if the element already exists in the arr
    boolean isElementRepeated(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }

    // Print the arr
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
