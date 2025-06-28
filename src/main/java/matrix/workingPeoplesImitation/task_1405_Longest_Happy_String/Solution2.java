package matrix.workingPeoplesImitation.task_1405_Longest_Happy_String;

import java.util.PriorityQueue;

// from leetcode editorial (Approach 1: Priority Queue)
public class Solution2 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) ->
                (y.count - x.count)
        );
        // Add the counts of a, b and c in priority queue.
        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int count = p.count;
            char character = p.character;
            // If three consecutive characters exists, pick the second most
            // frequent character.
            if (
                    ans.length() >= 2 &&
                            ans.charAt(ans.length() - 1) == p.character &&
                            ans.charAt(ans.length() - 2) == p.character
            ) {
                if (pq.isEmpty()) break;

                Pair temp = pq.poll();
                ans.append(temp.character);
                if (temp.count - 1 > 0) {
                    pq.add(new Pair(temp.count - 1, temp.character));
                }
            } else {
                count--;
                ans.append(character);
            }

            // If count is greater than zero, add it to priority queue.
            if (count > 0) {
                pq.add(new Pair(count, character));
            }
        }
        return ans.toString();
    }

    class Pair {

        int count;
        char character;

        Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }
}

/*
Approach 1: Priority Queue
Intuition

We are given three integers a, b, and c, representing the number of characters a, b, and c we can use. The goal is to create the longest string possible with these characters while making sure that no three consecutive characters are the same.

To make the string as long as possible, we should try to use the character that appears most often without breaking the rule about three consecutive characters. If using the most frequent character would cause three in a row, we use the next most frequent character instead.

We can use a max-heap to solve this problem efficiently. The heap lets us pick the character with the highest remaining count, and switch to the next character if needed to avoid triples.

First, we put the counts of a, b, and c into a max-heap. If adding the most frequent character would create three in a row, we pick the second most frequent one. After adding a character, we reduce its count. If it still has characters left, we put it back into the heap.

By always selecting the character with the highest count, except when it would break the rule, we ensure the string is as long as possible.
Algorithm

    Create a max-heap pq to store the counts of a, b, and c in descending order of their counts and a string ans to store the string answer.
    Push (a, 'a'), (b, 'b'), and (c, 'c') into the heap if their counts are greater than 0.
    Iterate Until pq is Empty:
        Pop the most frequent character from the heap.
        If adding this character would result in three consecutive identical characters in the answer string, do the following:
            Check the next most frequent character by popping it from the heap.
            Add this second character to the answer. If its count is still positive after use, push it back into the heap.
            Push the previously popped character (the most frequent) back into the heap without adding it to the answer yet.
        Otherwise, if the character can be added without violating the three-consecutive rule, append it to ans and decrement its count.
        If a character’s count is still greater than 0 after being appended, push it back into the heap.
    Once the heap is empty and no more characters can be added, return the constructed string ans as the result.

 */