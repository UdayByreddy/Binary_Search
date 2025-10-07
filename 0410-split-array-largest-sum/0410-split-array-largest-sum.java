class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int num:nums){
            low=Math.max(num,low);
            high+=num;
        }
        int ans=high;
        while(low<=high){
            int mid = (low+high)/2;
            if(isLargeSum(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }
            else{
            low=mid+1;
            }
        }
        return ans;
    }
    public boolean isLargeSum(int[] nums,int target, int possible){
        int sum=0;
        int count=1;
        for(int num:nums){
            if(sum+num>target){
                count++;
                sum=num;
                if(count>possible) return false;
            }
            else{
                sum+=num;
            }
        }
        return true;
    }
}