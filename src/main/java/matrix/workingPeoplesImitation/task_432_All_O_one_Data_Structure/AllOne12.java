package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

// from leetcode code sample (9)
public class AllOne12 {
    TrieNode head;

    public AllOne12() {
        head = new TrieNode();
    }

    public void inc(String key) {
        int n = key.length();
        TrieNode node = head;
        for (int i = 0; i < n; ++i) {
            char x = key.charAt(i);
            if (node.next[(int) x - (int) 'a'] == null) {
                TrieNode newNode = new TrieNode();
                newNode.parent = node;
                newNode.character = x;
                node.next[(int) x - (int) 'a'] = newNode;
            }
            node = node.next[(int) x - (int) 'a'];
        }
        node.frequency++;
        reCalculateMaxAndMin(node);
    }

    public void dec(String key) {
        int n = key.length();
        TrieNode node = head;
        for (int i = 0; i < n; ++i) {
            char x = key.charAt(i);
            node = node.next[(int) x - (int) 'a'];
        }
        node.frequency--;
        reCalculateMaxAndMin(node);
    }

    private void reCalculateMaxAndMin(TrieNode node) {
        while (node != null) {
            TrieNode mx = null;
            int mxfreq = -10000000;
            TrieNode mn = null;
            int mnFreq = 10000000;
            if (node.frequency > 0) {
                mn = node;
                mx = node;
                mnFreq = node.frequency;
                mxfreq = node.frequency;
            }
            for (int i = 0; i < 26; ++i) {
                if (node.next[i] != null) {
                    if (node.next[i].max != null && node.next[i].max.frequency > mxfreq) {
                        mxfreq = node.next[i].max.frequency;
                        mx = node.next[i].max;
                    }
                    if (node.next[i].min != null && node.next[i].min.frequency < mnFreq) {
                        mnFreq = node.next[i].min.frequency;
                        mn = node.next[i].min;
                    }
                }
            }
            node.max = mx;
            node.min = mn;
            node = node.parent;
        }
    }

    public String getMaxKey() {
        TrieNode maxNode = head.max;
        StringBuilder result = new StringBuilder("");
        if (maxNode == null) return "";
        while (maxNode != head) {
            result = result.append(Character.toString((char) maxNode.character));
            maxNode = maxNode.parent;
        }
        result = result.reverse();
        return result.toString();
    }

    public String getMinKey() {
        TrieNode minNode = head.min;
        StringBuilder result = new StringBuilder("");
        if (minNode == null) return "";
        while (minNode != head) {
            result = result.append(Character.toString((char) minNode.character));
            minNode = minNode.parent;
        }
        result = result.reverse();
        return result.toString();
    }

    static class TrieNode {
        TrieNode[] next;
        int frequency;
        TrieNode max;
        TrieNode min;
        TrieNode parent;
        int character;

        public TrieNode() {
            next = new TrieNode[26];
            frequency = 0;
            character = -1;
        }
    }
}
