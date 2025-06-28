## Approach #1: Recursion [Accepted]

### Intuition and Algorithm

Write a function parse that parses the formula from index i, returning a map count from names to multiplicities (the number of times that name is recorded).

We will put i in the global state: our parse function increments i throughout any future calls to parse.

* When we see a '(', we will parse whatever is inside the brackets (up to the closing ending bracket) and add it to our count.

* Otherwise, we should see an uppercase character: we will parse the rest of the letters to get the name, and add that (plus the multiplicity if there is one.)

* At the end, if there is a final multiplicity (representing the multiplicity of a bracketed sequence), we'll multiply our answer by this.

Java

```Java
class Solution {
    int i;
    public String countOfAtoms(String formula) {
        StringBuilder ans = new StringBuilder();
        i = 0;
        Map<String, Integer> count = parse(formula);
        for (String name: count.keySet()) {
            ans.append(name);
            int multiplicity = count.get(name);
            if (multiplicity > 1) {
                ans.append("" + multiplicity);
            }
        }
        return new String(ans);
    }

    public Map<String, Integer> parse(String formula) {
        int N = formula.length();
        Map<String, Integer> count = new TreeMap();
        while (i < N && formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                i++;
                for (Map.Entry<String, Integer> entry: parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                count.put(name, count.getOrDefault(name, 0) + multiplicity);
            }
        }
        int iStart = ++i;
        while (i < N && Character.isDigit(formula.charAt(i))) {
            i++;
        }            
        if (iStart < i) {
            int multiplicity = Integer.parseInt(formula.substring(iStart, i));
            for (String key: count.keySet()) {
                count.put(key, count.get(key) * multiplicity);
            }
        }
        return count;
    }
}
```

### Complexity Analysis

    Time Complexity: O(N^2), where N is the length of the formula. It is O(N) to parse through the formula, but each of O(N) multiplicities after a bracket may increment the count of each name in the formula (inside those brackets), leading to an O(N^2) complexity.

    Space Complexity: O(N). We aren't recording more intermediate information than what is contained in the formula.

---

## Approach #2: Stack [Accepted]

### Intuition and Algorithm

Instead of recursion, we can simulate the call stack by using a stack of counts directly.

Java

```Java
class Solution {
    public String countOfAtoms(String formula) {
        int N = formula.length();
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());

        for (int i = 0; i < N;) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                int iStart = ++i, multiplicity = 1;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > iStart) {
                    multiplicity = Integer.parseInt(formula.substring(iStart, i));
                }
                for (String c: top.keySet()) {
                    int v = top.get(c);
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1) {
                ans.append("" + multiplicity);
            }
        }
        return new String(ans);
    }
}
```

### Complexity Analysis

    Time Complexity O(N^2), and Space Complexity O(N). The analysis is the same as Approach #1.

---

## Approach #3: Regular Expressions [Accepted]

### Intuition and Algorithm

Whenever parsing is involved, we can use regular expressions, a language for defining patterns in text.

Our regular expression will be "([A-Z][a-z]*)(\d*)|(\()|(\))(\d*)". Breaking this down by capture group, this is:

* ([A-Z][a-z]*) Match an uppercase character followed by any number of lowercase characters, then ((\d*)) matches any number of digits.
* OR, (\() match a left bracket or (\)) right bracket, then (\d*) match any number of digits.

Now we can proceed as in Approach #2.

* If we parsed a name and multiplicity ([A-Z][a-z]*)(\d*), we will add it to our current count.

* If we parsed a left bracket, we will append a new count to our stack, representing the nested depth of parentheses.

* If we parsed a right bracket (and possibly another multiplicity), we will multiply our deepest level count, top = stack.pop(), and add those entries to our current count.

Java

```Java
import java.util.regex.*;

class Solution {
    public String countOfAtoms(String formula) {
        Matcher matcher = Pattern.compile("([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)").matcher(formula);
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());

        while (matcher.find()) {
            String match = matcher.group();
            if (match.equals("(")) {
                stack.push(new TreeMap());
            } else if (match.startsWith(")")) {
                Map<String, Integer> top = stack.pop();
                int multiplicity = match.length() > 1 ? Integer.parseInt(match.substring(1, match.length())) : 1;
                for (String name: top.keySet()) {
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + top.get(name) * multiplicity);
                }
            } else {
                int i = 1;
                while (i < match.length() && Character.isLowerCase(match.charAt(i))) {
                    i++;
                }
                String name = match.substring(0, i);
                int multiplicity = i < match.length() ? Integer.parseInt(match.substring(i, match.length())) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            ans.append(name);
            final int count = stack.peek().get(name);
            if (count > 1) {
                ans.append(String.valueOf(count));
            }
        }
        return ans.toString();
    }
}
```

### Complexity Analysis

    Time Complexity O(N^2), and Space Complexity O(N). The analysis is the same as Approach #1, as this regular expression did not look backward when parsing.
