package Binary_Tree;

import Binary_Tree.Types.Node;
import Binary_Tree.Types.Node_randomPointer;
import Binary_Tree.Types.Pair_tree_ancester_matrix;

import java.util.*;

public class Utility_hard {
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


    int maxLevel = -1;
    int maxLevel2 = 0;
    public ArrayList<Integer> boundary_traversal(Node node){
        /*
        Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
        The boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
        (The values of the nodes may still be duplicates.)
        The left boundary is defined as the path from the root to the left-most node.
        The right boundary is defined as the path from the root to the right-most node.
        If the root doesn’t have left subtree or right subtree, then the root itself is left boundary or right boundary.
        Note this definition only applies to the input binary tree, and not apply to any subtrees.
        The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if it exists.
        If not, travel to the right subtree. Repeat until you reach a leaf node.
        The right-most node is also defined in the same way with left and right exchanged.

        Level: Medium-hard
        GFG: https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

        Approach: 1. travel from top to left node while maintaining count of depth.
                   2. If leaf node, then add.
                   3. if boundary non-leaf node with 1st time visited at that depth, then add
                   4. Travel from top to right while maintaining count of depth.
                   5. If already added don't add or else add as per above condition.
         */
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        HashSet<Node> set = new HashSet<>();
        boundary_traversal_util(node, list, set, 0);
        boundary_traversal_util2(node, list2, set, 0);
        Collections.reverse(list2);
        list.addAll(list2);
        return list;
    }
    private void boundary_traversal_util(Node node, ArrayList<Integer> list, HashSet<Node> set, int level){
        if(node == null){
            return;
        }
        if(node.getLeft() == null && node.getRight() == null && !set.contains(node)){
            list.add(node.getVal());
            set.add(node);
            maxLevel = level;
        }
        if(node.getLeft() != null && !set.contains(node) && level > maxLevel){
            list.add(node.getVal());
            set.add(node);
            maxLevel = level;
        }else if(node.getRight() != null && !set.contains(node) && level > maxLevel){
            list.add(node.getVal());
            set.add(node);
            maxLevel = level;
        }

        boundary_traversal_util(node.getLeft(), list, set, level+1);
        boundary_traversal_util(node.getRight(), list, set, level+1);
    }
    private void boundary_traversal_util2(Node node, ArrayList<Integer> list, HashSet<Node> set, int level){
        if(node == null){
            return;
        }
        if(node.getLeft() == null && node.getRight() == null){
            return;
        }
        if(node.getRight() != null && !set.contains(node) && level > maxLevel2){
            list.add(node.getVal());
            set.add(node);
            maxLevel2 = level;
        }else if(node.getLeft() != null && !set.contains(node) && level > maxLevel2){
            list.add(node.getVal());
            set.add(node);
            maxLevel2 = level;
        }
        boundary_traversal_util2(node.getRight(), list, set, level+1);
        boundary_traversal_util2(node.getLeft(), list, set, level+1);
    }


    private int construct_special_tree_from_preorder_index = 0;
    public Node construct_special_tree_from_preorder(ArrayList<Integer> preorder, ArrayList<Boolean> leaf){
        /*
            Given an array ‘pre[]’ that represents Preorder traversal of a special binary tree
            where every node has either 0 or 2 children.
            One more array ‘preLN[]’ is given which has only two possible values
            'L’ and ‘N’. The value ‘L’ in ‘preLN[]’ indicates that the corresponding node
             in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is a non-leaf node.
            Write a function to construct the tree from the given two arrays.

            level: hard
            GFG: https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/

            Approach:
                1. The 1st element is always root.
                2. update the index, as class variable.
                3. if, element is non-leaf, append to the current subtree.
                4. If, element is leaf, return to parent.
         */
        Node root = new Node(preorder.get(0));
        construct_special_tree_from_preorder_index++;
        construct_special_tree_from_preorder_util(root, preorder, leaf);
        return root;
    }
    private void construct_special_tree_from_preorder_util(Node node, ArrayList<Integer> preorder, ArrayList<Boolean> leaf){
        if(construct_special_tree_from_preorder_index >= preorder.size()){
            return;
        }
        if(node.getLeft() != null && node.getRight() != null){
            return;
        }
//        System.out.println(node.getVal());
        if(node.getLeft() == null){
            node.setLeft(new Node(preorder.get(construct_special_tree_from_preorder_index)));
            construct_special_tree_from_preorder_index++;
            if(leaf.get(construct_special_tree_from_preorder_index-1)){
                construct_special_tree_from_preorder_util(node, preorder, leaf);
            }else{
                construct_special_tree_from_preorder_util(node.getLeft(), preorder, leaf);
            }
        }
        if(node.getRight() == null){
            node.setRight(new Node(preorder.get(construct_special_tree_from_preorder_index)));
            construct_special_tree_from_preorder_index++;
            if(leaf.get(construct_special_tree_from_preorder_index-1)){
                return;
            }else{
                construct_special_tree_from_preorder_util(node.getRight(), preorder, leaf);
            }
        }
    }

    public Node construct_tree_from_ancester_matrix(int[][] matrix){
        /*
            Given an ancestor matrix mat[n][n] where Ancestor matrix is defined as below.
            mat[i][j] = 1 if "i" is ancestor of j
            mat[i][j] = 0, otherwise

            Construct a Binary Tree from a given ancestor matrix where all its values of nodes are from 0 to n-1.

            1. It may be assumed that the input provided the program is valid and tree can be constructed out of it.
            2. Many Binary trees can be constructed from one input. The program will construct any one of them.

            level: hard
            GFG: https://www.geeksforgeeks.org/construct-tree-from-ancestor-matrix/

            Approach:
                1. Make a pair array with pair af (num, number of children)
                2. sort the array based on number of children, desc.
                3. Call individual pair and make node of it and push down into the tree.
                4. Check if it can be pushed on left subtree if not, push into right subtree.
         */
        Pair_tree_ancester_matrix[] array = new Pair_tree_ancester_matrix[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            int count = 0;
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == 1){
                    count++;
                }
            }
            Pair_tree_ancester_matrix pair = new Pair_tree_ancester_matrix(i, count);
            array[i] = pair;
        }
        Arrays.sort(array);
        Node root = new Node(array[0].getNum());
        for(int i = 1; i < array.length; i++){
            Node newNode = new Node(array[i].getNum());
            construct_tree_from_ancester_matrix_helper(root, newNode, matrix);
        }
        return root;
    }
    private void construct_tree_from_ancester_matrix_helper(Node node, Node newNode, int[][] matrix){
        if(node.getLeft() == null){
            node.setLeft(newNode);
            return;
        }
        int leftNodeVal = node.getLeft().getVal();
        int newNodeVal = newNode.getVal();
        if(matrix[leftNodeVal][newNodeVal] == 1){
            construct_tree_from_ancester_matrix_helper(node.getLeft(), newNode, matrix);
            return;
        }
        if(node.getRight() == null){
            node.setRight(newNode);
            return;
        }
        int rightNodeVal = node.getRight().getVal();
        if(matrix[rightNodeVal][newNodeVal] == 1){
            construct_tree_from_ancester_matrix_helper(node.getRight(), newNode, matrix);
            return;
        }
    }


}