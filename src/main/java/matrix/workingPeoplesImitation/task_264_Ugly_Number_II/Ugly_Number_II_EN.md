# Ugly Number II

### from walkccc.me

```Java
public int nthUglyNumber(int n) {
    // List to store the ugly numbers
    List<Integer> uglyNums = new ArrayList<>();
    uglyNums.add(1); // The first ugly number is 1

    // Pointers for 2, 3, and 5 multiples
    int i2 = 0;
    int i3 = 0;
    int i5 = 0;

    // Generate ugly numbers until the list size reaches n
    while (uglyNums.size() < n) {
        // Calculate the next ugly number based on multiples of 2, 3, and 5
        final int next2 = uglyNums.get(i2) * 2;
        final int next3 = uglyNums.get(i3) * 3;
        final int next5 = uglyNums.get(i5) * 5;

        // Find the minimum among next2, next3, and next5
        final int next = Math.min(next2, Math.min(next3, next5));

        // Increment the corresponding pointer if the next value matches
        if (next == next2)
            ++i2;
        if (next == next3)
            ++i3;
        if (next == next5)
            ++i5;

        // Add the next ugly number to the list
        uglyNums.add(next);
    }

    // Return the nth ugly number
    return uglyNums.get(uglyNums.size() - 1);
}
```

### Explanation from GPT
Let's break down the approach step by step:

#### 1. Initialization:
   - Start with the first ugly number, which is 1. Initialize three pointers (`i2`, `i3`, and `i5`) to keep track of the next multiples of 2, 3, and 5.
   - These pointers represent the indices in the list of ugly numbers (`uglyNums`) where the next multiple of 2, 3, and 5 can be found.

#### 2. Generate Ugly Numbers:
   - While the size of the list of ugly numbers (`uglyNums`) is less than `n`, continue generating new ugly numbers.
   - Calculate the next potential ugly numbers by multiplying the current values at the pointers (`i2`, `i3`, `i5`) with 2, 3, and 5, respectively.

   ```java
   final int next2 = uglyNums.get(i2) * 2;
   final int next3 = uglyNums.get(i3) * 3;
   final int next5 = uglyNums.get(i5) * 5;
   ```

   - Find the minimum among these potential ugly numbers (`next2`, `next3`, `next5`), and add it to the list of ugly numbers.

   ```java
   final int next = Math.min(next2, Math.min(next3, next5));
   uglyNums.add(next);
   ```

#### 3. Update Pointers:
   - Increment the pointer(s) that contributed to the minimum value found in the previous step. This ensures that we move forward in generating new ugly numbers.

   ```java
   if (next == next2)
       ++i2;
   if (next == next3)
       ++i3;
   if (next == next5)
       ++i5;
   ```

   - This step is crucial to avoid duplicate values and efficiently progress through the sequence of ugly numbers.

#### 4. Return Result:
   - Once the size of the list of ugly numbers reaches `n`, return the last element of the list, which is the nth ugly number.

   ```java
   return uglyNums.get(uglyNums.size() - 1);
   ```

#### Summary:
   - The approach exploits the fact that each new ugly number is a multiple of one of the previously generated ugly numbers.
   - By maintaining pointers and dynamically calculating the next potential ugly number, the algorithm avoids redundant calculations and efficiently generates the sequence of ugly numbers.
   - The use of pointers and the minimum calculation ensures that the generated numbers are in ascending order, satisfying the conditions of ugly numbers.

---

### from leetcode solutions:
We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. Then

k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2's pointer to 1. Then we test:

k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.

x here is multiplication.

In C++:

