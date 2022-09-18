package Greedy.hard;

import java.util.Stack;

public class CreateMaximumNumberFrom2ArraysMaintainingRelativeOrder {

    public static int[] createMaxNumber(int[] array1, int[] array2, int k){
        int[] answer = new int[k];
        int size = array1.length + array2.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int index1 = 0;
        int index2 = 0;
        while(size - index1 - index2  > 0 && size - index1 - index2 > (k - stack1.size() - stack2.size())){
            if(index1 < array1.length && index2 < array2.length){
                int num1 = array1[index1];
                int num2 = array2[index2];
                if(num1 < num2){
                    insert(stack1, num1);
                    index1++;
                }else if(num1 > num2){
                    insert(stack2, num2);
                    index2++;
                }else{
                    if(check(stack1, stack2)){
                        insert(stack1, num1);
                        index1++;
                    }else{
                        insert(stack2, num2);
                        index2++;
                    }
                }
            }else if(index1 < array1.length){
                insert(stack1, array1[index1]);
                index1++;
            }else if(index2 < array2.length){
                insert(stack2, array2[index2]);
                index2++;
            }
        }
        while(index1 < array1.length){
            stack1.push(array1[index1]);
            index1++;
        }
        while(index2 < array2.length){
            stack2.push(array2[index2]);
            index2++;
        }
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        while(!stack1.isEmpty()){
            stack3.push(stack1.pop());
        }
        while(!stack2.isEmpty()){
            stack4.push(stack2.pop());
        }

        for(int i = 0; i < k; i++){
            if(!stack3.isEmpty() && !stack4.isEmpty()){
                if(stack3.peek() >= stack4.peek()){
                    answer[i] = stack3.pop();
                }else{
                    answer[i] = stack4.pop();
                }
            }else if(!stack3.isEmpty()){
                answer[i] = stack3.pop();
            }else{
                answer[i] = stack4.pop();
            }
        }
        return answer;
    }

    private static void insert(Stack<Integer> stack, int number){
        while(!stack.isEmpty() && stack.peek() <  number){
            stack.pop();
        }
        stack.push(number);
    }

    private static boolean check(Stack<Integer> stack1, Stack<Integer> stack2){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        Stack<Integer> dummyStack1 = (Stack<Integer>) stack1.clone();
        Stack<Integer> dummyStack2 = (Stack<Integer>) stack2.clone();

        while(!dummyStack1.isEmpty()){
            sb1.append(dummyStack1.pop());
        }

        while(!dummyStack2.isEmpty()){
            sb2.append(dummyStack2.pop());
        }

        if(sb1.toString().compareTo(sb2.toString()) <= 0){
            return true;
        }
        return false;
    }
}
