class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int ans=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isSmallest(nums,mid,threshold)){
                ans=mid;
                right=mid-1;
            } 
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean isSmallest(int[] nums,int mid,int thres){
        int count=0;
        for(int num:nums){
           count += (int) Math.ceil((double) num / mid);
        }
        return count<=thres;
    }
}