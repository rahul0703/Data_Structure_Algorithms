## Array

### Kadane's Algorithm

### N/2 Majority Element 

```java
class N2Majority_Element {
    public int majorityElement(int[] nums) {
        Integer num = null;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (num == null) {
                num = currNum;
                count++;
            } else {
                if (currNum == num) {
                    count++;
                } else {
                    count--;
                    if (count <= 0) {
                        num = currNum;
                        count = 1;
                    }
                }
            }
        }

        int finalCount = 0;
        for (int currNum2 : nums) {
            if (currNum2 == num) {
                finalCount++;
            }
        }
        if (finalCount > nums.length / 2) {
            return num;
        }
        return -1;
    }
}

```
### N/3 Majority Element
### Prefix-Suffix-Array
### 2-Pointers Algorithm
Two pointers is really an easy and effective technique that is typically used for searching pairs in a sorted array.  

    Given a sorted array A (sorted in ascending order), having N integers, find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.  
        
```
A[] = {10, 20, 35, 50, 75, 80}
X = =70
i = 0
j = 5

A[i] + A[j] = 10 + 80 = 90
Since A[i] + A[j] > X, j--
i = 0
j = 4

A[i] + A[j] = 10 + 75 = 85
Since A[i] + A[j] > X, j--
i = 0
j = 3

A[i] + A[j] = 10 + 50 = 60
Since A[i] + A[j] < X, i++
i = 1
j = 3
m
A[i] + A[j] = 20 + 50 = 70
Thus this signifies that Pair is Found.
```
```java
//3-sum
class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet();
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < nums.length -2; i++){
            //2-pointer starts......
            int j = i +1;
            int k = nums.length -1;
            while(j < k){
                int x = nums[i] + nums[j] + nums[k];
                if(x == 0){
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    Collections.sort(ans);
                    if(!set.contains(ans)){
                        answer.add(ans);
                        set.add(ans);
                    }
                    j++;
                }else if(x < 0){
                    j++;
                }else{
                    k--;
                }
            }
            //2 pointer ends.......
        }
        return answer;
    }
}
```
### Sliding Window Algorithm
