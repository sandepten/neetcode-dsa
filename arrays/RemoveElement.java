// Leetcode 27 - Remove Element

class Solution {
    public int removeElement(int[] nums, int val) {
        int totalNonVal = 0, placeIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[placeIndex];
            nums[placeIndex] = temp;
            totalNonVal++;
            placeIndex++;
        }

        return totalNonVal;
    }
}
