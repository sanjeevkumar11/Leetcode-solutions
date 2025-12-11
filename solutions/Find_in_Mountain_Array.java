/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
        int peak = findpeak(mountainArr,start, end);
        int firsttry = search(mountainArr,start,peak,target,true);
        if(firsttry != -1){
            return firsttry;
        }
        return search(mountainArr,peak+1,end,target,false);
    }
    int findpeak(MountainArray mountainArr,int start,int end){
        while(start < end){
            int mid =  start + (end- start)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    int search(MountainArray mountainArr,int start,int end,int target,boolean asc){
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target){
                return mid;
            }
            if(asc){
                if(target < mountainArr.get(mid)){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target < mountainArr.get(mid)){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}