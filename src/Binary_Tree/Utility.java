package Binary_Tree;

import Binary_Tree.Types.Node;
import Binary_Tree.Types.Node_randomPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Utility {
    public void Print_Tree_Pretty(Node node){
        if(node == null){
            return;
        }
        System.out.println((node.getLeft() != null ? node.getLeft().getVal() : "null" )+ "<--" +
                        node.getVal() + "-->" + (node.getRight() != null ? node.getRight().getVal() : "null"
                ));
        Print_Tree_Pretty(node.getLeft());
        Print_Tree_Pretty(node.getRight());
    }
    public void Print_Tree_Pretty(Node_randomPointer node){
        if(node == null){
            return;
        }
        System.out.println((node.getLeft() != null ? node.getLeft().getVal() : "null" )+ "<--" +
                node.getVal() + "-->" + (node.getRight() != null ? node.getRight().getVal() : "null"
        ));
        Print_Tree_Pretty(node.getLeft());
        Print_Tree_Pretty(node.getRight());
    }
    private HashMap<Node_randomPointer, Node_randomPointer> clone_tree_with_random_pointer_map;
    public Node_randomPointer clone_Tree_with_random_pointer(Node_randomPointer node){
        /*
            Given a Binary Tree where every node has the following structure.
            struct node {
                int key;
                struct node *left,*right,*random;
            }
            The random pointer points to any random node of the binary tree and can
            even point to NULL, clone the given binary tree.
         */
        clone_tree_with_random_pointer_map = new HashMap<>();
        Node_randomPointer root = cloneTree(node, null);
        makeCopy(root);
        return root;
    }
    private Node_randomPointer cloneTree(Node_randomPointer node, Node_randomPointer newNode){

        if(node == null){
            return null;
        }
        newNode = new Node_randomPointer(node.getVal());
        clone_tree_with_random_pointer_map.put(node, newNode);
        if(node.getLeft() != null && !clone_tree_with_random_pointer_map.containsKey(node.getLeft())){
            cloneTree(node.getLeft(), newNode.getLeft());
        }
        if(node.getRight()!= null && !clone_tree_with_random_pointer_map.containsKey(node.getRight())){
            cloneTree(node.getRight(), newNode.getRight());
        }
        if(node.getRandom() != null && !clone_tree_with_random_pointer_map.containsKey(node.getRandom())){
            Node_randomPointer ans = cloneTree(node.getRandom(), newNode.getRandom());
            System.out.println(ans.getVal());
            return ans;
        }
        System.out.println(newNode.getVal());
        return newNode;
    }
    private Node_randomPointer makeCopy(Node_randomPointer newRoot){
        for(Node_randomPointer node : clone_tree_with_random_pointer_map.keySet()){
            Node_randomPointer copyNode = clone_tree_with_random_pointer_map.get(node);

            if(node.getLeft() != null){
                copyNode.setLeft(clone_tree_with_random_pointer_map.get(node.getLeft()));
            }
            if(node.getRight() != null){
                copyNode.setRight(clone_tree_with_random_pointer_map.get(node.getRight()));
            }
            if(node.getRandom() != null){
                copyNode.setRandom(clone_tree_with_random_pointer_map.get(node.getRandom()));
            }
        }
        return newRoot;
    }
    private HashMap<Integer, Integer> map;
    private Stack<Integer> stack;
    public int[] most_frequent_tree_sum(Node root){
        /*
        Given the root of a binary tree, return the most frequent subtree sum.
        If there is a tie, return all the values with the highest frequency in any order.
        The subtree sum of a node is defined as the sum of all the node values formed
        by the subtree rooted at that node (including the node itself).

        level: Medium
        Leetcode: https://leetcode.com/problems/most-frequent-subtree-sum/

        Approach:
            1. store the sum and count for all subTree in a hashmap.
            2. make a stack and include only maximum frequency sum elements
            3. put them into a array and return.
         */
        map = new HashMap<>();
        int sum = getSum(root);
        stack= new Stack<>();
        int valFinal = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            if(stack.isEmpty() || valFinal == val){
                stack.push(key);
                valFinal = val;
            }else if(valFinal < val){
                stack = new Stack<>();
                stack.push(key);
                valFinal = val;
            }
        }
        int[] array = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            array[i] = stack.pop();
            i++;
        }
        return array;
    }
    private int getSum(Node node){
        int val = node.getVal();
        int valLeft = 0;
        int valRight = 0;
        if(node.getLeft() != null){
            valLeft = getSum(node.getLeft());
        }
        if(node.getRight() != null){
            valRight = getSum(node.getRight());
        }
        if(map.containsKey(val + valRight + valLeft)){
            map.put(val + valRight + valLeft, map.get(val + valRight + valLeft) + 1);
        }else{
            map.put(val + valRight + valLeft, 1);
        }
        return val+valLeft+valRight;
    }
    public ArrayList<Integer> inorder(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        return list;
    }
}
