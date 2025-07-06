package matrix.workingPeoplesImitation.task_2381_Shifting_Letters_II;

// from perplexity (Binary Indexed Tree approach)
public class Solution4 {
    // Класс Fenwick Tree для поддержки диапазонных обновлений и точечных запросов
    static class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n + 2; // +2 для безопасности границ
            tree = new int[this.n];
        }

        void update(int i, int delta) {
            i++; // BIT использует индексацию с 1
            while (i < n) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        int query(int i) {
            i++;
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= i & -i;
            }
            return res;
        }

        // Для диапазонного обновления: добавить delta на [l, r]
        void rangeUpdate(int l, int r, int delta) {
            update(l, delta);
            update(r + 1, -delta);
        }
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        BIT bit = new BIT(n);
        // Применяем все сдвиги через BIT
        for (int[] shift : shifts) {
            int l = shift[0], r = shift[1], dir = shift[2];
            int delta = dir == 1 ? 1 : -1;
            bit.rangeUpdate(l, r, delta);
        }
        // Формируем итоговую строку
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int totalShift = bit.query(i);
            int orig = arr[i] - 'a';
            // Приводим сдвиг к диапазону [0, 25]
            int shifted = (orig + totalShift % 26 + 26) % 26;
            arr[i] = (char) ('a' + shifted);
        }
        return new String(arr);
    }
}