```cpp
class Solution {
public:
    int nthUglyNumber(int n) {
        if(n <= 0) return false; // get rid of corner cases 
        if(n == 1) return true; // base case
        int t2 = 0, t3 = 0, t5 = 0; //pointers for 2, 3, 5
        vector<int> k(n);
        k[0] = 1;
        for(int i  = 1; i < n ; i ++)
        {
            k[i] = min(k[t2]*2,min(k[t3]*3,k[t5]*5));
            if(k[i] == k[t2]*2) t2++; 
            if(k[i] == k[t3]*3) t3++;
            if(k[i] == k[t5]*5) t5++;
        }
        return k[n-1];
    }
};
```
In Java:
```Java
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0; // get rid of corner cases 
        if (n == 1) return 1; // base case
        int t2 = 0, t3 = 0, t5 = 0; // pointers for 2, 3, 5
        int[] k = new int[n];
        k[0] = 1;
        for (int i = 1; i < n; i++) {
            k[i] = Math.min(k[t2] * 2, Math.min(k[t3] * 3, k[t5] * 5));
            if (k[i] == k[t2] * 2) t2++; 
            if (k[i] == k[t3] * 3) t3++;
            if (k[i] == k[t5] * 5) t5++;
        }
        return k[n - 1];
    }
}
```

### from comments to it:

* > Let me try to explain this using an example. Let's say we have the first 3 ugly numbers 1, 2, 3. What would be the next number? Given the definition, the next number has to be the the smallest number among 2*(1,2,3), 3*(1,2,3), 5*(1,2,3). Obviously, the smallest number is 2 * 1 = 2. But wait, 2 is already in there. So precisely speaking, the next number has to be the the smallest number among all the existing numbers multiplied by 2, 3,5 that isn't in the list already. Now, we can traverse all numbers and maintain a hashset if we want, but it would become O(N^2). Good news is that we can solve this in a DP-like approach. First, we assume there is only one number in the list, which is 1. The next number is Min(2 * 1, 3 * 1, 5 * 1)=2 and it is not in the list. Because we have already considered 2*1 (we move the pointer to its next position, which is 2), now we only need to consider 2 * 2, 3 * 1, 5 * 1 in the next iteration. This way, we don't have to worry about finding a number that is already in the list.
> * > The way you Explained is truly great! Just by reading some lines, I got this.
This is same as K merge sorted but here we are doing everything inline i.e.
    1. Constructing the k arrays
    2. Select the minimum as we are constructing the array.
> * > The bold line helps clarify the whole algorithm. One thing though, even if we move the pointer to another list there can still be duplicates as 2 * 3 == 3 * 2. so probably still need to check if in set
> * > This is clarified in the original post - in cases where you have things like 23 and 32, your min check would look like Min (2 * 3, 3 * 2, 5 * 2) (as 31 has been chosen for 3, 2 * 2 has been chosen for 4, and 5 * 1 has been chosen for 5). In this case, it mentions that you need to increment BOTH the 2 pointer and the 3 pointer. So the next one becomes Min(24, 33, 52), which is choose 8. Then Min(2 * 5, 3 * 3, 5 * 2), which is choose 9. Then Min(2 * 5, 3 * 4, 5 * 2), which is choose 10. Then Min(2 * 6, 3 * 4, 5 * 3). Any time you have a case of repeating numbers, the mins of the multiplying numbers will match. Let's go to choose 30, where all 3 will line up:
    n=10 (2 * 6, 3 * 4, 5 * 3) choose 12, increment 2 and 3 to the next ugly number
    n=11 (2 * 8, 3 * 5, 5 * 3) choose 15, increment 3 and 5
    n=12 (2 * 8, 3 * 6, 5 * 4) choose 16, increment 2
    n=13 (2 * 9, 3 * 6, 5 * 4) choose 18, increment 2 and 3
    n=14 (2 * 10, 3 * 8, 5 * 4) choose 20, increment 2 and 5
    n=15 (2 * 12, 3 * 8, 5 * 5) choose 24, increment 2 and 3
    n=16 (2 * 15, 3 * 9, 5 * 5) choose 25, increment 5
    n=17 (2 * 15, 3 * 9, 5 * 6) choose 27, increment 3
    n=18 (2 * 15, 3 * 10, 5 * 6) choose 30, increment all 3
    
    
