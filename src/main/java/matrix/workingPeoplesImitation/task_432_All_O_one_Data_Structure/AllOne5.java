package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.HashMap;

// from leetcode code sample (2)
public class AllOne5 {
    private DoublyLinkedList list;
    private HashMap<String, Node> map;

    public AllOne5() {
        this.list = new DoublyLinkedList();
        this.map = new HashMap<>();
    }

    public void inc(String key) {
        if (!this.map.containsKey(key)) {
            Node current = new Node(key);
            current.freq++;
            this.map.put(key, current);
            if (this.map.size() == 1) {
                this.list.head = current;
                this.list.tail = current;
            }else{
                this.list.insertAtEnd(current);
            }
        } else {
            Node current = this.map.get(key);
            current.freq++;
            this.list.moveLeft(current);
        }
    }

    public void dec(String key) {
        Node current = this.map.get(key);
        current.freq--;
        if(current.freq == 0){
            this.map.remove(key);
            this.list.unlinkNode(current);
            return;
        }
        this.list.moveRight(current);
    }

    public String getMaxKey() {
        return this.list.head == null ? "": this.list.head.val;
    }

    public String getMinKey() {
        return this.list.tail == null ? "": this.list.tail.val;
    }
    static class Node {
        public String val;
        public Node next;
        public Node prev;
        public int freq;

        public Node(String val) {
            this.val = val;
            this.next = null;
            this.prev = null;
            this.freq = 0;
        }
    }
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void unlinkNode(Node current) {
            if (this.tail == current) {
                this.tail = current.prev;
            }
            if(this.head == current){
                this.head = current.next;
            }
            Node prev = current.prev;
            Node next = current.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            current.next = null;
            current.prev = null;
        }

        public void insertAtEnd(Node current) {
            this.tail.next = current;
            current.prev = this.tail;
            this.tail = current;
        }

        public void moveLeft(Node current) {
            Node prev = current.prev;
            if(prev == null || prev.freq>=current.freq)
                return;
            while (prev != null && prev.freq < current.freq) {
                prev = prev.prev;
            }
            this.unlinkNode(current);
            if (prev != null) {
                Node temp = prev.next;
                prev.next = current;
                current.prev = prev;
                current.next = temp;
                temp.prev = current;
            } else {
                current.next = this.head;
                this.head.prev = current;
                this.head = current;
            }
        }

        public void moveRight(Node current){
            Node next = current.next;
            if(next == null || next.freq<=current.freq){
                return;
            }
            while(next!= null && next.freq > current.freq){
                next = next.next;
            }
            this.unlinkNode(current);
            if(next != null){
                Node temp = next.prev;
                next.prev = current;
                current.next = next;
                current.prev = temp;
                temp.next = current;
            }else{
                current.prev = this.tail;
                this.tail.next = current;
                this.tail = current;
            }
        }

    }
}
