/************************************************************************************************************************************

------------------------------------------

QUESTION NO- 909

-------------------------------------------

You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board
(i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.

A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c].
Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder,
you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, 
but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.


-------------------------------------------------------------

Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4

Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1

-------------------------------------------------------------


*************************************************************************************************************************************/

class Solution {
    public int snakesAndLadders(int[][] board) {

        int n = board.length*board.length;
        int[] a = new int[n];//linear array
        int c=0, k=0; //c - odd even checker, k - linear array index 

        //filling the linear array from 0 to n-1
        for(int i=board.length-1;i>=0;i--){
            if(c%2==1) //reverse alternating rows/odd rows from bottom
                reverse(board[i]);
            // filling same index when -1 else filling transition state/index
            for(int x:board[i]){
                a[k] = x==-1? k: x-1;
                k++;
            }
            c++;
        }
        
        // visited array.
        boolean[] visited = new boolean[n*n];
        visited[0]=true;

        Queue<Integer> queue = new ArrayDeque<>(); 
        queue.add(0);
        int moves=0;

        while(!queue.isEmpty()){
            int len = queue.size();
            moves++; //incrementing moves
            while(len-->0){
                int curr = queue.remove();
                for(int i=curr+1;i<=Math.min(n-1,curr+6);i++){
                    if(visited[i])
                       continue;
                    visited[i]=true;
                    queue.add(a[i]);
                    if(a[i]==n-1) //reaching the last Index
                        return moves;
                }
            }
        }
        return -1;
    }

    //reversing the array.
    private void reverse(int[] a){
        int i=0, j=a.length-1;
        while(i<j){
            int temp = a[i];
            a[i++]=a[j];
            a[j--]=temp;
        }
    }
}
