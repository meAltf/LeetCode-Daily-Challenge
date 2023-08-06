/**************************************************
-------------------------
Level-Hard
Question no-920
-------------------------

Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during your trip.
To avoid boredom, you will create a playlist so that:

Every song is played at least once.
A song can only be played again only if k other songs have been played.
Given n, goal, and k, return the number of possible playlists that you can create. Since the answer can be very large, return it modulo 109 + 7.

_________________________________

Example 1:

Input: n = 3, goal = 3, k = 1
Output: 6
Explanation: There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].

Example 2:

Input: n = 2, goal = 3, k = 0
Output: 6
Explanation: There are 6 possible playlists: [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], and [1, 2, 2].

Example 3:

Input: n = 2, goal = 3, k = 1
Output: 2
Explanation: There are 2 possible playlists: [1, 2, 1] and [2, 1, 2].

_________________________________

***************************************************/

class Solution {
    int mod = 1000000000 + 7;
    public int numMusicPlaylists(int n, int goal, int k) {
        int[][] dp = new int[n+1][goal+1];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        return (int)solve(n, goal, k, dp);
    }

    long solve(int n, int g, int k, int[][] dp){
        if(n == 0 && g == 0)
            return 1;
        if(n == 0 || g == 0)
            return 0;
        if(dp[n][g] != -1)
            return dp[n][g];
        long inc = solve(n-1, g-1, k, dp) * n;
        long exc = solve(n, g-1, k, dp) * Math.max(n-k, 0);
        return dp[n][g] = (int)(inc%mod + exc%mod)%mod;
    }
}
