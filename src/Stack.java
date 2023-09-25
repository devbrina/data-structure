package src;
public class Stack extends IntArray {
    int top;
    public Stack(int capacity) {
        super(capacity);
        top = -1; //top with no index
    }
    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public void push(int n) throws Exception {
        top++;
        add(top, n);
    }

    public void pop() throws Exception {
        remove(top);
        top--;
    }
    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty.");
        } else {
            return get(top);
        }
    }
    public void fillFromArray(IntArray array) {
        try {
            for (int i = 0; i < array.size(); i++) {
                int value = array.get(i);
                push(value);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void print() {
        int[] array = getArray();
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }


}
