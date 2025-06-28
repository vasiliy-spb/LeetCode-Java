```Java
public int majorityElement(int[] nums) {
        // Initialize the answer and count variables
        Integer ans = null; // Use Integer to represent the potential majority element
        int count = 0; // Initialize the count of the potential majority element as 0

        // Iterate through the array using a for-each loop
        for (final int num : nums) {
            // If the count becomes zero, update the potential majority element to the current element
            // and reset the count to 1, as we have found a new potential majority candidate
            if (count == 0)
                ans = num;

            // If the current element is the same as the potential majority element, increment the count
            // If the current element is different, decrement the count
            count += num == ans ? 1 : -1;
        }

        // The final answer is the potential majority element found during the iteration
        return ans;
    }
```

## In English

The provided code implements the Boyer-Moore Voting Algorithm to find the majority element in the given array. Here's an explanation of the approach:

1. **Initialization:**
   - `ans` is an `Integer` variable initialized to `null`. It will be used to store the potential majority element.
   - `count` is an integer variable initialized to `0`. It keeps track of the count of the potential majority element.

2. **Iterating through the array:**
   - The code uses a for-each loop to iterate through each element (`num`) in the `nums` array.

3. **Updating potential majority element and count:**
   - If `count` is `0`, it means there is no current potential majority element. So, set `ans` to the current element (`num`) and reset `count` to `1`.
   - If `count` is not `0`, it means there is a potential majority element. If the current element is the same as the potential majority element (`num == ans`), increment the count; otherwise, decrement the count.
     - This step essentially simulates the process of canceling out pairs of different elements. If the current element is the potential majority element, it contributes positively to the count; otherwise, it cancels out with an element of a different value.

4. **Final Result:**
   - After iterating through the entire array, the potential majority element (`ans`) will hold the answer.

The algorithm ensures that the potential majority element is the actual majority element in the array, given the assumption that the majority element always exists. This solution is concise and efficient, running in O(n) time complexity and using O(1) space.

## На русском

Конечно! Предоставленный код реализует алгоритм голосования Бойера-Мура для поиска элемента, встречающегося в массиве чаще всего. Вот объяснение подхода:

1. **Инициализация:**
   - `ans` - это переменная типа `Integer`, инициализированная как `null`. Она будет использоваться для хранения потенциального элемента большинства.
   - `count` - это переменная типа `int`, инициализированная как `0`. Она отслеживает количество потенциальных элементов большинства.

2. **Итерация по массиву:**
   - Код использует цикл for-each для перебора каждого элемента (`num`) в массиве `nums`.

3. **Обновление потенциального элемента большинства и счетчика:**
   - Если `count` равен `0`, это означает, что текущего потенциального элемента большинства нет. Поэтому устанавливаем `ans` в текущий элемент (`num`) и сбрасываем `count` в `1`.
   - Если `count` не равен `0`, это означает, что есть потенциальный элемент большинства. Если текущий элемент такой же, как потенциальный элемент большинства (`num == ans`), увеличиваем счетчик; в противном случае уменьшаем счетчик.
     - Этот шаг в основном моделирует процесс отмены пар различных элементов. Если текущий элемент - потенциальный элемент большинства, он положительно влияет на счетчик; в противном случае он компенсируется элементом с другим значением.

4. **Итоговый результат:**
   - После прохождения всего массива потенциальный элемент большинства (`ans`) будет содержать ответ.

Алгоритм гарантирует, что потенциальный элемент большинства является фактическим элементом большинства в массиве, учитывая предположение, что элемент большинства всегда присутствует. Это решение лаконично и эффективно, выполняется за время O(n) и использует O(1) дополнительной памяти.

