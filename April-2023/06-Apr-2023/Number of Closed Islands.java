/******************************************************************************************************************************************************
-------------------------
Level- Medium
Question No- 1254
-------------------------
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island
totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

---------------------------------------------------------------------------------------

Example 1:

Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).

Example 2:


Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visit[i][j] && bfs(i, j, m, n, grid, visit)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean bfs(int x, int y, int m, int n, int[][] grid, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        boolean isClosed = true;

        int[] dirx = {0, 1, 0, -1};
        int[] diry = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0];
            y = temp[1];

            for (int i = 0; i < 4; i++) {
                int r = x +dirx[i];
                int c = y +diry[i];
                if (r < 0 || r >= m || c < 0 || c >= n) {
                    // (x, y) is a boundary cell.
                    isClosed = false;
                } else if (grid[r][c] == 0 && !visit[r][c]) {
                    q.offer(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }

        return isClosed;
    }
}
