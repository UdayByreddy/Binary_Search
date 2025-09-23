class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans =right;
        while(left<=right){
            int mid =left+(right-left)/2;
            if(isKokoEated(piles,mid,h)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean isKokoEated(int[] piles,int mid,int h){
        long hour=0;
        for(int pile:piles){
            hour += pile/mid;
            if(pile%mid!=0) hour++;
        }
        return hour<=h;
    }
}