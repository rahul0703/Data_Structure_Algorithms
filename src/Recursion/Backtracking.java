package Recursion;

import java.util.ArrayList;

public class Backtracking {
    public ArrayList<ArrayList<String>> nQueen(int size){
        int[][] matrix = new int[size][size];
        ansNQueen = new ArrayList<>();
        nQueenHelper(size, matrix, 0, 0);
        return ansNQueen;
    }
    private ArrayList<ArrayList<String>> ansNQueen;
    private void nQueenHelper(int n, int[][] matrix, int row, int col){
        if(row >= n){
            ArrayList<String> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String str = "";
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == 0){
                        str += "x ";
                    }else{
                        str += "Q ";
                    }
                }
                ans.add(str);
            }
            ansNQueen.add(ans);
        }
        for(int i = 0; i < n; i++){
            if(checkIfSafe(n, matrix, row, i)){
                matrix[row][i] = 1;
                nQueenHelper(n, matrix, row+1, 0);
                matrix[row][i] = 0;
            }
        }
    }
    private boolean checkIfSafe(int n, int[][] matrix, int row, int col){
        for(int i = 0; i < row; i++){
            if(matrix[i][col] == 1){
                return false;
            }
        }
        int leftDiaJ = col-1;
        int rightDiaJ = col+1;
        int leftDiaI = row-1;
        int rightDiaI = row-1;
        while(leftDiaI >= 0 && leftDiaJ >= 0){
            if(matrix[leftDiaI][leftDiaJ] == 1){
                return false;
            }
            leftDiaI--;
            leftDiaJ--;
        }
        while(rightDiaI >= 0 && rightDiaJ < n){
            if(matrix[rightDiaI][rightDiaJ] == 1){
                return false;
            }
            rightDiaI--;
            rightDiaJ++;
        }
        return true;
    }

    public ArrayList<ArrayList<String>> sudokuSolver(){
        ansForSudokuSolver = new ArrayList<>();
        return ansForSudokuSolver;
    }
    private ArrayList<ArrayList<String>> ansForSudokuSolver;
}
