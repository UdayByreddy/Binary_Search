class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right = 0;
        for(int weight: weights){
           left = Math.max(left,weight);
           right+=weight;
        }
         int ans=right;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isCapable(weights,mid,days)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean isCapable(int[] weights,int mid,int days){
        int count=0;
        int day=1;
        for(int weight : weights){
            if(count+weight>mid){
                day++;
                count=0;
            }
                count+=weight;
        }
        return day<=days;

    }
}