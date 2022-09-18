## Array

### Kadane's Algorithm

### N/2 Majority Element 

```java
class N2Majority_Element {
    public int majorityElement(int[] nums) {
        Integer num = null;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(num == null){
                num = currNum;
                count++;
            }else{
                if(currNum == num){
                    count++;
                }else{
                    count--;
                    if(count <= 0){
                        num = currNum;
                        count = 1;
                    }
                }
            }
        }
        
        int finalCount = 0;
        for(int currNum2 : nums){
            if(currNum2 == num){
                finalCount++;
            }
        }
        if(finalCount > nums.length/2){
            return num;
        }
        return -1;
    }

```
### N/3 Majority Element
