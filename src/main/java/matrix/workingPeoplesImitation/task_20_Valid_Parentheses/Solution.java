package matrix.workingPeoplesImitation.task_20_Valid_Parentheses;

import java.util.*;

class Solution {

    // my solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(' -> stack.push(ch);
                case ')' -> {
                    if (stack.empty() || stack.peek() != '(') return false;
                    else stack.pop();
                }
                case '[' -> stack.push(ch);
                case ']' -> {
                    if (stack.empty() || stack.peek() != '[') return false;
                    else stack.pop();
                }
                case '{' -> stack.push(ch);
                case '}' -> {
                    if (stack.empty() || stack.peek() != '{') return false;
                    else stack.pop();
                }
            }
        }
        return stack.empty();
    }

    // from leetcode solutions (https://leetcode.com/problems/valid-parentheses/solutions/4854521/method-hit-and-trial-it-works-every-time/) rewritten in Java by chatGPT
    public boolean isValid2(String s) {
        // Словарь для отслеживания состояния каждого типа скобок
        Map<Character, Boolean> state = new HashMap<>();
        state.put('(', true); // Инициализация всех типов скобок как открытых
        state.put('[', true);
        state.put('{', true);

        // Словарь для хранения соответствия закрывающихся скобок их соответствующим открывающимся скобкам
        Map<Character, Character> rev = new HashMap<>();
        rev.put(')', '(');
        rev.put(']', '[');
        rev.put('}', '{');

        // Преобразование входной строки в массив символов
        char[] str = s.toCharArray();
        // Стек для отслеживания открытых скобок
        Stack<Character> opened = new Stack<>();

        // Итерация по каждому символу в строке
        for (char c : str) {
            // Если символ - открывающая скобка, поместить его в стек
            if (c == '(' || c == '[' || c == '{') {
                opened.push(c);
                // Обновить состояние этого типа скобок, чтобы указать, что они открыты
                state.put(opened.peek(), false);
            } else { // Если символ - закрывающая скобка
                // Проверить, не пуст ли стек, и совпадает ли вершина стека с открывающей скобкой для этой закрывающей скобки
                if (!opened.isEmpty() && opened.pop() == rev.get(c)) {
                    // Обновить состояние соответствующей открывающей скобки, чтобы указать, что она закрыта
                    state.put(rev.get(c), true);
                } else {
                    // Если стек пуст или скобки не совпадают, строка недействительна
                    return false;
                }
            }
        }

        // После итерации по всем символам, если стек пуст, все открывающие скобки закрыты
        if (opened.isEmpty()) {
            boolean result = true;
            // Проверить каждый тип скобок, чтобы убедиться, что он закрыт
            for (boolean flag : state.values()) {
                result = flag && result;
            }
            // Вернуть true, если все типы скобок закрыты
            return result;
        }

        // Если стек не пуст, есть непарные открывающие скобки, поэтому строка недействительна
        return false;
    }


    // from leetcode solutions (https://leetcode.com/problems/valid-parentheses/solutions/3360529/best-solution-ever/) rewritten in Java by chatGPT
    // Список для хранения закрывающих скобок
    private static final List<Character> closers = Arrays.asList(')', '}', ']');

    // Метод для проверки корректности ввода
    public boolean isValid3(String s) {
        // Список для хранения символов входной строки
        List<Character> a = new ArrayList<>();
        // Преобразование входной строки в список символов
        for (char c : s.toCharArray()) {
            a.add(c);
        }
        // Список допустимых пар скобок
        List<String> b = Arrays.asList("()", "{}", "[]");

        // Проверка на чётность длины входной строки или её пустоту
        if (a.size() % 2 == 1 || a.isEmpty()) return false;
        // Проверка на допустимую пару скобок
        if (b.contains(s)) return true;

        // Итерация по символам входной строки
        for (int i = 0; i < s.length() - 1; i++) {
            // Проверка, является ли последний символ закрывающей скобкой без соответствующей ей открывающей скобки
            if (a.size() - 1 == i && !closers.contains(a.get(i))) return false;
            // Если текущий символ - закрывающая скобка
            if (closers.contains(a.get(i))) {
                // Проверка, является ли он первым символом или имеет соответствующую открывающую скобку
                if (i == 0) return false;
                // Проверка, совпадает ли текущая закрывающая скобка с предыдущей открывающей скобкой
                if (a.get(i) / 10 == a.get(i - 1) / 10) {
                    // Удаление совпадающей пары скобок из списка
                    a.remove(i - 1);
                    a.remove(i - 1);
                    // Уменьшение индекса для учёта удалённых элементов
                    i -= 2;
                    // Проверка, пуст ли список, что означает, что все скобки совпали
                    if (a.isEmpty()) return true;
                    continue;
                }
                // Если текущая закрывающая скобка не совпадает с предыдущей открывающей скобкой, строка недействительна
                return false;
            }
        }
        // Если цикл завершается без возврата, строка недействительна
        return false;
    }

    // from walkccc.me
    public boolean isValid4(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (final char c : s.toCharArray())
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;

        return stack.isEmpty();
    }

}