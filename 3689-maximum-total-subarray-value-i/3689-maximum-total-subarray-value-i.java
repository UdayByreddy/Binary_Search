class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(int num:nums){
            max =Math.max(num,max);
            min =Math.min(num,min);
        }
        long res=0;
        while(k-->0){
            res+=(max-min);
        }
        return res;
        
    }
}