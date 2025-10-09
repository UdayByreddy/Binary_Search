class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = peakLength(mat,mid);
            int left = mid-1>=0? mat[row][mid-1]:Integer.MIN_VALUE;
            int right = mid+1<m?mat[row][mid+1]:Integer.MIN_VALUE;
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            }
            else if(left>mat[row][mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public int peakLength(int[][] mat,int col){
        int index=-1;
        int max=0;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>max){
                max= mat[i][col];
                index=i;
            }
        }
        return index;
    }
}