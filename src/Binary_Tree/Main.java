package Binary_Tree;

import Binary_Tree.Implementation.Morris_Inorder_Traversal;
import Binary_Tree.Types.Node;
import Binary_Tree.Types.Node_randomPointer;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Node tree = new Node(1);
        tree.setLeft(new Node(2));
        tree.setRight(new Node(3));
        tree.getLeft().setLeft(new Node(4));
        tree.getLeft().setRight(new Node(5));
        tree.getRight().setLeft(new Node(6));
        tree.getRight().setRight(new Node(7));
        tree.getLeft().getLeft().setLeft(new Node(8));
        tree.getLeft().getLeft().setRight(new Node(9));
        tree.getLeft().getRight().setLeft(new Node(10));
        tree.getLeft().getRight().setRight(new Node(11));
        tree.getRight().getLeft().setLeft(new Node(12));
        tree.getRight().getLeft().setRight(new Node(13));
        tree.getRight().getRight().setLeft(new Node(14));
        tree.getRight().getRight().setRight(new Node(15));
//        tree.setRandom(tree.getLeft().getRight());
//        tree.getLeft().getLeft().setRandom(tree);
//        tree.getLeft().getRight().setRandom(tree.getRight());
//        clone_with_random_pointer(tree);
//        perfect_level_order_traversal(tree);
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 9, 5, 10, 11, 3, 7, 12, 13, 8, 14, 15));
//        ArrayList<Boolean> list2 = new ArrayList<>(Arrays.asList(false, false, false, true, true, false, true, true, false, false, true, true,
//                false, true, true));
//        construct_special_tree_from_preorder_and_leaf_info(list, list2);
        int mat[][] = {
                { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }
        };
        construct_tree_from_ancester_matrix(mat);
    }

    public static void clone_with_random_pointer(Node_randomPointer node){
        Utility_hard utility_hard = new Utility_hard();
        Utility_medium utility_medium = new Utility_medium();
        Node_randomPointer cloned_node = utility_hard.clone_Tree_with_random_pointer(node);
        utility_medium.Print_Tree_Pretty(cloned_node);
        utility_medium.Print_Tree_Pretty(node);
    }
    public static void inorder(Node root){
        Utility_medium utilityMedium = new Utility_medium();
//        ArrayList<Integer> list =utility.inorder(root);
        ArrayList<Integer> list = utilityMedium.inorderWithoutRecursion(root);
        for(int num : list){
            System.out.print(num + " ");
        }
    }
    public static void preorder(Node root){
        Utility_medium utilityMedium = new Utility_medium();
//        ArrayList<Integer> list =utility.inorder(root);
        ArrayList<Integer> list = utilityMedium.preorderWithoutRecursion(root);
        for(int num : list){
            System.out.print(num + " ");
        }
    }

    public static void levelOrderTraversal(Node root){
        Utility_medium utilityMedium = new Utility_medium();
        ArrayList<Integer> list = utilityMedium.levelOrderTraversal(root);
        for(int num : list){
            System.out.print(num + " ");
        }
    }

    public static void morris_inorder_travel(Node root){
        Morris_Inorder_Traversal moris_inorder = new Morris_Inorder_Traversal();
        ArrayList<Integer> answer = moris_inorder.morrisInorderTraversal(root);
        for(int num : answer){
            System.out.print(num + " ");
        }
    }
    public static void diagonal_traversal(Node root){
        Utility_medium utilityMedium = new Utility_medium();
        ArrayList<ArrayList<Integer>> list = utilityMedium.diagonal_traversal(root);
        for(ArrayList<Integer> subList : list){
            for (int num : subList){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void boundary_Traversal(Node root){
        Utility_hard utility_hard = new Utility_hard();
        ArrayList<Integer> list = utility_hard.boundary_traversal(root);
        for(int num : list){
            System.out.print(num + " ");
        }
    }

    public static void perfect_level_order_traversal(Node root){
        Utility_medium utilityMedium = new Utility_medium();
        ArrayList<Integer> list = utilityMedium.perfect_binary_tree_level_order(root);
        for(int num : list){
            System.out.print(num + " ");
        }
    }

    public static void construct_special_tree_from_preorder_and_leaf_info(ArrayList<Integer> preorder, ArrayList<Boolean> isLeaf){
        Utility_hard utility_hard = new Utility_hard();
        Node root = utility_hard.construct_special_tree_from_preorder(preorder, isLeaf);
        Utility_medium utility_medium = new Utility_medium();
        utility_medium.Print_Tree_Pretty(root);
    }

    public static void construct_tree_from_ancester_matrix(int[][] matrix){
        Utility_hard utility_hard = new Utility_hard();
        Utility_medium utility_medium = new Utility_medium();
        Node node = utility_hard.construct_tree_from_ancester_matrix(matrix);
        utility_medium.Print_Tree_Pretty(node);
    }
}
