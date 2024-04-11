package matrix.workingPeoplesImitation.task_950_Reveal_Cards_In_Increasing_Order;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    // my solution
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        int indexDeck = 0;
        int indexResult = 0;
        boolean missedOne = true;
        while (indexDeck < deck.length) {
            indexResult %= result.length;
            if (result[indexResult] == 0) {
                if (indexDeck == deck.length - 1) {
                    result[indexResult] = deck[indexDeck];
                    break;
                }
                if (missedOne) {
                    result[indexResult] = deck[indexDeck++];
                    missedOne = false;
                } else {
                    missedOne = true;
                }
            }
            indexResult++;
        }
        return result;
    }

    // from walkccc.me
    public int[] deckRevealedIncreasing2(int[] deck) {
        final int n = deck.length;

        Arrays.sort(deck);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(deck[n - 1]);

        for (int i = n - 2; i >= 0; --i) {
            dq.addFirst(dq.getLast());
            dq.pollLast();
            dq.addFirst(deck[i]);
        }

        for (int i = 0; i < n; ++i)
            deck[i] = dq.pollFirst();

        return deck;
    }

}

// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21

// 1    2    3    4    5    6    7    8    9    10    11
// 1 12 2 17 3 13 4 21 5 14 6 18 7 15 8 20 9 16 10 19 11

/*
// 1 12 2 17 3 13 4 21 5 14 6 18 7 15 8 20 9 16 10 19 11
1
2 17 3 13 4 21 5 14 6 18 7 15 8 20 9 16 10 19 11 12
1 2
3 13 4 21 5 14 6 18 7 15 8 20 9 16 10 19 11 12 17
1 2 3
4 21 5 14 6 18 7 15 8 20 9 16 10 19 11 12 17 13
1 2 3 4
5 14 6 18 7 15 8 20 9 16 10 19 11 12 17 13 21
1 2 3 4 5
6 18 7 15 8 20 9 16 10 19 11 12 17 13 21 14
1 2 3 4 5 6
7 15 8 20 9 16 10 19 11 12 17 13 21 14 18
1 2 3 4 5 6 7
8 20 9 16 10 19 11 12 17 13 21 14 18 15
1 2 3 4 5 6 7 8
9 16 10 19 11 12 17 13 21 14 18 15 20
1 2 3 4 5 6 7 8 9
10 19 11 12 17 13 21 14 18 15 20 16
1 2 3 4 5 6 7 8 9 10
11 12 17 13 21 14 18 15 20 16 19
1 2 3 4 5 6 7 8 9 10 11
17 13 21 14 18 15 20 16 19 12

..здесь я понял, что число 12 тоже должно идти через одно пустое место, а не подряд после нечётных индексов.
Тогда получилось бы так:

1 2 3 4 5 6 7 8 9 10 11
12 17 13 21 14 18 15 20 16 19
1 2 3 4 5 6 7 8 9 10 11 12
13 21 14 18 15 20 16 19 17
1 2 3 4 5 6 7 8 9 10 11 12 13
14 18 15 20 16 19 17 21
1 2 3 4 5 6 7 8 9 10 11 12 13 14
15 20 16 19 17 21 18
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
16 19 17 21 18 20
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
17 21 18 20 19
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
18 20 19 21
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
19 21 20
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
20 21
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
21
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21

*/

