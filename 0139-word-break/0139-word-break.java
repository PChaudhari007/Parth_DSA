
import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        for (String word : wordDict) {
            insert(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {

            if (!dp[i]) continue;

            TrieNode curr = root;

            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';

                if (curr.children[idx] == null) {
                    break;
                }

                curr = curr.children[idx];

                if (curr.isEnd) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }
}