* > Very cool! I understood the overall idea but had a hard time seeing exactly how the multiple pointers were working. Here's the same algorithm but with some comments and a step-through -- this was especially helpful in seeing when the multiple pointers get moved in the same iteration. Hope it's helpful

```Java
public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            /* 
                2: currentUglyNumber = min(1 * 2, 1 * 3, 1* 5) = 2
                    produced by p2, so p2++ 
                    dp [1, 2]
                3: currentUglyNumber = min(2 * 2, 1 * 3, 1 * 5) = 3
                    produced by p3, so p3++
                    dp [1, 2, 3]
                4: currentUglyNumber = min(2 * 2, 2 * 3, 1 * 5) = 4
                    produced by p2, so p2++
                    dp [1, 2, 3, 4]
                5: currentUglyNumber = min(3 * 2, 2 * 3, 1 * 5) = 5
                    produced by p5, so p5++
                    dp [1, 2, 3, 4, 5]
                6: currentUglyNumber = min(3 * 2, 2 * 3, 2 * 5) = 6
                    produced by p2 AND p3, so p2++ and p3++
                    dp [1, 2, 3, 4, 5, 6]
                7: currentUglyNumber = min(4 * 2, 3 * 3, 2 * 5) = 8
                    produced by p2, so p2++
                    dp [1, 2, 3, 4, 5, 6, 8]
                8: currentUglyNumber = min(5 * 2, 3 * 3, 2 * 5) = 9
                    produced by p3, so p3++
                    dp [1, 2, 3, 4, 5, 6, 8, 9]
                9: currentUglyNumber = min(5 * 2, 4 * 3, 2 * 5) = 10
                    produced by p2 and p5, p2++ and p5++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10]
                10: currentUglyNumber = min(8 * 2, 4 * 3, 3 * 5) = 12
                    NOTE the 8, that's the value at index 6
                    produced by p3, p3++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
                11: currentUglyNumber = min(8 * 2, 5 * 3, 3 * 5) = 15
                    produced by p3 and p5, p3++ and p5++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15]
                12: currentUglyNumber = min(8 * 2, 8 * 3, 4 * 5) = 16
                    produced by p2, p2++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16]
                13: currentUglyNumber = min(9 * 2, 8 * 3, 4 * 5) = 18
                    produced by p2, p2++   
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18]
                14: currentUglyNumber = min(10 * 2, 8 * 3, 4 * 5) = 20
                    produced by p2 and p5, p2++ p5++   
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20]
                15: currentUglyNumber = min(12 * 2, 8 * 3, 5 * 5) = 24
                    produced by p2 and p3, p2++ p3++   
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24]
                    
                etc.. 
            */
            int p2Val = dp[p2] * 2;
            int p3Val = dp[p3] * 3;
            int p5Val = dp[p5] * 5;
            int currentUglyNumber = Math.min(p2Val, Math.min(p3Val, p5Val));
            /* 
                move the pointer(s) that produced the currentUglyNumber
                so we don't consider that value again
            */
            if (currentUglyNumber == p2Val) p2++;
            if (currentUglyNumber == p3Val) p3++;
            if (currentUglyNumber == p5Val) p5++;
            dp[i] = currentUglyNumber;
        }
        return dp[n - 1];
    }
```

> * > I thought the same at the beginning, but we need to be clear that in each step, we multiple the next ugly number, not just simply increase 1. So at the 10th step, 12 is ugly number 6 * 2, so we move t2 from ugly number 6 to next one, which is 8. Hope it helps.

