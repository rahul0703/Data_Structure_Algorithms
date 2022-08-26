package Binary_Tree;

import Binary_Tree.Types.Node;
import Binary_Tree.Types.Node_randomPointer;

import java.util.HashMap;
import java.util.HashSet;

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
}
