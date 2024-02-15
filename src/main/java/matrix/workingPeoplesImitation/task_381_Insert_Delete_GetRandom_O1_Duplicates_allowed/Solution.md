# Solution

This is my solution which I published on leetcode

# Approach
Use a combination of a `HashMap` and an `ArrayList` to achieve O(1) average time complexity for the insert, remove, and getRandom operations. Below are the key components and the reasoning behind each part of the approach:

1. **HashMap (`map`):**
   - The `map` is used to store the values as keys and the corresponding set of indices in the `ArrayList` as values.
   - For each value, the set of indices represents the positions in the `ArrayList` where that value occurs.
   - This allows for quick lookups to check if a value exists and to obtain one of its indices.

2. **ArrayList (`list`):**
   - The `list` is used to store the actual values in the order they were inserted.
   - The indices in the `ArrayList` correspond to the positions of the values in the collection.

3. **Insert Operation (`insert` method):**
   - Checks if the value is already present in the `map` using `map.containsKey(val)`.
   - If the value is not present, it adds the value to the `map` and assigns a new set containing the current index to the value.
   - The value is then added to the end of the `ArrayList`.
   - The method returns true if the value was not present before, and false otherwise.

4. **Remove Operation (`remove` method):**
   - Checks if the value to be removed is present in the `map` using `map.containsKey(val)`.
   - Retrieves one of the indices of the value from the set in the `map`.
   - Removes the index from the set, and if the set becomes empty, removes the value from the `map`.
   - If the value to be removed is not the last element in the `ArrayList`, it performs a swap-and-pop operation:
     - Updates the `map` for the last value in the `ArrayList`.
     - Swaps the value to be removed with the last value in the `ArrayList`.
     - Removes the last element from the `ArrayList`.
   - The method returns true if the value was present and removed, and false otherwise.

5. **Get Random Operation (`getRandom` method):**
   - Generates a random index using `random.nextInt(list.size())`.
   - Retrieves the value at the random index in the `ArrayList`.
   - Returns the randomly selected value.

The reasoning behind using a `HashSet` for the set of indices is to achieve O(1) time complexity for removal and addition of indices. Overall, this approach ensures that each operation works on average in constant time, meeting the O(1) time complexity requirement.

# Code

```Java []
// With comments
class RandomizedCollection {
    private Map<Integer, Set<Integer>> map; // Map to store values and their indices in the list
    private List<Integer> list; // List to store the values in the order they were inserted

    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    // Inserts a value into the collection, returns true if the value was not present before
    public boolean insert(int val) {
        boolean ans = map.containsKey(val); // Check if the value is already present
        map.computeIfAbsent(val, key -> new HashSet<>()).add(list.size()); // Add the index to the set in the map
        list.add(val); // Add the value to the list
        return !ans; // Return true if the value was not present before
    }

    // Removes a value from the collection, returns true if the value was present
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; // If the value is not present, return false

        int indexVal = map.get(val).iterator().next(); // Get one of the indices of the value

        map.get(val).remove(indexVal); // Remove the index from the set in the map
        if (map.get(val).isEmpty()) map.remove(val); // If the set is empty, remove the value from the map

        if (indexVal != list.size() - 1) {
            // If the index to be removed is not the last index in the list

            // Update the map for the last value in the list
            map.get(list.get(list.size() - 1)).remove(list.size() - 1);
            map.get(list.get(list.size() - 1)).add(indexVal);

            list.set(indexVal, list.get(list.size() - 1)); // Replace the value at indexVal with the last value
        }

        list.remove(list.size() - 1); // Remove the last element from the list
        return true; // Return true since the value was present and removed
    }

    // Returns a random element from the collection
    public int getRandom() {
        Random random = new Random();
        int ind = random.nextInt(list.size()); // Generate a random index
        return list.get(ind); // Return the value at the random index
    }
}

```
```Java []
// Clean code
class RandomizedCollection {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;

    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean ans = map.containsKey(val);
        map.computeIfAbsent(val, key -> new HashSet<>()).add(list.size());
        list.add(val);
        return !ans;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int indexVal = map.get(val).iterator().next();

        map.get(val).remove(indexVal);

        if (map.get(val).isEmpty()) map.remove(val);

        if (indexVal != list.size() - 1) {

            map.get(list.get(list.size() - 1)).remove(list.size() - 1);
            map.get(list.get(list.size() - 1)).add(indexVal);

            list.set(indexVal, list.get(list.size() - 1));
        }
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int ind = random.nextInt(list.size());
        return list.get(ind);
    }
}

```
```cpp []
class RandomizedCollection {
private:
    std::unordered_map<int, std::unordered_set<int>> map;
    std::vector<int> list;

public:
    RandomizedCollection() {

    }

    bool insert(int val) {
        bool ans = map.count(val) > 0;
        map[val].insert(list.size());
        list.push_back(val);
        return !ans;
    }

    bool remove(int val) {
        if (map.count(val) == 0) return false;

        int indexVal = *map[val].begin();

        map[val].erase(indexVal);
        if (map[val].empty()) map.erase(val);

        if (indexVal != list.size() - 1) {
            int lastValue = list.back();

            map[lastValue].erase(list.size() - 1);
            map[lastValue].insert(indexVal);

            list[indexVal] = lastValue;
        }

        list.pop_back();
        return true;
    }

    int getRandom() {
        std::random_device rd;
        std::mt19937 gen(rd());
        std::uniform_int_distribution<int> dist(0, list.size() - 1);
        int ind = dist(gen);
        return list[ind];
    }
};
```
```Python []
class RandomizedCollection(object):

    def __init__(self):
        self.map = {}
        self.list = []

    def insert(self, val):
        ans = val in self.map
        self.map.setdefault(val, set()).add(len(self.list))
        self.list.append(val)
        return not ans

    def remove(self, val):
        if val not in self.map:
            return False

        index_val = next(iter(self.map[val]))

        self.map[val].remove(index_val)
        if not self.map[val]:
            del self.map[val]

        if index_val != len(self.list) - 1:
            last_value = self.list[-1]

            self.map[last_value].remove(len(self.list) - 1)
            self.map[last_value].add(index_val)

            self.list[index_val] = last_value

        self.list.pop()
        return True

    def getRandom(self):
        ind = random.randint(0, len(self.list) - 1)
        return self.list[ind]
```
```JavaScript []
var RandomizedCollection = function() {

};

RandomizedCollection.prototype.map = new Map();
RandomizedCollection.prototype.list = [];

RandomizedCollection.prototype.insert = function(val) {
    const ans = this.map.has(val);
        this.map.set(val, this.map.get(val) || new Set());
        this.map.get(val).add(this.list.length);
        this.list.push(val);
        return !ans;
};

RandomizedCollection.prototype.remove = function(val) {
    if (!this.map.has(val)) return false;

        const indexVal = this.map.get(val).values().next().value;

        this.map.get(val).delete(indexVal);
        if (this.map.get(val).size === 0) this.map.delete(val);

        if (indexVal !== this.list.length - 1) {
            const lastValue = this.list[this.list.length - 1];

            this.map.get(lastValue).delete(this.list.length - 1);
            this.map.get(lastValue).add(indexVal);

            this.list[indexVal] = lastValue;
        }

        this.list.pop();
        return true;
};

RandomizedCollection.prototype.getRandom = function() {
    const ind = Math.floor(Math.random() * this.list.length);
        return this.list[ind];
};
```

