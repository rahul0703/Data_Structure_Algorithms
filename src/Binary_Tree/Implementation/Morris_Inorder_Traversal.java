package Binary_Tree.Implementation;

import Binary_Tree.Types.Node;

import java.util.ArrayList;

public class Morris_Inorder_Traversal {
    public ArrayList<Integer> morrisInorderTraversal(Node node){
        /*
        Inorder without recursion and stack.
        level: hard
        Leetcode:

        Approach:
            1. Travel left, print current, Travel right;
            2. At each current, find right-most element in left subtree.
            3. if right-most.right == current:
                    means left subpart is already visited. Therefore, make right-most.right = null,
                    and print current and travel right part of current.
               else
                    make right-most.right = current and travel the left subtree.
         */
       ArrayList<Integer> answer = new ArrayList<>();
       while(node != null){

           if(node.getLeft() != null){
               Node left = node.getLeft();
               while(left.getRight() != null && left.getRight() != node){
                   left = left.getRight();
               }
               if(left.getRight() == node){
                   left.setRight(null);
                   answer.add(node.getVal());
                   node = node.getRight();
                   continue;
               }else{
                   left.setRight(node);
                   node = node.getLeft();
                   continue;
               }
           }
           if(node.getLeft() != null){
               node = node.getLeft();
           }else{
               answer.add(node.getVal());
               node = node.getRight();
           }
       }
        return answer;
    }
}
