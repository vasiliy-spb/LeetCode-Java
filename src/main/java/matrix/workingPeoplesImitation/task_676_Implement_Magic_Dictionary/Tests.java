package matrix.workingPeoplesImitation.task_676_Implement_Magic_Dictionary;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    @Test
    public void checkTestcase01() {
//        MagicDictionary magicDictionary = new MagicDictionary();
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dictionary = {"hello", "leetcode"};
        magicDictionary.buildDict(dictionary);
        Boolean[] result = new Boolean[6];
        result[2] = magicDictionary.search("hello");
        result[3] = magicDictionary.search("hhllo");
        result[4] = magicDictionary.search("hell");
        result[5] = magicDictionary.search("leetcoded");
        Boolean[] expected = {null, null, false, true, false, false};
        System.out.println("result   = " + Arrays.toString(result));
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkTestcase02() {
//        MagicDictionary magicDictionary = new MagicDictionary();
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dictionary = {"hello", "hallo", "leetcode"};
        magicDictionary.buildDict(dictionary);
        Boolean[] result = new Boolean[6];
        result[2] = magicDictionary.search("hello");
        result[3] = magicDictionary.search("hallo");
        result[4] = magicDictionary.search("hell");
        result[5] = magicDictionary.search("leetcode");
        Boolean[] expected = {null, null, true, true, false, false};
        System.out.println("result   = " + Arrays.toString(result));
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, result);
    }

//    @Test
//    public void checkTestcase03() {
//
//    }
}
