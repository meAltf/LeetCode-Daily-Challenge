/******************************************************************************************************************************************************
---------------------
Level-Medium
Question No-1091
--------------------

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

__________________________________________________________________________________________________
 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return -1;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 1;
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                if(curr[0] == grid.length-1 && curr[1] == grid[0].length-1) return level;
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0){
                        q.add(new int[]{x,y});
                        grid[x][y] = 1;
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