# Complexity

- **Time complexity**
1. **insert(int val):**
   - `map.containsKey(val)` takes O(1).
   - `map.computeIfAbsent(val, key -> new HashSet<>()).add(list.size())` takes O(1).
   - `list.add(val)` takes O(1).
   - Overall, the time complexity of insert is O(1).

2. **remove(int val):**
   - `map.containsKey(val)` takes O(1).
   - `map.get(val).iterator().next()` takes O(1) on average because the HashSet iterator's next() method is constant time for a small number of elements.
   - `map.get(val).remove(indexVal)` takes O(1).
   - If the value to be removed is not the last element in the list:
      - `map.get(list.get(list.size() - 1)).remove(list.size() - 1)` takes O(1).
      - `map.get(list.get(list.size() - 1)).add(indexVal)` takes O(1).
      - `list.set(indexVal, list.get(list.size() - 1))` takes O(1).
   - `list.remove(list.size() - 1)` takes O(1).
   - Overall, the time complexity of remove is O(1) on average.

3. **getRandom():**
   - `random.nextInt(list.size())` takes O(1) on average.
   - Overall, the time complexity of getRandom is O(1).

Considering the average-case time complexity for each operation, this solution achieves O(1) time complexity for insert, remove, and getRandom operations.

- **Space complexity**
The space complexity of this solution is O(N), where N is the number of elements in the collection. This is due to the space required to store the values in the list and the indices in the map.

---

### Previous solution (for history)
Here remove() is executed in 0(n) time

```Java
class RandomizedCollection {
    private Map<Integer, Integer> map; // Map to store the count of each element
    private List<Integer> list; // List to store the actual elements in the order they were inserted

    // Constructor to initialize the map and list
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    // Inserts an element into the collection
    // Returns true if the element was not present before, false otherwise
    public boolean insert(int val) {
        boolean ans = map.containsKey(val); // Check if the element is already present
        map.merge(val, 1, Integer::sum); // Increment the count of the element in the map
        list.add(val); // Add the element to the list
        return !ans;
    }

    // Removes an element from the collection
    // Returns true if the element was present and removed, false otherwise
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; // If the element is not present, return false
        map.merge(val, -1, Integer::sum); // Decrement the count of the element in the map
        if (map.get(val) == 0) map.remove(val); // If the count becomes zero, remove the element from the map
        list.remove(Integer.valueOf(val)); // Remove the element from the list
        return true;
    }

    // Returns a random element from the collection
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size()); // Generate a random index within the size of the list
        return list.get(index); // Return the element at the randomly generated index
    }
}
```
