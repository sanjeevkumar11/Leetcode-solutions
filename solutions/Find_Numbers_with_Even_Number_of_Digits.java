class Solution {
    public int findNumbers(int[] nums) {
        int l = nums.length;
        int res= 0;
        for(int i=0;i<l;i++){
            if(count(nums[i]) % 2 == 0){
                res++;
            }
        }
        return res;
    }
    static int count(int n){
        int count =0;
        while(n!=0){
            count++;
            n/=10;
        }
        return count;
    }
}