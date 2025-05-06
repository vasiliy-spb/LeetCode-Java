package matrix.workingPeoplesImitation.task_3076_Shortest_Uncommon_Substring_in_an_Array;

// from Microsoft Copilot
public class Solution2 {
    // Глобальный корень Trie
    private final TrieNode root = new TrieNode();

    // Основной метод для решения задания
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        // Построение глобального Trie: для каждой строки вставляем все её подстроки
        for (int i = 0; i < n; i++) {
            insertSubstrings(arr[i], i);
        }

        // Для каждой строки ищем уникальную подстроку
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = findUniqueSubstring(arr[i]);
        }
        return answer;
    }

    // Метод для вставки подстрок текущей строки с индексом wordId
    private void insertSubstrings(String word, int wordId) {
        int n = word.length();
        // Перебираем все возможные стартовые позиции
        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            // Идем по подстроке, расширяя её по одному символу
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                // Чтобы избежать повторного подсчёта для одной строки,
                // обновляем счетчик только если для этой строки узел не был затронут ранее
                if (node.lastUpdated != wordId) {
                    node.count++;
                    node.lastUpdated = wordId;
                }
            }
        }
    }

    // Метод для поиска наименьшей уникальной подстроки для слова word
    private String findUniqueSubstring(String word) {
        String best = null;
        int n = word.length();
        // Перебираем все стартовые позиции
        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            // Для каждой позиции расширяем подстроку по одному символу
            for (int j = i; j < n; j++) {
                int index = word.charAt(j) - 'a';
                node = node.children[index];
                // Если подстрока встречается только в одной строке, фиксируем кандидатуру
                if (node.count == 1) {
                    String candidate = word.substring(i, j + 1);
                    // Если кандидат первый или имеет меньшую длину, либо длины равны, и он лексикографически меньше
                    if (best == null || candidate.length() < best.length() ||
                            (candidate.length() == best.length() && candidate.compareTo(best) < 0)) {
                        best = candidate;
                    }
                    // Для данного стартового индекса дальнейшее увеличение подстроки приведёт только к более длинным вариантам
                    break;
                }
            }
        }
        return best == null ? "" : best;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0; // Число различных строк, содержащих эту подстроку
        int lastUpdated = -1; // Индекс последней строки, для которой обновляли этот узел
    }
}
