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

    public int binarySearch2(int[] nums, int x){
        if(x <= nums[0]){
            return 0;
        }
        if(x == nums[nums.length-1]){
            return nums.length-1;
        }
        if(x > nums[nums.length -1]){
            return nums.length;
        }
        return binarySearchUtil2(nums, x, 0, nums.length-1);
    }

    public int binarySearchUtil2(int[] nums, int x, int left, int right){
        if(left < 0){
            return 0;
        }
        if(right >= nums.length){
            return nums.length -1;
        }

        int mid = left + (right-left)/2;
        int num = nums[mid];

        if(num == x){
            return mid;
        }
        if(x <= nums[left]){
            return left;
        }
        if(x == nums[right]){
            return right;
        }
        if(x > nums[right]){
            return right == nums.length - 1 ? right : right+1;
        }
        if(x > num){
            return binarySearchUtil2(nums, x, mid+1, right);
        }else{
            return binarySearchUtil2(nums, x, left, mid -1);
        }
    }
}
