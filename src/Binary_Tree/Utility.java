package Binary_Tree;

import Binary_Tree.Types.Node;
import Binary_Tree.Types.NodeWithTask;
import Binary_Tree.Types.Node_randomPointer;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.sql.Array;
import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

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
        inorder(node, list);
        return list;
    }
    private void inorder(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        inorder(node.getLeft(), list);
        list.add(node.getVal());
        inorder(node.getRight(), list);
    }
    public ArrayList<Integer> preorder(Node node){
        ArrayList<Integer> answer = new ArrayList<>();
        preorder(node, answer);
        return answer;
    }
    private void preorder(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.getVal());
        preorder(node.getLeft(), list);
        preorder(node.getRight(), list);
    }
    public ArrayList<Integer> postorder(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        postorder(node, list);
        return list;
    }
    private void postorder(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        list.add(node.getVal());
    }
    public ArrayList<Integer> inorderWithoutRecursion(Node root){
        /*
        inorder without recursion

        level: medium

        Approach: use stack keeping track of task
            task1: travel for left subtree
            task2: print value
            task3: travel for right subtree
         */
        Stack<NodeWithTask> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        NodeWithTask rootNode = new NodeWithTask(root, 0);
        stack.push(rootNode);
        while(!stack.isEmpty()){
            NodeWithTask popNode = stack.pop();
            int task = popNode.getTask();
            Node node = popNode.getNode();

            if(task == 0){
                popNode.setTask(1);
                stack.push(popNode);
                if(node.getLeft() != null){
                    stack.push(new NodeWithTask(node.getLeft(), 0));
                }
            }else if(task ==1){
                list.add(node.getVal());
                popNode.setTask(2);
                stack.push(popNode);
            }else{
                if(node.getRight() != null){
                    stack.push(new NodeWithTask(node.getRight(), 0));
                }
            }
        }
        return list;
    }

    public ArrayList<Integer> preorderWithoutRecursion(Node root){
        /*
            Iterative preorder
            level: medium
         */
        Stack<NodeWithTask> stack = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();
        NodeWithTask rootWithTask = new NodeWithTask(root, 0);
        stack.push(rootWithTask);
        while(!stack.isEmpty()){
            NodeWithTask popNode = stack.pop();
            Node node = popNode.getNode();
            int task = popNode.getTask();
            if(task == 0){
                answer.add(node.getVal());
                popNode.setTask(1);
                stack.push(popNode);
            }else if(task == 1){
                popNode.setTask(2);
                stack.push(popNode);
                if(node.getLeft() != null){
                    stack.push(new NodeWithTask(node.getLeft(), 0));
                }
            }else{
                if(node.getRight() != null){
                    stack.push(new NodeWithTask(node.getRight(), 0));
                }
            }
        }
        return answer;
    }

    public ArrayList<Integer> levelOrderTraversal(Node root){
        /*
        level order traversal
        level: medium
        approach:
            1. use queue to store the left and right node.
         */
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node pollNode = queue.poll();
            answer.add(pollNode.getVal());

            if(pollNode.getLeft() != null){
                queue.add(pollNode.getLeft());
            }
            if(pollNode.getRight() != null){
                queue.add(pollNode.getRight());
            }
        }
        return answer;
    }

    public ArrayList<ArrayList<Integer>> diagonal_traversal(Node root){
        /*
        Consider lines with a slope of -1 that cross through nodes.
        Print all diagonal elements in a binary tree that belong to the same line, given a binary tree.

        Level: medium
        gfg: https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

        Approach:
            1. use hashmap to store the index of x and y co-ordinate.
            2. u can use treemap to maintain order of keys.
         */
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        diagonal_traversal_util(root, map, 0, 0);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            TreeMap<Integer, ArrayList<Integer>> subMap = map.get(key);
            ArrayList<Integer> subList = new ArrayList<>();
            for(int subKey : subMap.keySet()){
                ArrayList<Integer> subMapList = subMap.get(subKey);
                for(int num : subMapList){
                    subList.add(num);
                }
            }
            list.add(subList);
        }
        return list;
    }

    private void diagonal_traversal_util(Node root, TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map, int leftIdx, int rightIdx){
        if(root == null){
            return;
        }
        if(!map.containsKey(leftIdx)){
            map.put(leftIdx, new TreeMap<Integer, ArrayList<Integer>>());
        }
        if(!map.get(leftIdx).containsKey(rightIdx)){
            map.get(leftIdx).put(rightIdx, new ArrayList<Integer>());
        }
        if(root.getLeft() != null){
            diagonal_traversal_util(root.getLeft(), map, leftIdx+1, rightIdx);
        }

        map.get(leftIdx).get(rightIdx).add(root.getVal());
        diagonal_traversal_util(root.getRight(), map, leftIdx, rightIdx + 1);
    }


}
