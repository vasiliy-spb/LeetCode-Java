# Solution

## Intuition

We must support three operations with duplicates:

* insert
* remove
* getRandom

To getRandom in O(1) and have it scale linearly with the number of copies of a value. The simplest solution is to store all values in a list. Once all values are stored, all we have to do is pick a random index.

We don't care about the order of our elements, so insert can be done in O(1) using a dynamic array (ArrayList in Java or list in Python).

The issue we run into is how to go about an O(1) remove. Generally we learn that removing an element from an array takes a place in O(N), unless it is the last element in which case it is O(1).

The key here is that we don't care about order. For the purposes of this problem, if we want to remove the element at the ith index, we can simply swap the ith element and the last element, and perform an O(1) pop (technically we don't have to swap, we just have to copy the last element into index i because it's popped anyway).

With this in mind, the most difficult part of the problem becomes finding the index of the element we have to remove. All we have to do is have an accompanying data structure that maps the element values to their index.

## Approach 1: ArrayList + HashMap

## Algorithm

We will keep a list to store all our elements. In order to make finding the index of elements we want to remove O(1), we will use a HashMap or dictionary to map values to all indices that have those values. To make this work each value will be mapped to a set of indices. The tricky part is properly updating the HashMap as we modify the list.

    insert: Append the element to the list and add the index to HashMap[element].
    remove: This is the tricky part. We find the index of the element using the HashMap. We use the trick discussed in the intuition to remove the element from the list in O(1). Since the last element in the list gets moved around, we have to update its value in the HashMap. We also have to get rid of the index of the element we removed from the HashMap.
    getRandom: Sample a random element from the list.

## Implementation

Java
```Java
public class RandomizedCollection {
    ArrayList<Integer> lst;
    HashMap<Integer, Set<Integer>> idx;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */

    public RandomizedCollection() {
        lst = new ArrayList<Integer>();
        idx = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!idx.containsKey(val)) idx.put(val, new LinkedHashSet<Integer>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0) return false;
        int remove_idx = idx.get(val).iterator().next();
        idx.get(val).remove(remove_idx);
        int last = lst.get(lst.size() - 1);
        lst.set(remove_idx, last);
        idx.get(last).add(remove_idx);
        idx.get(last).remove(lst.size() - 1);

        lst.remove(lst.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}
```
Python
```Python
from collections import defaultdict
from random import choice

class RandomizedCollection:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lst = []
        self.idx = defaultdict(set)


    def insert(self, val: int) -> bool:
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        """
        self.idx[val].add(len(self.lst))
        self.lst.append(val)
        return len(self.idx[val]) == 1


    def remove(self, val: int) -> bool:
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        """
        if not self.idx[val]: return False
        remove, last = self.idx[val].pop(), self.lst[-1]
        self.lst[remove] = last
        self.idx[last].add(remove)
        self.idx[last].discard(len(self.lst) - 1)

        self.lst.pop()
        return True


    def getRandom(self) -> int:
        """
        Get a random element from the collection.
        """
        return choice(self.lst)

```

## Complexity Analysis

- Time complexity : O(N), with N being the number of operations. All of our operations are O(1), giving N∗O(1)=O(N).

- Space complexity : O(N), with N being the number of operations. The worst case scenario is if we get N add operations, in which case our ArrayList and our HashMap grow to size N.

