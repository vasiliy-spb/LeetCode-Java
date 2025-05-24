package matrix.workingPeoplesImitation.task_2942_Find_Words_Containing_Character;

import java.util.List;
import java.util.stream.IntStream;

// my solution
public class Solution2 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        return IntStream.range(0, words.length)
                .filter(i -> words[i].indexOf(x) >= 0)
                .boxed()
                .toList();
    }
}
