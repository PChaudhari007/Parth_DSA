class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;

        // 1. Sort even indices in non-decreasing (ascending) order
        for (int i = 0; i < n; i += 2) {
            for (int j = i + 2; j < n; j += 2) {
                // Swap if the current element is greater than the forward element
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        // 2. Sort odd indices in non-increasing (descending) order
        for (int i = 1; i < n; i += 2) {
            for (int j = i + 2; j < n; j += 2) {
                // Swap if the current element is smaller than the forward element
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }
}
