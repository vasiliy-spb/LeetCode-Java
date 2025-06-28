package matrix.workingPeoplesImitation.task_273_Integer_to_English_Words;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, String> secondTen = new HashMap<>() {{
        put(11, " Eleven");
        put(12, " Twelve");
        put(13, " Thirteen");
        put(14, " Fourteen");
        put(15, " Fifteen");
        put(16, " Sixteen");
        put(17, " Seventeen");
        put(18, " Eighteen");
        put(19, " Nineteen");
    }};
    HashMap<Integer, String> tens = new HashMap<>() {{
        put(1, " Ten");
        put(2, " Twenty");
        put(3, " Thirty");
        put(4, " Forty");
        put(5, " Fifty");
        put(6, " Sixty");
        put(7, " Seventy");
        put(8, " Eighty");
        put(9, " Ninety");
    }};
    HashMap<Integer, String> digits = new HashMap<>() {{
        put(0, "");
        put(1, " One");
        put(2, " Two");
        put(3, " Three");
        put(4, " Four");
        put(5, " Five");
        put(6, " Six");
        put(7, " Seven");
        put(8, " Eight");
        put(9, " Nine");
    }};


    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder result = new StringBuilder();
        int current = num % 100;
        if (current < 10) result.insert(0, digits.get(current));
        else if (current > 10 && current < 20) result.insert(0, "" + secondTen.get(current));
        else if (current % 10 == 0) result.insert(0, "" + tens.get(current / 10));
        else result.insert(0, "" + tens.get(current / 10) + "" + digits.get(current % 10));
        num = num / 100;

        if (num == 0) return result.toString().trim();

        current = num % 10;
        if (current > 0) result.insert(0, digits.get(current) + " Hundred");
        num = num / 10;

        if (num == 0) return result.toString().trim();

        current = num % 100;
        if (num % 1000 > 0) result.insert(0, " Thousand");
        if (current < 10) result.insert(0, digits.get(current));
        else if (current > 10 && current < 20) result.insert(0, "" + secondTen.get(current));
        else if (current % 10 == 0) result.insert(0, "" + tens.get(current / 10));
        else result.insert(0, "" + tens.get(current / 10) + "" + digits.get(current % 10));
        num = num / 100;

        if (num == 0) return result.toString().trim();

        current = num % 10;
        if (current > 0) result.insert(0, digits.get(current) + " Hundred");
        num = num / 10;

        if (num == 0) return result.toString().trim();

        current = num % 100;
        if (num % 1000 > 0) result.insert(0, " Million");
        if (current < 10) result.insert(0, digits.get(current));
        else if (current > 10 && current < 20) result.insert(0, "" + secondTen.get(current));
        else if (current > 0) {
            if (current % 10 == 0) result.insert(0, "" + tens.get(current / 10));
            else result.insert(0, "" + tens.get(current / 10) + "" + digits.get(current % 10));
        }
        num = num / 100;

        if (num == 0) return result.toString().trim();

        current = num % 10;
        if (current > 0) result.insert(0, digits.get(current) + " Hundred");
        num = num / 10;

        if (num == 0) return result.toString().trim();

        current = num % 10;
        if (current > 0) result.insert(0, digits.get(num) + " Billion");

        return result.toString().trim();
    }


    // from walkccc.me
    public String numberToWords2(int num) {
        return num == 0 ? "Zero" : helper(num);
    }

    private final String[] belowTwenty = {"",        "One",     "Two",       "Three",    "Four",
            "Five",    "Six",     "Seven",     "Eight",    "Nine",
            "Ten",     "Eleven",  "Twelve",    "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens2 = {"",      "",      "Twenty",  "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private String helper(int num) {
        StringBuilder s = new StringBuilder();

        if (num < 20)
            s.append(belowTwenty[num]);
        else if (num < 100)
            s.append(tens2[num / 10]).append(" ").append(belowTwenty[num % 10]);
        else if (num < 1000)
            s.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        else if (num < 1000000)
            s.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        else if (num < 1000000000)
            s.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        else
            s.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));

        return s.toString().trim();
    }

    // from leetcode code sample
    private String oneDigit(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }

    private String elevenSeries(int num){
        switch(num){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }

    private String twoDigit(int num){
        int quotient = num/10;
        if(quotient == 1) return elevenSeries(num);
        if(quotient == 0) return oneDigit(num);
        StringBuilder sb = new StringBuilder();
        switch(quotient){
            case 2: sb.append("Twenty");
                break;
            case 3: sb.append("Thirty");
                break;
            case 4: sb.append("Forty");
                break;
            case 5: sb.append("Fifty");
                break;
            case 6: sb.append("Sixty");
                break;
            case 7: sb.append("Seventy");
                break;
            case 8: sb.append("Eighty");
                break;
            case 9: sb.append("Ninety");
                break;
            default: sb.append("");
                break;
        }
        int remainder = num%10;
        if(remainder == 0) return sb.toString();
        sb.append(" ");
        sb.append(oneDigit(remainder));
        return sb.toString();
    }

    private String threeDigit(int num){
        int quotient = num/100;
        StringBuilder sb = new StringBuilder();
        if(quotient == 0) return twoDigit(num);
        sb.append(oneDigit(quotient));
        sb.append(" Hundred");
        int remainder = num%100;
        if(remainder == 0) return sb.toString();
        sb.append(" ");
        sb.append(twoDigit(remainder));
        return sb.toString();
    }

    public String numberToWords3(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int billions = num/1000000000;
        if(billions != 0){
            sb.append(threeDigit(billions));
            sb.append(" Billion");
        }
        int remainder = num % 1000000000;
        if(remainder == 0) return sb.toString();

        int millions = remainder/1000000;
        if(millions != 0){

            if(sb.length()!= 0) sb.append(" ");
            sb.append(threeDigit(millions));
            sb.append(" Million");
        }
        remainder = num % 1000000;
        if(remainder == 0) return sb.toString();

        int thousands = remainder/1000;
        if(thousands != 0){
            if(sb.length()!= 0) sb.append(" ");
            sb.append(threeDigit(thousands));
            sb.append(" Thousand");
        }
        remainder = num % 1000;
        if(remainder == 0) return sb.toString();
        if(sb.length()!= 0) sb.append(" ");

        sb.append(threeDigit(remainder));
        return sb.toString();
    }
}
