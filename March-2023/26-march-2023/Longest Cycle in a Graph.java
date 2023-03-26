/******************************************************************************************************************************************************
---------------------
Level- Hard
Question No-2360
-------------------------
You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i].
If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

--------------------------------------------------------------------------------------- 

Example 1:


Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.
Example 2:


Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
    
    private int res;
    
    private void dfs(int u, int[] edges, boolean[] visited, boolean[] inRecursion, int[] count) {
        
        if(u != -1) {
            
            visited[u] = inRecursion[u] = true;
            
            int v = edges[u];
            
            if(v != -1 && !visited[v]) {
                
                count[v] = count[u] + 1;
                
                dfs(v, edges, visited, inRecursion, count);
                
            }
            
            else if(v != -1 && inRecursion[v]) { //cycle h provided inRecursion wla true ho
                
                res = Math.max(res, count[u]-count[v]+ 1);
                
            }
            
            inRecursion[u] = false;
            
        }
        
    }
    
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        
        this.res = -1;
        
        boolean visited[] = new boolean[n];
        boolean inRecursion[] = new boolean[n];
        
        int count[] = new int[n];
        Arrays.fill(count, 1);
        
        for(int i=0; i<n; i++) {
            
            if(!visited[i]) {
                
                dfs(i, edges, visited, inRecursion, count);
            }
            
        }
        
        return res;
    }
}
