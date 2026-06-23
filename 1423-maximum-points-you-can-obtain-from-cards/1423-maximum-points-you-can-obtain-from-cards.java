class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0,rightSum=0;
        for(int i=0;i<=k-1;i++){
            leftSum=leftSum + cardPoints[i];
        }
        int max=leftSum;//Because the left side itself a valid ans
        int rightIndex=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum=leftSum-cardPoints[i];
            rightSum=rightSum+cardPoints[rightIndex];
            rightIndex--;
            max=Math.max(max,leftSum+rightSum);
        }
        return max;
    }
}