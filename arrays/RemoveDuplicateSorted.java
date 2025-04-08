// leetcode 26

class Solution {
  public int removeDuplicates(int[] nums) {
    int totalUnique = 1;

    int currentUnique = nums[0];
    int requiredIndex = 1;
    for (int i = 1; i < nums.length; i++) {
      if (currentUnique == nums[i]) {
        continue;
      }
      if (currentUnique != nums[i] && nums[i] > currentUnique && i == requiredIndex) {
        totalUnique++;
        currentUnique = nums[i];
        requiredIndex++;
        continue;
      }
      int temp = nums[i];
      nums[i] = nums[requiredIndex];
      nums[requiredIndex] = temp;
      requiredIndex++;
      totalUnique++;
      currentUnique = temp;
    }
    return totalUnique;
  }
}