* > 1. Essentially, we have to multiply the existed ugly numbers by 2, 3 and 5 to get a bigger ugly number, however, if we blindly multiply all the existed numbers by 2, 3 and 5, then the number could grow much faster than needed
> 2. Hence, every time we only try to find the next smallest ugly number
> 3. Also, since any existed number will be multiplied by 2, 3 and 5 once and only once, otherwise duplicate, we can use a pointer to keep track of where the 2, 3 and 5 are going to multiply in the next step.
> 4. Once, we find the next minimum, we can move on the corresponding pointer, otherwise it always stays at the already existed ugly number which would makes pointer useless
>  * > Great explanation. The most important part is "any existed number will be multiplied by 2, 3 and 5 once and only once"

* > Thanks for sharing! I think maybe this way is easier to understand: In order to produce a new smallest ugly number, one of (or some of) 2, 3, 5 needs to multiply a smaller ugly number, and there come the pointers. After an ugly number is produced, the corresponding pointer(s) needs to move forward. Otherwise it will produce the same ugly number. And the order is retained since each product is larger or equal than before and we extract the minimum every time.
> * > Just to add to why the pointers move, the pointers represent the multiplicand indices for 2, 3, and 5. If 2 gives the min, the ugly multiplicand that was used is done. Now, move to the next multiplicand for 2. Same if it were for 3 or 5.

* > An explanation using the idea of merge sort.
    
    > Actually the three pointer here is a little confusing (at least for me). So let's just take the pointer out. Assume we have three ugly number array, which are multiple of 2, 3, 5 respectively.
```
[1, 2, 4, 6, 8, 10, 12, 16, ... ]
[1, 3, 6, 9, 12, 15, 18, 24, ...]
[1, 5, 10, 15, 20, 25, 30, ...]
```
Every time just find the smallest one in first column, then pop it out.
Why we can use three pointers? Because every row above is formed by multiple 2, 3 or 5 with other ugly numbers. They can be rewritten as
```
2 * [1, 2, 3, 4, 5, 6, 8, ... ]
3 * [1, 2, 3, 4, 5, 6, 8, ... ]
5 * [1, 2, 3, 4, 5, 6, ... ]
```

* > Brilliant idea, here is my Java solution:

    ```Java
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; i++) {
            // generate ugly number by multiply all the factors
            uglyNumbers[i] = Math.min(uglyNumbers[index2] * 2, Math.min(uglyNumbers[index3] * 3, uglyNumbers[index5] * 5));

            // bump up index for the current minimum ugly number 
            if (uglyNumbers[i] == uglyNumbers[index2] * 2) index2++;
            if (uglyNumbers[i] == uglyNumbers[index3] * 3) index3++;
            if (uglyNumbers[i] == uglyNumbers[index5] * 5) index5++;
        }

        return uglyNumbers[n - 1];
    }
    ```

* > This is indeed dynamic programming as it reuses small ugly number to construct large ugly number. If you are still not convinced, I have below top-down implementation (in Python though).
    
    In Python:
    
    ```Python
    class Solution:
        def nthUglyNumber(self, n: int) -> int:

            @lru_cache(None)
            def fn(x):
                """Return the next ugly number to x"""
                if x == 0: return 1
                return min(f*fn(x//f) for f in (2,3,5))

            x = 0
            for _ in range(n): x = fn(x)
            return x
    ```
    In Java:
    ```Java
    class Solution {
        private Map<Integer, Integer> cache = new HashMap<>();

        public int nthUglyNumber(int n) {
            return fn(n);
        }

        private int fn(int x) {
            if (x == 0) return 1;
            if (cache.containsKey(x)) return cache.get(x);

            int result = Integer.MAX_VALUE;
            for (int f : new int[]{2, 3, 5}) {
                result = Math.min(result, f * fn(x / f));
            }

            cache.put(x, result);
            return result;
        }
    }
    ```
    
---

### from leetcode solutions:

The idea of this solution is from this page: http://www.geeksforgeeks.org/ugly-numbers/

The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

```
(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
```

We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

Every step we choose the smallest one, and move one step after,including nums with same value.

