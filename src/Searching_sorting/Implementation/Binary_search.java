package Searching_sorting.Implementation;

public class Binary_search {
    public int binarySearch1(int[] nums, int x){
        int left = 0;
        int right = nums.length-1;

        int mid = left + (right-left)/2;
        int num = nums[mid];
        int ans = -1;
        if(num == x){
            return mid;
        }else if(num < x){
            ans = binarySearchUtil(nums, mid+1, right, x);
        }else{
            ans = binarySearchUtil(nums, left, mid-1, x);
        }
        return ans;
    }
    
    public int binarySearchUtil(int[] nums, int left, int right, int x){
        if(left > right || left < 0 || right >= nums.length){
            return -1;
        }
        if(left == right){
            if(nums[left] == x){
                return left;
            }else{
                return -1;
            }
        }
        int mid = left + (right-left)/2;
        if(nums[mid] == x){
            return mid;
        } else if (nums[mid] > x) {
            return binarySearchUtil(nums, left, mid-1, x);
        }else {
            return binarySearchUtil(nums, mid + 1, right, x);
        }
    }
}
