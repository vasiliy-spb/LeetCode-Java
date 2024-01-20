package matrix.workingPeoplesImitation.task_901_Online_Stock_Span;


import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    // my solution
    List<Integer> stocks;
    public StockSpanner() {
        this.stocks = new ArrayList<>();
    }

    public int next(int price) {
        this.stocks.add(price);
        int dayCount = 0;
        for (int i = this.stocks.size() - 1; i >= 0; i--) {
            if (this.stocks.get(i) <= price) dayCount++;
            else break;
        }
        return dayCount;
    }

    // from GPT
    /*

    private Stack<Integer> prices;
    private Stack<Integer> spans;

    public StockSpanner() {
        prices = new Stack<>();
        spans = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!prices.isEmpty() && price >= prices.peek()) {
            span += spans.pop();
            prices.pop();
        }
        prices.push(price);
        spans.push(span);
        return span;
    }

     */

}

// from leetcode solutions
/*
class StockSpanner {
//    Initialize a stack with int array.
//      First Index would be price, and
//      Second Index Will be span at that price.
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
//        At each level initialize the span to 1.
        int span = 1;
//        If The top element of stack price is below or equal to the current price:
//          Then, the previous element will be span of current.
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }
//        At each level add the price and the span.
//        So that Next time when visited for consecutive days, you have the value of current that will avoid traversal till the current days span.
        stack.add(new int[]{price, span});
        return span;
    }
}
 */