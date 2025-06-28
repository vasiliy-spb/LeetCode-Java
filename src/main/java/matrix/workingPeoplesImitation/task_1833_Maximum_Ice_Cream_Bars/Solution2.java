package matrix.workingPeoplesImitation.task_1833_Maximum_Ice_Cream_Bars;

// from leetcode code sample
public class Solution2 {

    // original from leetcode code sample
    public int maxIceCream0(int[] costs, int coins) {
        int max = costs[0];
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] > max) max = costs[i];
        }
        if (costs[0] > coins) return 0;
        int a = 0;
        int count = 0;

        int n = costs.length;
        int[] counting = new int[max + 1];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            counting[costs[i]]++;
        }
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[counting[costs[i]] - 1] = costs[i];
            counting[costs[i]]--;
        }
        for (int i = 0; i < n; i++) {
            costs[i] = output[i];
        }
        for (int i = 0; i < costs.length; i++) {
            if ((costs[i] + a) <= coins) {
                a += costs[i];
                count++;
            }
        }
        return count;
    }

    // refactor by me & explain from chatGPT
    public int maxIceCream(int[] costs, int coins) {
        // Ищем максимальную цену мороженого
        int max = costs[0];
        for (int cost : costs) {
            if (cost > max) max = cost;
        }

        // Если самое дешевое мороженое дороже всех монет, возвращаем 0
        if (costs[0] > coins) return 0;

        int totalCost = 0;  // Сумма, потраченная на мороженое
        int count = 0;      // Количество купленных мороженых

        int n = costs.length;

        // Массив для подсчета частот встречаемости каждой стоимости мороженого
        int[] counting = new int[max + 1];

        // Массив для хранения отсортированных значений стоимостей
        int[] output = new int[n];

        // Заполняем массив counting количеством каждого мороженого по стоимости
        for (int cost : costs) {
            counting[cost]++;
        }

        // Преобразуем counting в массив префиксных сумм, чтобы указать позиции
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // Заполняем массив output отсортированными стоимостями мороженых
        for (int i = n - 1; i >= 0; i--) {
            output[counting[costs[i]] - 1] = costs[i];  // Помещаем элемент на нужную позицию
            counting[costs[i]]--;  // Уменьшаем счетчик для данной стоимости
        }

        // Копируем отсортированные стоимости обратно в исходный массив costs
        for (int i = 0; i < n; i++) {
            costs[i] = output[i];
        }

        // Подсчитываем максимальное количество мороженых, которые можно купить
        for (int cost : costs) {
            if ((cost + totalCost) <= coins) {  // Если хватает монет
                totalCost += cost;  // Добавляем цену мороженого к общей потраченной сумме
                count++;  // Увеличиваем количество купленных мороженых
            }
        }

        return count;  // Возвращаем количество купленных мороженых
    }

}
