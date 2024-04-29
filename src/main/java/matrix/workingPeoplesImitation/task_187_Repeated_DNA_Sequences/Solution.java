package matrix.workingPeoplesImitation.task_187_Repeated_DNA_Sequences;

import java.util.*;

public class Solution {

    // my solution
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        Map<String, Integer> subsequenceCount = new HashMap<>();
        StringBuilder subsequence = new StringBuilder(s.substring(0, 10));
        subsequenceCount.merge(subsequence.toString(), 1, Integer::sum);
        for (int i = 10; i < s.length(); i++) {
            subsequence.deleteCharAt(0);
            subsequence.append(s.charAt(i));
            subsequenceCount.merge(subsequence.toString(), 1, Integer::sum);
        }
        return subsequenceCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    // from walkccc.me
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> ans = new HashSet<>();
        Set<String> seen = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); ++i) {
            final String seq = s.substring(i, i + 10);
            if (seen.contains(seq))
                ans.add(seq);
            seen.add(seq);
        }

        return new ArrayList<>(ans);
    }

    // from leetcode code samples
    public List<String> findRepeatedDnaSequences3(String s) {
        short[] t = new short[1048576];
        List<String> result = new LinkedList<>();
        if (s.length() < 11) return result;
        int hash = 0;
        char[] ca = s.toCharArray();
        for (int i = 0; i < 10; i++){
            switch (ca[i]) {
                case 'A' -> hash = (hash << 2);
                case 'C' -> hash = (hash << 2) + 1;
                case 'G' -> hash = (hash << 2) + 2;
                case 'T' -> hash = (hash << 2) + 3;
            }
        }
        t[hash]++;
        int i = 10;
        while (i < s.length()){
            switch (ca[i]) {
                case 'A' -> hash = (hash << 2) & 1048575;
                case 'C' -> hash = ((hash << 2) + 1) & 1048575;
                case 'G' -> hash = ((hash << 2) + 2) & 1048575;
                case 'T' -> hash = ((hash << 2) + 3) & 1048575;
            }
            if (t[hash] == 1){
                result.add(s.substring(i - 9, i + 1));
            }
            t[hash]++;
            i++;
        }
        return result;
    }

    // from leetcode code samples
    int ctoi(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return 0;
    }

    public List<String> findRepeatedDnaSequences4(String s) {
        if (s.length() <= 10)
            return Collections.emptyList();

        int cur = 0;

        BitSet s1 = new BitSet();
        BitSet s2 = new BitSet();

        List<String> res = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            cur = (cur << 2) + ctoi(s.charAt(i));

        s1.set(cur);

        for (int i = 10; i < s.length(); i++) {
            cur = ((cur << 2) & 0x0FFFFF) + ctoi(s.charAt(i));

            if (s1.get(cur)) {
                if (!s2.get(cur)) {
                    s2.set(cur);
                    res.add(s.substring(i - 9, i + 1));
                }
            }
            else
                s1.set(cur);
        }

        return res;
    }

    // from leetcode code samples
    public List<String> findRepeatedDnaSequences5(String s) {
        List<String> result = new ArrayList<>();
        int[] counts = new int[1048576];
        int[] encode = new int[26];
        encode['A' - 'A'] = 0;
        encode['C' - 'A'] = 1;
        encode['G' - 'A'] = 2;
        encode['T' - 'A'] = 3;
        int encodeS = 0;
        for (int i = 0; i < s.length(); i++) {
            encodeS <<= 2;
            encodeS |= encode[s.charAt(i) - 'A'];
            if (i >= 9) {
                encodeS &= 0xfffff;
                counts[encodeS]++;
                if (counts[encodeS] == 2) {
                    result.add(s.substring(i - 9, i + 1));
                }
            }
        }
        return result;
    }

    // from leetcode code samples
    private static final int[] DIGITS;

    private static final int E4_9 = 262_144;

    // A - 65
    // C - 67
    // G - 71
    // T - 84
    static {
        DIGITS = new int[85];
        DIGITS[65] = 0;
        DIGITS[67] = 1;
        DIGITS[71] = 2;
        DIGITS[84] = 3;
    }

    private static int getIndex(String s) {
        int result = 0;

        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            result = 4*result + DIGITS[(int) c];
        }

        return result;
    }

    public List<String> findRepeatedDnaSequences6(String s) {
        List<String> results = new ArrayList(512);
        int[] counts = new int[1_048_576];

        int n = s.length() - 9;

        int code = 0;

        for (int i = 0; i < Math.min(s.length(), 10); i++) {
            char c = s.charAt(i);
            code = 4*code + DIGITS[(int) c];
        }
        counts[code]++;

        for (int i = 1; i < n; i++) {
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + 9);

            code -= E4_9 * DIGITS[(int) prev];
            code *= 4;
            code += DIGITS[(int) next];

            counts[code]++;

            if (counts[code] == 2) {
                results.add(s.substring(i, i + 10));
            }
        }

        return results;
    }

    // from leetcode code samples
    private static final int[] codes;

    // A - 65
    // C - 67
    // G - 71
    // T - 84
    static {
        codes = new int[100];
        codes[65] = 0;
        codes[67] = 1;
        codes[71] = 2;
        codes[84] = 3;
    }

    private static int getIndex2(String s) {
        int result = 0;

        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            result = 4*result + codes[(int) c];
        }

        return result;
    }

    public List<String> findRepeatedDnaSequences7(String s) {
        List<String> results = new ArrayList(512);
        int[] counts = new int[1_048_576];

        int n = s.length() - 9;

        for (int i = 0; i < n; i++) {
            String k = s.substring(i, i + 10);
            int index = getIndex2(k);
            counts[index]++;

            if (counts[index] == 2) {
                results.add(k);
            }
        }

        return results;
    }

    // from leetcode code samples
    public List<String> findRepeatedDnaSequence8(String s) {
        // 先把字符串转化成四进制的数字数组
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
        // 记录重复出现的哈希值
        HashSet<Integer> seen = new HashSet<>();
        // 记录重复出现的字符串结果
        HashSet<String> res = new HashSet<>();

        // 数字位数
        int L = 10;
        // 进制
        int R = 4;
        // 存储 R^(L - 1) 的结果
        int RL = (int) Math.pow(R, L - 1);
        // 维护滑动窗口中字符串的哈希值
        int windowHash = 0;

        // 滑动窗口代码框架，时间 O(N)
        int left = 0, right = 0;
        while (right < nums.length) {
            // 扩大窗口，移入字符，并维护窗口哈希值（在最低位添加数字）
            windowHash = R * windowHash + nums[right];
            right++;

            // 当子串的长度达到要求
            if (right - left == L) {
                // 根据哈希值判断是否曾经出现过相同的子串
                if (seen.contains(windowHash)) {
                    // 当前窗口中的子串是重复出现的
                    res.add(s.substring(left, right));
                } else {
                    // 当前窗口中的子串之前没有出现过，记下来
                    seen.add(windowHash);
                }
                // 缩小窗口，移出字符，并维护窗口哈希值（删除最高位数字）
                windowHash = windowHash - nums[left] * RL;
                left++;
            }
        }
        // 转化成题目要求的 List 类型
        return new LinkedList<>(res);
    }

    // from leetcode code samples
    public List<String> findRepeatedDnaSequences9(String s) {
        int L = 10, n = s.length();
        if (n <= L) return new ArrayList();

        // rolling hash parameters: base a
        int a = 4, aL = (int)Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

        int h = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute hash of the current sequence in O(1) time
            if (start != 0)
                h = h * a - nums[start - 1] * aL + nums[start + L - 1];

                // compute hash of the first sequence in O(L) time
            else
                for(int i = 0; i < L; ++i) h = h * a + nums[i];

            // update output and hashset of seen sequences
            if (seen.contains(h)) output.add(s.substring(start, start + L));
            seen.add(h);
        }
        return new ArrayList<String>(output);
    }

    // from leetcode code samples
    public List<String> findRepeatedDnaSequences10(String s) {
        int L = 10, n = s.length();
        if (n <= L) return new ArrayList();

        // rolling hash parameters: base a
        int a = 4, aL = (int)Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

        int bitmask = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute bitmask of the current sequence in O(1) time
            if (start != 0) {
                // left shift to free the last 2 bit
                bitmask <<= 2;

                // add a new 2-bits number in the last two bits
                bitmask |= nums[start + L - 1];

                // unset first two bits: 2L-bit and (2L + 1)-bit
                bitmask &= ~(3 << 2 * L);
            }

            // compute hash of the first sequence in O(L) time
            else {
                for(int i = 0; i < L; ++i) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }

            // update output and hashset of seen sequences
            if (seen.contains(bitmask)) output.add(s.substring(start, start + L));
            seen.add(bitmask);
        }
        return new ArrayList<String>(output);
    }

    // from leetcode code samples


}
