package matrix.workingPeoplesImitation.task_641_Design_Circular_Deque;

// my solution
public class MyCircularDeque {
    int k;
    int[] queue;
    int first;
    int last;
    int size;

    public MyCircularDeque(int k) {
        this.k = k;
        this.queue = new int[k];
        this.first = k - 1;
        this.last = 0;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        first++;
        first %= k;
        queue[first] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        last += k - 1;
        last %= k;
        queue[last] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        first += k - 1;
        first %= k;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        last++;
        last %= k;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[first];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
