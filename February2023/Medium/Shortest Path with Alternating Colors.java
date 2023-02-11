/******************************************************************************************************************************************************
------------------
QUESTION NO-1129
------------------

You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph,
and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate 
along the path, or -1 if such a path does not exist.


---------------------------------------------------------------------------------------

Example 1:

Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]
Example 2:

Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
Output: [0,1,-1]

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] graphRed = buildGraph(n, redEdges);
        List<Integer>[] graphBlue = buildGraph(n, blueEdges);
        
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        Deque<int[]> bfsQ = new ArrayDeque<>(); // [node, color_of_previous_edge]
        bfsQ.offer(new int[]{0, 0});
        bfsQ.offer(new int[]{0, 1});
        
        ans[0] = 0;
        
        boolean[][] seen = new boolean[n][2];
        seen[0][0] = true; // 0: Red
        seen[0][1] = true; // 1: Blue
        
        int steps = 1;
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                int[] cell = bfsQ.poll();
                
                List<Integer>[] graph;
                if (cell[1] == 0) {
                    graph = graphBlue;
                } else {
                    graph = graphRed;
                }
                
                int color = (1 ^ cell[1]);
                
                for(int next : graph[cell[0]]) {
                    if (!seen[next][color]) {
                        seen[next][color] = true;
                        ans[next] = Math.min(ans[next], steps);
                        
                        bfsQ.offer(new int[]{next, color});
                    }
                }
            }
            
            steps++;
        }
        
        for(int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        
        return ans;
    }
    
    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            graph[from].add(to);
        }
        
        return graph;
    }
}
