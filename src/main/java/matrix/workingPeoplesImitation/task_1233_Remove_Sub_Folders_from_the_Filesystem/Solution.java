package matrix.workingPeoplesImitation.task_1233_Remove_Sub_Folders_from_the_Filesystem;

import java.util.*;

// my solution
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie storage = new Trie();
        for (String f : folder) {
            storage.add(f);
        }
        List<String> ans = new ArrayList<>();
        storage.extractRootFolders(ans, storage.root, 0, new StringBuilder(), 0);
        return ans;
    }
    static final class Trie {
        TrieNode root = new TrieNode("");
        public void extractRootFolders(List<String> ans, TrieNode current, int level, StringBuilder path, int countParent) {
            for (TrieNode node : current.folders.values()) {
                if (node.isEnd) {
                    if (countParent == 0) {
                        ans.add(path + node.name);
                    } else {
                        extractRootFolders(ans, node, level + 1, new StringBuilder(path + node.name), countParent + 1);
                    }
                } else {
                    extractRootFolders(ans, node, level + 1, new StringBuilder(path + node.name), countParent);
                }
            }
        }
        private List<String> getPathList(String path) {
            List<String> pathList = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < path.length(); i++) {
                char ch = path.charAt(i);
                if (ch == '/' && !current.isEmpty()) {
                    pathList.add(current.toString());
                    current = new StringBuilder();
                }
                current.append(ch);
            }
            pathList.add(current.toString());
            return pathList;
        }
        public void add(String path) {
            List<String> folders = getPathList(path);
            TrieNode current = root;
            for (String folder : folders) {
                if (!current.folders.containsKey(folder)) {
                    current.folders.put(folder, new TrieNode(folder));
                }
                current = current.folders.get(folder);
            }
            current.isEnd = true;
        }
        static final class TrieNode {
            String name;
            Map<String, TrieNode> folders;
            int countParent;
            boolean isEnd;
            public TrieNode(String name) {
                this.name = name;
                this.folders = new HashMap<>();
            }
        }
    }
}

/*

"/a","/a/b","/c/d","/c/d/e","/c/f"

a
a b

c d
c d e
c d e t
c f



 */