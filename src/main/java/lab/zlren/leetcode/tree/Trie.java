package lab.zlren.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zlren
 * @date 2018-03-22
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.wordEnd = false;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = helper(word);
        return node != null && node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        return helper(prefix) != null;
    }

    private TrieNode helper(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean wordEnd;

    public TrieNode() {
        children = new HashMap<>();
        wordEnd = false;
    }
}
