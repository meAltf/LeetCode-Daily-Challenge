/******************************************************************************************************************************************************
---------------------------
Level- medium
Question No-1020
---------------------------
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

--------------------------------------------------------------------------------------- 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            visited[i] = grid[i].clone();
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m-1 || j == 0 || j == n-1) && (visited[i][j] == 1)) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            for (int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (i >= 0 && j >= 0 && i < m && j < n && visited[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }
        int countLands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1) {
                    countLands++;
                }
            }
        }
        return countLands;
    }
}
