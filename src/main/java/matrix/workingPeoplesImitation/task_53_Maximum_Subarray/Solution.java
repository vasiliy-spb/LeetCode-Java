package matrix.workingPeoplesImitation.task_53_Maximum_Subarray;

import java.util.Arrays;

public class Solution {

    // my solution
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int current = 0;
        for (int num : nums) {
            current += num;
            sum = Math.max(current, sum);
            current = Math.max(current, 0);
        }
        return sum;
    }

    // from walkccc.me (Approach 1: 1D DP)
    public int maxSubArray2(int[] nums) {
        // dp[i] := the maximum sum subarray ending in i
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; ++i)
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

        return Arrays.stream(dp).max().getAsInt();
    }

    // from walkccc.me (Approach 2: O(1)O(1) DP)
    public int maxSubArray3(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (final int num : nums) {
            sum = Math.max(num, sum + num);
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    // from walkccc.me (Approach 3: Divide and Conquer) + comments from GPT
    // Main method to find the maximum subarray sum using divide and conquer approach
    public int maxSubArray4(int[] nums) {
        // Call divideAndConquer method to compute the maximum subarray sum
        // Start with the entire array, from index 0 to length - 1
        return divideAndConquer(nums, 0, nums.length - 1).maxSubarraySum;
    }

    // Helper method that implements the divide and conquer algorithm
    private T divideAndConquer(int[] nums, int l, int r) {
        // Base case: if left index equals right index, we have reached a single element
        if (l == r)
            // In this case, create a new T object with all sums equal to the single element
            return new T(nums[l], nums[l], nums[l], nums[l]);

        // Calculate the middle index of the current subarray
        final int m = (l + r) / 2;
        // Recursively call divideAndConquer for the left half of the array
        final T t1 = divideAndConquer(nums, l, m);
        // Recursively call divideAndConquer for the right half of the array
        final T t2 = divideAndConquer(nums, m + 1, r);

        // Calculate the maximum subarray sum for the left half
        final int maxSubarraySumLeft = Math.max(t1.maxSubarraySumLeft, t1.sum + t2.maxSubarraySumLeft);
        // Calculate the maximum subarray sum for the right half
        final int maxSubarraySumRight =
                Math.max(t1.maxSubarraySumRight + t2.sum, t2.maxSubarraySumRight);
        // Calculate the maximum subarray sum considering both left and right halves
        final int maxSubarraySum = Math.max(t1.maxSubarraySumRight + t2.maxSubarraySumLeft,
                Math.max(t1.maxSubarraySum, t2.maxSubarraySum));
        // Calculate the total sum of the current subarray
        final int sum = t1.sum + t2.sum;
        // Return a new T object with all computed sums
        return new T(maxSubarraySumLeft, maxSubarraySumRight, maxSubarraySum, sum);
    }

    // Define a record T to store various sums related to the subarray
    private record T(
            // The sum of the subarray starting from the first number
            int maxSubarraySumLeft,
            // The sum of the subarray ending in the last number
            int maxSubarraySumRight,
            // The maximum subarray sum overall
            int maxSubarraySum,
            // The total sum of the subarray
            int sum) {
    }
    /*
    Explanation:

    — The maxSubArray method serves as the entry point, calling the divideAndConquer method with the entire array.
    — The divideAndConquer method splits the array into halves recursively until reaching single elements.
    — For each subarray, it calculates various sums (maxSubarraySumLeft, maxSubarraySumRight, maxSubarraySum, and sum) and returns them in a T object.
    — These sums are then used to compute the maximum subarray sum considering both left and right halves.
    — Finally, the maxSubarraySum from the T object of the entire array is returned as the result.
     */

    // на русском
    // Основной метод для нахождения максимальной суммы подмассива с использованием подхода "разделяй и властвуй"
    public int maxSubArray5(int[] nums) {
        // Вызываем метод divideAndConquer для вычисления максимальной суммы подмассива
        // Начинаем с целого массива, от индекса 0 до длины - 1
        return divideAndConquer(nums, 0, nums.length - 1).maxSubarraySum;
    }

    // Вспомогательный метод, реализующий алгоритм "разделяй и властвуй"
    private T2 divideAndConquer2(int[] nums, int l, int r) {
        // Базовый случай: если левый индекс равен правому индексу, мы достигли одного элемента
        if (l == r)
            // В этом случае создаем новый объект T со всеми суммами, равными одному элементу
            return new T2(nums[l], nums[l], nums[l], nums[l]);

        // Вычисляем средний индекс текущего подмассива
        final int m = (l + r) / 2;
        // Рекурсивно вызываем divideAndConquer для левой половины массива
        final T2 t1 = divideAndConquer2(nums, l, m);
        // Рекурсивно вызываем divideAndConquer для правой половины массива
        final T2 t2 = divideAndConquer2(nums, m + 1, r);

        // Вычисляем максимальную сумму подмассива для левой половины
        final int maxSubarraySumLeft = Math.max(t1.maxSubarraySumLeft, t1.sum + t2.maxSubarraySumLeft);
        // Вычисляем максимальную сумму подмассива для правой половины
        final int maxSubarraySumRight =
                Math.max(t1.maxSubarraySumRight + t2.sum, t2.maxSubarraySumRight);
        // Вычисляем максимальную сумму подмассива, учитывая обе половины
        final int maxSubarraySum = Math.max(t1.maxSubarraySumRight + t2.maxSubarraySumLeft,
                Math.max(t1.maxSubarraySum, t2.maxSubarraySum));
        // Вычисляем общую сумму текущего подмассива
        final int sum = t1.sum + t2.sum;
        // Возвращаем новый объект T с вычисленными суммами
        return new T2(maxSubarraySumLeft, maxSubarraySumRight, maxSubarraySum, sum);
    }

    // Определяем запись T для хранения различных сумм, связанных с подмассивом
    private record T2(
            // Сумма подмассива, начинающегося с первого числа
            int maxSubarraySumLeft,
            // Сумма подмассива, заканчивающегося последним числом
            int maxSubarraySumRight,
            // Максимальная сумма подмассива в целом
            int maxSubarraySum,
            // Общая сумма подмассива
            int sum) {
    }
    /*
        Объяснение:

    - Метод `maxSubArray` служит входной точкой, вызывая метод `divideAndConquer` с целым массивом.
    - Метод `divideAndConquer` разбивает массив на половины рекурсивно до достижения одного элемента.
    - Для каждого подмассива вычисляются различные суммы (`maxSubarraySumLeft`, `maxSubarraySumRight`, `maxSubarraySum` и `sum`) и возвращаются в объекте `T`.
    - Эти суммы затем используются для вычисления максимальной суммы подмассива, учитывая и левую, и правую половины.
    - Наконец, возвращается `maxSubarraySum` из объекта `T` целого массива в качестве результата.

     */
}
