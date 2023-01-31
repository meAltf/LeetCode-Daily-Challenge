/**************************************************************************************************************************************

-------------------
QUESTION NO-1626
-------------------

You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of
scores of all the players in the team. However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher
score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, 
return the highest overall score of all possible basketball teams.


------------------------------------------------------------------------------------------------------------------

Example 1:

Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
Output: 34
Explanation: You can choose all the players.

Example 2:

Input: scores = [4,5,6,5], ages = [2,1,2,1]
Output: 16
Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.

Example 3:

Input: scores = [1,2,3,5], ages = [8,9,10,1]
Output: 6
Explanation: It is best to choose the first 3 players. 

-------------------------------------------------------------------------------------------------------------------------

****************************************************************************************************************************************/

class Solution {
    int res = 0;
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] team = new int[len][2];
        for (int i = 0; i < len; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i]; // team is [age, score]
        }
		// double sort first by age then by score, then we can traverse from young to old
        Arrays.sort(team, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        int[] dp = new int[len];
        // dp is the max sum for all sequences (not necessarily consecutive) ending in current idx
        dp[0] = team[0][1];
        for (int i = 1; i < len; i++) {
            int max = team[i][1]; // At least it could start a new sequence by itself without extend
			// for each current idx, go visit all previous index to grow the sequences
            for (int j = 0; j < i; j++) {
                if (team[i][1] >= team[j][1]) {
                    max = Math.max(max, dp[j] + team[i][1]);
                }
            }
            dp[i] = max;
        }
      
        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        
        return res;
    }
}
