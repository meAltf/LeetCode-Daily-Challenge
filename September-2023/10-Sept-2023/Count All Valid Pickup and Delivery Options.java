/******************************************************************************************************************************************************
----------------------------
Level- Hard
Question No- 1359
----------------------

Given n orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.
___________________________________________________________________________________________________

Example 1:

Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.

Example 2:

Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
Example 3:

Input: n = 3
Output: 90

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    private long[][] dp;
    private static final int MOD = 1000000007;

    private long solve(int notpickup, int notdelivered) {
        if (notpickup == 0 && notdelivered == 0) {
            return 1;
        }
        if (notpickup < 0 || notdelivered < 0 || notpickup > notdelivered) {
            return 0;
        }

        if (dp[notpickup][notdelivered] != -1) {
            return dp[notpickup][notdelivered];
        }

        long res = 0;

        res = (res + notpickup * solve(notpickup - 1, notdelivered)) % MOD;

        res = (res + (notdelivered - notpickup) * solve(notpickup, notdelivered - 1)) % MOD;

        return dp[notpickup][notdelivered] = res;
    }

    public int countOrders(int n) {
        dp = new long[n + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return (int) solve(n, n);
    }
}
