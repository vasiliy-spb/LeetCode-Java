package matrix.workingPeoplesImitation.task_1405_Longest_Happy_String;

import java.util.PriorityQueue;
import java.util.Queue;

// my solution (accepted)
public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<Letter> queue = new PriorityQueue<>((l1, l2) -> Integer.compare(l2.count, l1.count));
        if (a > 0) {
            queue.offer(new Letter('a', a));
        }
        if (b > 0) {
            queue.offer(new Letter('b', b));
        }
        if (c > 0) {
            queue.offer(new Letter('c', c));
        }
        return switch (queue.size()) {
            case 1 -> String.valueOf(queue.peek().value).repeat(Math.min(2, queue.peek().count));
            case 2 -> buidString(queue.poll(), queue.poll(), new StringBuilder());
            case 3 -> buidString(queue.poll(), queue.poll(), queue.poll());
            default -> "";
        };
    }

    private String buidString(Letter letter1, Letter letter2, StringBuilder ans) {
        if (letter1.count == letter2.count) {
            return (letter1.value + "" + letter2.value).repeat(letter1.count);
        }
        letter1.count = Math.min((letter2.count) * 2 + 2, letter1.count);
        while (letter1.count > 0 || letter2.count > 0) {
            if (letter1.count > 0) {
                if (letter1.count == letter2.count * 2 + 2) {
                    ans.append(letter1.value);
                    ans.append(letter1.value);
                    letter1.count -= 2;
                } else {
                    ans.append(letter1.value);
                    letter1.count--;
                }
            }
            if (letter2.count > 0) {
                if (letter1.count - 1 < letter2.count) {
                    ans.append(letter2.value);
                    ans.append(letter2.value);
                    letter2.count -= 2;
                } else {
                    ans.append(letter2.value);
                    letter2.count--;
                }
            }
        }
        return ans.toString();
    }

    private String buidString(Letter letter1, Letter letter2, Letter letter3) {
        if (letter1.count == letter2.count && letter2.count == letter3.count) {
            return (letter1.value + "" + letter2.value + "" + letter3.value).repeat(letter1.count);
        }
        StringBuilder ans = new StringBuilder();
        if ((letter2.count + letter3.count) * 2 + 2 < letter1.count) {
            buidString(Letter.of(letter1), letter2, ans);
            while (ans.charAt(ans.length() - 1) == letter1.value) {
                ans.deleteCharAt(ans.length() - 1);
            }
            buidString(Letter.of(letter1), letter3, ans);
            return ans.toString();
        }
        letter1.count = Math.min((letter2.count + letter3.count) * 2 + 2, letter1.count);

        while (letter1.count > 0 || letter2.count > 0 || letter3.count > 0) {
            if (letter1.count > 0) {
                if (letter1.count == letter2.count * 2 + 2) {
                    ans.append(letter1.value);
                    ans.append(letter1.value);
                    letter1.count -= 2;
                } else {
                    ans.append(letter1.value);
                    letter1.count--;
                }
            }
            if (letter2.count > 0) {
                if (letter1.count - 1 < letter2.count) {
                    ans.append(letter2.value);
                    ans.append(letter2.value);
                    letter2.count -= 2;
                } else {
                    ans.append(letter2.value);
                    letter2.count--;
                }
            }
            if (letter3.count > 0) {
                if (letter1.count - 1 < letter2.count) {
                    int count = Math.min(letter3.count, 2);
                    while (count-- > 0) {
                        ans.append(letter3.value);
                        letter3.count--;
                    }
                } else {
                    ans.append(letter3.value);
                    letter3.count--;
                }
            }
        }

        return ans.toString();
    }

    static class Letter {
        char value;
        int count;

        public Letter(char value, int count) {
            this.value = value;
            this.count = count;
        }

        public static Letter of(Letter sourceLetter) {
            return new Letter(sourceLetter.value, sourceLetter.count);
        }
    }
}
