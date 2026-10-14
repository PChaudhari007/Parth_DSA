
import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();

        backtrack(arr, 0, ans);

        return ans;
    }

    void backtrack(char[] arr, int index, List<String> ans) {
        if (index == arr.length) {
            ans.add(new String(arr));
            return;
        }

        if (Character.isLetter(arr[index])) {
            // Choice 1: lowercase
            arr[index] = Character.toLowerCase(arr[index]);
            backtrack(arr, index + 1, ans);

            // Choice 2: uppercase
            arr[index] = Character.toUpperCase(arr[index]);
            backtrack(arr, index + 1, ans);
        } else {
            // Digit stays unchanged
            backtrack(arr, index + 1, ans);
        }
    }
}
