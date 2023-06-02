/******************************************************************************************************************************************************
------------------------
Level- Medium
Question No- 2101
------------------------
You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center 
as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb,
whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. 
These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.

___________________________________________________________________________________________________
 

Example 1:


Input: bombs = [[2,1,3],[6,1,4]]
Output: 2
Explanation:
The above figure shows the positions and ranges of the 2 bombs.
If we detonate the left bomb, the right bomb will not be affected.
But if we detonate the right bomb, both bombs will be detonated.
So the maximum bombs that can be detonated is max(1, 2) = 2.
Example 2:


Input: bombs = [[1,1,5],[10,10,5]]
Output: 1
Explanation:
Detonating either bomb will not detonate the other bomb, so the maximum number of bombs that can be detonated is 1.
Example 3:


Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
Output: 5
Explanation:
The best bomb to detonate is bomb 0 because:
- Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
- Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
- Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
Thus all 5 bombs are detonated.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
     int ans=0;
    public int maximumDetonation(int[][] bombs) {

        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int N=bombs.length;
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        boolean[] visited=new boolean[N];

        for(int i=0;i<N;i++)
        {
            int x1=bombs[i][0];
            int y1=bombs[i][1];
            int r1=bombs[i][2];

            for(int j=0;j<N;j++)
            {
                int x2=bombs[j][0];
                int y2=bombs[j][1];
                if(i!=j)
                {
                    long dx=(long)(x1-x2);
                    long dy=(long)(y1-y2);
                    long dist=dx*dx+dy*dy;
                    if(dist<=(long)r1*r1)
                    {
                        System.out.println(dist+" "+r1*r1);
                        adj.get(i).add(j);
                    }
                }
            }
        }
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.print(adj.get(i).get(j)+" ");
            }
                    System.out.println();
        }

        for(int i=0;i<N;i++)
        {
            
                dfs(adj,visited,i,1);
                
                int count=0;
                for(int j=0;j<N;j++)
                {
                    if(visited[j]==true)
                    {
                        count++;
                    }
                }
                ans=Math.max(ans,count);

            Arrays.fill(visited,false);
        }


        return ans;
    }

void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int source,int count)
    {
        visited[source]=true;
        
        for(int it: adj.get(source) )
        {
            if(visited[it]==false)
            {
                dfs(adj,visited,it,count+1);
            }
        }
       
    }
}
