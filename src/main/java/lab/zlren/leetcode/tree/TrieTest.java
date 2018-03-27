package lab.zlren.leetcode.tree;

/**
 * @author zlren
 * @date 2018-03-22
 */
public class TrieTest {

    public static void main(String[] args) {
        String[] str = new String[]{"abc", "ab", "bc", "bd", "bcc", "bcd"};
        Trie trie = new Trie();
        for (String s : str) {
            trie.insert(s);
        }

        System.out.println(trie.search("bcd"));
        System.out.println(trie.startsWith("b"));

    }

}
