/**********************************************************************************************

QUESTION NO -  977

-------------------------------------------------------------------------------------------------------------------------------------------------

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

-------------------------------------------------------------------------------------------------------------------------------------------------

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

*****************************************************************************************************/

-----------------------------------------------------
Approach-1
Using Two Array
----------------------------------------------------
 
class Solution {
    public int findJudge(int n, int[][] trust) {

        if( trust == null)
         return 0;

        int[] trusts = new int[n+1];
        int[] trustedby = new int[n+1];

        for(int[] relation : trust){
            trusts[relation[0]]++;
            trustedby[relation[1]]++;
        }

        for(int i = 1; i<n+1;i++){
            if(trusts[i]==0 && trustedby[i] == n-1) 
               return i;
        }

        return -1;
    }
}


-----------------------------------------------------
Approach-2
Using One Array
----------------------------------------------------
 
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] count = new int[n+1];

        for (int[] t: trust) {

            count[t[0]]--;
            count[t[1]]++;

        }

        for (int i = 1; i <= n; ++i) {

            if (count[i] == n - 1)
             return i;
        }

        return -1;
    }
}
