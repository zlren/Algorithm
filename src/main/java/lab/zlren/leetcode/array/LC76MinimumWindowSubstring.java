package lab.zlren.leetcode.array;

/**
 * @author zlren
 * @date 2017-11-08
 */
public class LC76MinimumWindowSubstring {

    public static void main(String[] args) {
        LC76MinimumWindowSubstring t = new LC76MinimumWindowSubstring();
        System.out.println(t.minWindow("ADOBECODEBANC", "BANC"));
    }

    public String minWindow(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        String ret = "";
        int retLen = Integer.MAX_VALUE;

        int[] ht = new int[256];
        for (int i = 0; i < tArray.length; i++) {
            ht[tArray[i]]++;
        }

        int[] hs = new int[256];

        // [l..r] 是滑动窗口
        int l = 0, r = -1;
        while (l <= sArray.length - 1) {

            // 每次r指针右移1位
            r++;

            if (r <= sArray.length - 1) {
                hs[sArray[r]]++;

                // 这里不能这样，应该先判断如果把l处的字符删掉是否可以满足，只有满足才能删，否则不能删
                while (cover2(hs, l, sArray, ht)) {
                    hs[sArray[l]]--;
                    l++;
                }
            } else {
                break;
            }

            if (cover(hs, ht)) {
                if (r - l + 1 < retLen) {
                    retLen = r - l + 1;
                    ret = s.substring(l, r + 1);
                }
            }
        }

        System.out.println("最短的长度是" + retLen);
        return ret;
    }

    /**
     * 判断s是不是涵盖了t
     *
     * @param hs
     * @param ht
     * @return
     */
    boolean cover(int[] hs, int[] ht) {
        for (int i = 0; i < ht.length; i++) {
            if (hs[i] < ht[i]) {
                return false;
            }
        }
        return true;
    }

    boolean cover2(int[] hs, int l, char[] sArray, int[] ht) {
        int[] bak = new int[hs.length];
        System.arraycopy(hs, 0, bak, 0, hs.length);
        bak[sArray[l]]--;
        return cover(bak, ht);
    }
}
