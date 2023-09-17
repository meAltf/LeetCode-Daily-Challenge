/******************************************************************************************************************************************************
-----------------------
Level- Hard
Question No- 847
-----------------------

You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

___________________________________________________________________________________________________ 

Example 1:


Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]

Example 2:

Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

import java.util.*;

public class Solution {
    public int shortestPathLength(int[][] graph) {
        int V = graph.length;
        Queue<int[]> currLevel = new LinkedList<>();
        for (int u = 0; u < V; u++) {
            currLevel.offer(new int[]{u, 1 << u});
        }
        
        int allVisited = (1 << V) - 1;
        boolean[][] visited = new boolean[V][allVisited + 1];
        for (int u = 0; u < V; u++) {
            visited[u][1 << u] = true;
        }
        
        int pathLength = 0;
        
        while (!currLevel.isEmpty()) {
            int n = currLevel.size();
            while (n > 0) {
                int[] node = currLevel.poll();
                int u = node[0];
                int bitMask = node[1];
                
                if (bitMask == allVisited) {
                    return pathLength;
                }
                
                for (int v : graph[u]) {
                    int nextBitMask = bitMask | (1 << v);
                    
                    if (visited[v][nextBitMask]) {
                        continue;
                    }
                    
                    if (nextBitMask == allVisited) {
                        return pathLength + 1;
                    }
                    
                    currLevel.offer(new int[]{v, nextBitMask});
                    visited[v][nextBitMask] = true;
                }
                
                n--;
            }
            
            pathLength++;
        }
        
        return -1;
    }
}
