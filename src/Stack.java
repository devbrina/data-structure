import src.IntArray;
public class Stack extends IntArray {
    int top;
    public Stack(int capacity) {
        super(capacity);
        top = -1; //top with no index
    }
    public int size() {
        return super.size();
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
        return get(top);
    }
}
