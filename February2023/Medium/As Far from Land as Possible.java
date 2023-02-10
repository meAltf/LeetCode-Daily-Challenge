/******************************************************************************************************************************************************
----------------------------
QUESTION NO-1162
---------------------------
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell
is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

---------------------------------------------------------------------------------------

Example 1:

Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:

Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
    public int maxDistance(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int x= n+m;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
        if(grid[i][j]==1) continue;
        int top=x;
        int left=x;
        if(i-1>=0) top=grid[i-1][j];
        if(j-1>=0) left=grid[i][j-1];
        grid[i][j]=Math.min(top,left)+1;
        }
    }   
    for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(grid[i][j]==1) continue;
        int bottem=x;
        int right=x;
        if(i+1<m) bottem=grid[i+1][j];
        if(j+1<n) right=grid[i][j+1];
        grid[i][j]=Math.min(grid[i][j],Math.min(bottem,right)+1);
        }
    }      
int count=Integer.MIN_VALUE;
for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
count=Math.max(count,grid[i][j]);
        }
        }
        return count-1==n+m+1||count-1==0 ? -1: count-1;
    }
}