Thanks for this author about this brilliant idea. Here is my java solution

```Java
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
```

### from comments to it:

* > Very nice solution. However it is a little misleading to me at the first glance. When trying to understand "every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5." I automatically thought the sequence could go on like (1, 2, 3, 4, 5, 6, 7, 8, 9, 10....), it could be better to list it like: (1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15). A minor suggestion.

* > Here is an more concise version:
```Java
public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++){
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if(nums[i] == nums[index2] * 2)
                index2++;
            if(nums[i] == nums[index3] * 3)
                index3++;
            if(nums[i] == nums[index5] * 5)
                index5++;
        }
        return nums[n - 1];
    }
```
* > Thanks for sharing. I think the key here is as you mentioned, "including nums with same value.". factor2 and factor3 may both have value = 6, but we bump both "6"s together, thus the duplicated 6 won't cause any problem. I initially put it as "else if (factor3==min)", that fell to the trap :)
* > Great idea! We can also just keep track of the pointer.

    ```Java
    public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0, p = 1;

        int[] dp = new int[n];
        dp[0] = 1;

        while (p < n) {
            dp[p] = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            if (dp[p] == dp[i] * 2) i++;
            if (dp[p] == dp[j] * 3) j++;
            if (dp[p] == dp[k] * 5) k++;
            p++;
        }

        return dp[n - 1];
      }
    ```
    
* > In order to avoid any possible misunderstanding, I would like to write more examples about the sequence of numbers.
```
(1) 1×2, 2×2, 3×2, 4×2, 5×2, 6×2, 8×2, ... (Notice that there is no 7 because 7 does not belong to ugly number factor)
(2) 1×3, 2×3, 3×3, 4×3, 5×3, 6×3, 8×3, ...
(3) 1×5, 2×5, 3×5, 4×5, 5×5, 6×5, 8×5, 9×5, ...
```
The key idea is the combination of random numbers of {2, 3, 5} and find the minimum at every round.
> * > As you can see that, we multiply the value with 2,3,5 =>
so from that we have with 2
=> 2,4,6,8
with 3
=> 3, 6, 9. 12
similarly with 5 => so we will never reach the case 7 * 2
> * > The way they avoid 7 is by multiplying numbers already present in the array. Each factor multiplies the last checked index of that factor. Checking number in the array is safe because we already know these numbers are divisible by one of the factors.

* > Your code is very concise.
<br> I just modified it a little bit.
<br> Since java program can keep some static members,
we can calculate all the ugly numbers that are less than or equal to Integer.MAX_VALUE and just store the result into a static array. After some trial, I found that, it is enough to get an array that have 1691 elements. (the 1691st ugly number is 2125764000 while the 1692nd one is 2147483648 which just overflow).
<br> So for example, if we are asked what is the 1691st, 1690th, 1689th, 1688th, 1687th, .... ugly number, we will not need to calculate what we already know~ Just one round of calculation and all we need to do is to return the queried element in the array.

    ```Java
    public class Solution {
        static int[] ugly = new int[1691];
        static {
            ugly[0] = 1;
            int index2 = 0, index3 = 0, index5 = 0;
            int factor2 = 2, factor3 = 3, factor5 = 5;
            for (int i = 1; i < ugly.length; i++) {
                int min = Math.min(Math.min(factor2, factor3), factor5);
                ugly[i] = min;
                if (factor2 == min)
                    factor2 = 2 * ugly[++index2];
                if (factor3 == min)
                    factor3 = 3 * ugly[++index3];
                if (factor5 == min)
                    factor5 = 5 * ugly[++index5];
            }
        }

        public int nthUglyNumber(int n) {
            return ugly[n - 1];
        }
    }
    ```
> * > Yes, if we are asked what the 5th ugly number is, a lot of calculation is wasted.
But generally speaking, the test cases will be large enough.
By the way, I agree with you, the algorithm is the most important thing here.

---


