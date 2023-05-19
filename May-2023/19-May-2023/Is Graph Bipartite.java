/******************************************************************************************************************************************************
--------------------------
Level- Medium
Question No-785
--------------------------
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. 
You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], 
there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects
a node in set A and a node in set B.

Return true if and only if it is bipartite.

___________________________________________________________________________________________________
 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {

    public HashMap<Integer, Boolean> colors;
    public boolean flag;

    public void dfs(int src, int prev, HashMap<Integer, List<Integer>> adjList, boolean [] visited, boolean color) {
        if(!visited[src]) {
            visited[src] = true;
            colors.put(src, color);
            if(adjList.containsKey(src))
                for(int i=0;i<adjList.get(src).size();i++)
                    dfs(adjList.get(src).get(i), src, adjList, visited, !color);
        } else if(prev!=-1 && colors.get(src) == colors.get(prev)) flag = true;
    }

    public boolean isBipartite(int[][] graph) {
        colors = new HashMap<>();
        flag = false;
        boolean [] visited = new boolean [graph.length];
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph[i].length;j++) {
                adjList.computeIfAbsent(i, value -> new ArrayList<>()).add(graph[i][j]);
                adjList.computeIfAbsent(graph[i][j], value -> new ArrayList<>()).add(i);
            }
        }

        for(int i=0;i<graph.length;i++)
            if(!visited[i])
                dfs(i,-1,adjList, visited, true);

        return !flag;
    }
}
