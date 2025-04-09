package matrix.workingPeoplesImitation.task_3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct;

import java.util.HashSet;
import java.util.Set;

// from walkccc.me
public class Solution4 {
    public int minimumOperations(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; --i)
            if (!seen.add(nums[i]))
                return (i + 1 + 2) / 3; // ceil((i + 1) / 3)
        return 0;
    }
}
/* from DeepSeek:
Почему (i + 1 + 2) / 3?
— i + 1 — это количество элементов от начала массива до текущего индекса i (включительно).
  Например, если i = 2, то элементов 3 (индексы 0, 1, 2).
— Нам нужно вычислить, сколько операций потребуется, чтобы удалить эти i + 1 элементов,
  если в каждой операции мы удаляем 3 элемента.
— Формула для вычисления количества операций — это округление вверх от деления (i + 1) / 3.
— В математике ceil(a / b) можно выразить как (a + b - 1) / b. Здесь b = 3, поэтому:
  ceil((i+1)/3)=(i+1+2)/3
 */