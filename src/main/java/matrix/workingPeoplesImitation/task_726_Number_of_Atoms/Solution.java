package matrix.workingPeoplesImitation.task_726_Number_of_Atoms;

import java.util.*;

public class Solution {

    // my solution
    public String countOfAtoms(String formula) {
//        System.out.println("formula = " + formula);
        Map<Atom, Integer> atomMap = new TreeMap<>((a1, a2) -> {
            if (a1.name.charAt(0) == a2.name.charAt(0)) {
                if (a1.name.length() == a2.name.length()) {
                    int n = a1.name.length();
                    if (n == 1) return a1.name.charAt(0) - a2.name.charAt(0);
                    else return a1.name.charAt(1) - a2.name.charAt(1);
                }
                return a1.name.length() - a2.name.length();
            }
            return a1.name.charAt(0) - a2.name.charAt(0);
        });
        final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder longFormula = new StringBuilder(formula);

        while (longFormula.indexOf(")") > 0) {
            StringBuilder temp = new StringBuilder();
            int end = longFormula.indexOf(")");
            int start = longFormula.lastIndexOf("(", end);
//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
            int numIndex = end + 1;
            while (numIndex < longFormula.length() && Character.isDigit(longFormula.charAt(numIndex))) {
                numIndex++;
            }
            numIndex--;
            temp.append(longFormula.substring(0, start));
            String tail;
//            System.out.println("numIndex = " + numIndex);
            if (numIndex - end > 0 && numIndex < longFormula.length()) {
                tail = longFormula.substring(numIndex + 1);
                numIndex = Integer.parseInt(longFormula.substring(end + 1, numIndex + 1));
                calculateAtoms(longFormula.substring(start + 1, end), atomMap, ABC, numIndex);
                temp.append(getShortFormula(atomMap));
                atomMap.clear();
            } else {
                calculateAtoms(longFormula.substring(start + 1, end), atomMap, ABC, 1);
                temp.append(getShortFormula(atomMap));
                atomMap.clear();
                tail = longFormula.substring(end + 1);
            }
            temp.append(tail);
            longFormula = temp;
        }
        calculateAtoms(longFormula.toString(), atomMap, ABC, 1);
        return getShortFormula(atomMap);
    }

    private String getShortFormula(Map<Atom, Integer> atomMap) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Atom, Integer> atom : atomMap.entrySet()) {
            result.append(atom.getKey().name);
            if (atom.getValue() > 1) result.append(atom.getValue());
        }
//        System.out.println("getShortFormula result = " + result);
        return result.toString();
    }

    private void calculateAtoms(String formula, Map<Atom, Integer> atomMap, String ABC, int multiply) {
        for (int i = 0; i < formula.length(); ) {
            StringBuilder atomName = new StringBuilder();
            while (i < formula.length() && !Character.isDigit(formula.charAt(i))) {
                atomName.append(formula.charAt(i++));
                if (i == formula.length() || ABC.indexOf(formula.charAt(i)) >= 0) break;
            }
            Atom atom = null;
            for (Atom a : atomMap.keySet())
                if (a.name.contentEquals(atomName)) atom = a;
            if (atom == null) atom = new Atom(atomName.toString());
            StringBuilder atomNum = new StringBuilder();
            while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                atomNum.append(formula.charAt(i++));
            }
            int num;
            if (atomNum.length() == 0) {
                num = 1;
            } else {
                num = Integer.parseInt(atomNum.toString());
            }
            num *= multiply;
            atomMap.merge(atom, num, Integer::sum);
        }
    }

    class Atom {
        String name;

        public Atom() {
        }

        public Atom(String name) {
            this.name = name;
        }

    }

    // from walkccc.me
    public String countOfAtoms1(String formula) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> count = parse(formula);

        for (final String elem : count.keySet())
            sb.append(elem + (count.get(elem) == 1 ? "" : String.valueOf(count.get(elem))));

        return sb.toString();
    }

    private int i = 0;

    private Map<String, Integer> parse(String s) {
        Map<String, Integer> count = new TreeMap<>();

        while (i < s.length())
            if (s.charAt(i) == '(') {
                ++i; // Skip '('
                for (Map.Entry<String, Integer> entry : parse(s).entrySet()) {
                    final String elem = entry.getKey();
                    final int freq = entry.getValue();
                    count.merge(elem, freq, Integer::sum);
                }
            } else if (s.charAt(i) == ')') {
                ++i; // Skip ')'
                final int num = getNum(s);
                for (final String elem : count.keySet()) {
                    final int freq = count.get(elem);
                    count.put(elem, freq * num);
                }
                return count; // Return back to the previous scope.
            } else {
                final String elem = getElem(s);
                final int num = getNum(s);
                count.merge(elem, num, Integer::sum);
            }

        return count;
    }

    private String getElem(final String s) {
        final int elemStart = i++; // `s[elemStart]` is uppercased.
        while (i < s.length() && Character.isLowerCase(s.charAt(i)))
            ++i;
        return s.substring(elemStart, i);
    }

    private int getNum(final String s) {
        final int numStart = i;
        while (i < s.length() && Character.isDigit(s.charAt(i)))
            ++i;
        final String numString = s.substring(numStart, i);
        return numString.isEmpty() ? 1 : Integer.parseInt(numString);
    }

}
