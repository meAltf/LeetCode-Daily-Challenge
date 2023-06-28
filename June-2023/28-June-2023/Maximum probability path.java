/******************************************************************************************************************************************************
---------------------------
Level- MEdium
Question No- 1514
----------------------------
You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b 
with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

___________________________________________________________________________________________________ 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.

Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000

Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    // this is the right code
double ans = 0, threashold = 1e-5;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,Map<Integer,Double>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i,new HashMap<>());
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i]; double p = succProb[i]; 
            map.get(e[0]).put(e[1],p);
            map.get(e[1]).put(e[0],p);
        }
        double[] memo = new double[n];
        helper(map,start,end,1,memo);
        return ans;
    }
    private void helper(Map<Integer,Map<Integer,Double>> map,int start,int end,double p,double[] memo){
        if(p <= 1e-5) return;
        if(memo[start] >= p || ans >= p) return; 
        memo[start] = p;
        if(start==end){
            ans = p;
            return;
        }
        Map<Integer,Double> next = map.get(start);
        for(Map.Entry<Integer,Double> entry : next.entrySet()){
            helper(map,entry.getKey(),end,p*entry.getValue(),memo);
        }
    } 
}
