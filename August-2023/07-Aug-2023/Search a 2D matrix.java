/**************************************************
-------------------
Level- Medium
Question No- 74
---------------------
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

_________________________________

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

_________________________________

***************************************************/



//User function Template for Java

class Solution
{
    //function for checking safe condition
    public static boolean isSafe(int grid[][], int num, int row, int col){
        for(int i=0; i<9; i++){
            if(grid[i][col] == num){
                return false;
            }
            if(grid[row][i] == num){
                return false;
            }
        }
        
        int StartR = (row/3)*3, StartC = (col/3)*3;
        for(int i=StartR; i<=StartR+2; i++){
            for(int j=StartC; j<StartC+3; j++){
                if(grid[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int row = 0, col = 0;
        return helper(grid, row, col);
    }
    
    static boolean helper(int grid[][], int row, int col){
        if(row == 9){
            return true;       
        }
        int NextR = row, NextC = col+1;
        if(col+1 == 9){
            NextR = row+1; NextC = 0;
        }
        
        if(grid[row][col] != 0){
            return helper(grid, NextR, NextC);
        }
        
        for(int i=1; i<=9; i++){
            if(isSafe(grid,i,row,col)){
                grid[row][col] = i;
                if(helper(grid,NextR,NextC)){
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
