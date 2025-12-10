class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxsum=0;
        for(int i=0;i<accounts.length;i++){
            int rowsum=0;
            for(int j=0;j<accounts[i].length;j++){
                rowsum+=accounts[i][j];
            }
            if(rowsum > maxsum){
                maxsum = rowsum;
            }
        }
        return maxsum;
    }
}