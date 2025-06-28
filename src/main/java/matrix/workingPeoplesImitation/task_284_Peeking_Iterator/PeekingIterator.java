package matrix.workingPeoplesImitation.task_284_Peeking_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
    private List<Integer> numbers;
    private int index;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.numbers = new ArrayList<>();
        while (iterator.hasNext())
            numbers.add(iterator.next());
        this.index = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return numbers.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public boolean hasNext() {
        return index < numbers.size();
    }

    @Override
    public Integer next() {
        return numbers.get(index++);
    }
}
