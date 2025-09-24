class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long length = (long)(m*k);
        int n = bloomDay.length;
        if(length>n) return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        while(low<high){
            int mid = low+(high-low)/2;
            if(isBouCreated(bloomDay,mid,m,k)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
   public boolean isBouCreated(int[] bloomDay, int day, int m, int k) {
    int mCount = 0;
    int count = 0;

    for (int i = 0; i < bloomDay.length; i++) {
        if (bloomDay[i] <= day) {
            count++;
            if (count == k) {   // bouquet formed
                mCount++;
                count = 0;
            }
        } else {
            count = 0;  // reset streak
        }
        if (mCount >= m) return true;
    }
    return false;
}
}