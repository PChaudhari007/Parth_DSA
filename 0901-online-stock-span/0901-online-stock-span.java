import java.util.Stack;

class StockSpanner {

    Stack<Integer> s;
    int[] stocks;
    int index;

    public StockSpanner() {
        s = new Stack<>();
        stocks = new int[10000];
        index = 0;
    }

    public int next(int price) {

        while (!s.isEmpty() && stocks[s.peek()] <= price) {
            s.pop();
        }

        int span;

        if (s.isEmpty()) {
            span = index + 1;
        } else {
            span = index - s.peek();
        }

        stocks[index] = price;
        s.push(index);
        index++;

        return span;
    }
}