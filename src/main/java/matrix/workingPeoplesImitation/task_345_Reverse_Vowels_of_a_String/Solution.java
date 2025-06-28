package matrix.workingPeoplesImitation.task_345_Reverse_Vowels_of_a_String;

public class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int l = 0;
        int r = s.length() - 1;
//        StringBuilder result = new StringBuilder(s);
//        while (l < r) {
//            while (l < result.length() && vowels.indexOf(result.charAt(l)) < 0)
//                l++;
//            while (r >= 0 && vowels.indexOf(result.charAt(r)) < 0)
//                r--;
//            if (l >= r) break;
//            char ch = result.charAt(l);
//            result.replace(l, l++ + 1, String.valueOf(result.charAt(r)));
//            result.replace(r, r-- + 1, String.valueOf(ch));
//        }
//        return result.toString();


        StringBuilder result = new StringBuilder();
        while (l < r) {
            while (l < s.length() && vowels.indexOf(s.charAt(l)) < 0) {
                result.insert(l, s.charAt(l));
                l++;
            }
            result.insert(l, s.charAt(l++));
            while (r >= 0 && vowels.indexOf(s.charAt(r)) < 0) {
                result.insert(l++, s.charAt(r));
                r--;
            }
//            if (l >= r) break;
            System.out.println("l = " + l);
            System.out.println("r = " + r);
//            result.insert(l++, s.charAt(r--));
//            l++;
//            r--;
            System.out.println("result = " + result);
            System.out.println();
        }
        System.out.println("result = " + result);
        System.out.println();
        return result.toString();
    }
}
