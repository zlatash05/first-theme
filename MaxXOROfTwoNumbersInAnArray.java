class Solution {
    public int findMaximumXOR(int[] nums) {
        int max_xor = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max_xor = Math.max(max_xor, nums[i] ^ nums[j]);
            }
        }
        return max_xor;
    }
}


