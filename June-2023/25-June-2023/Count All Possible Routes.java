/******************************************************************************************************************************************************
-------------------
Level- HArd
Question NO-1575
--------------------

You are given an array of distinct positive integers locations where locations[i] represents the position of city i. You are also given integers start, 
finish and fuel representing the starting city, ending city, and the initial amount of fuel you have, respectively.

At each step, if you are at city i, you can pick any city j such that j != i and 0 <= j < locations.length and move to city j.
Moving from city i to city j reduces the amount of fuel you have by |locations[i] - locations[j]|. Please notice that |x| denotes the absolute value of x.

Notice that fuel cannot become negative at any point in time, and that you are allowed to visit any city more than once (including start and finish).

Return the count of all possible routes from start to finish. Since the answer may be too large, return it modulo 109 + 7.

___________________________________________________________________________________________________
 

Example 1:

Input: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
Output: 4
Explanation: The following are all possible routes, each uses 5 units of fuel:
1 -> 3
1 -> 2 -> 3
1 -> 4 -> 3
1 -> 4 -> 2 -> 3

Example 2:

Input: locations = [4,3,1], start = 1, finish = 0, fuel = 6
Output: 5
Explanation: The following are all possible routes:
1 -> 0, used fuel = 1
1 -> 2 -> 0, used fuel = 5
1 -> 2 -> 1 -> 0, used fuel = 5
1 -> 0 -> 1 -> 0, used fuel = 3
1 -> 0 -> 1 -> 0 -> 1 -> 0, used fuel = 5

Example 3:

Input: locations = [5,2,1], start = 0, finish = 2, fuel = 3
Output: 0
Explanation: It is impossible to get from 0 to 2 using only 3 units of fuel since the shortest route needs 4 units of fuel.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    
    int MOD = (int)1e9 + 7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        int l = locations.length;
        int[][] dp = new int[l + 1][fuel + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        } 
        return helper(locations, start, finish, fuel, dp);
    }

    private int helper(int[] locations, int start, int finish, int fuel, int[][] dp) {
        int result = 0;
        
        if(fuel < 0) return result;
        
        if(dp[start][fuel] != -1) return dp[start][fuel];
        
        // If the start and finish are the same, increment the result
        if(start == finish) result++;
        
        for(int i = 0; i < locations.length; i++) {
            if(i == start) continue; // Skip the current city if it is the same as the start city
            
            int fuelConsumed = Math.abs(locations[start] - locations[i]);
            
            // Recursively calculate the count of routes from city i to the finish city
            result += helper(locations, i, finish, fuel - fuelConsumed, dp);
            result %= MOD;
        }
        // Store the result in the dp array 
        dp[start][fuel] = result;
        return result;
    }
}
