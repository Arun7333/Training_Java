package Day6.JavaLangClasses;

class Solution {

    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixArray = new long[n];

        prefixArray[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixArray[i] = prefixArray[i - 1] + nums[i];
        }

        int ways = 0;

        for(int i = 0; i < n-1; i++){
            long leftSum = getSum(0, i, prefixArray);
            long rightSum = getSum(i+1, n-1, prefixArray);

            if(leftSum >= rightSum){
                ways++;
            }
        }

        return ways;
    }

    public long getSum(int start, int end, long[] prefixArray){
        if(start == 0){
            return prefixArray[end];
        }

        return prefixArray[end] - prefixArray[start - 1];
    }
}
