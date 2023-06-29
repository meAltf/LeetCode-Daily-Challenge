/******************************************************************************************************************************************************
--------------------
Level- Hard
Question No- 864
--------------------
You are given an m x n grid grid where:

'.' is an empty cell.
'#' is a wall.
'@' is the starting point.
Lowercase letters represent keys.
Uppercase letters represent locks.
You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.

If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.

For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys. If it is impossible, return -1.

___________________________________________________________________________________________________

Example 1:


Input: grid = ["@.a..","###.#","b.A.B"]
Output: 8
Explanation: Note that the goal is to obtain all the keys not to open all the locks.
Example 2:


Input: grid = ["@..aA","..B#.","....b"]
Output: 6
Example 3:


Input: grid = ["@Aa"]
Output: -1
 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    class State{
        int x=-1;
        int y=-1;
        StringBuilder keys = null;
        public State(int x, int y, StringBuilder keys){
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
        
        public boolean canUnlock(char lock){
            lock = Character.toLowerCase(lock);
            return keys.charAt(lock-'a')==lock;
        }
    }
    
    int num_keys;
    int startx;
    int starty;
    int m;
    int n; 
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private final String KEY_MASK = "abcdef";
    private final String EMPTY_KEY_MASK = "      ";

    public int shortestPathAllKeys(String[] grid) {
        m = grid.length;
        n = grid[0].length();
        num_keys=0;
        findStartAndKeys(grid);
        String all_keys = KEY_MASK.substring(0, num_keys);
        int steps = 0;
        Set<String> visited = new HashSet<>();
        Queue<State> q = new LinkedList<>();
        State start_state = new State(startx, starty, new StringBuilder(EMPTY_KEY_MASK));
        q.offer(start_state);
        visited.add(startx+","+starty+","+start_state.keys.toString());

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                State s = q.poll();
                //check for finish condition
                if(s.keys.toString().trim().equals(all_keys))return steps;
                for(int[] dir: dirs){
                    int nx = s.x + dir[0];
                    int ny = s.y + dir[1];

                    if(nx<0 || nx>=m || ny<0 || ny>=n)continue;
                    if(visited.contains(nx+","+ny+","+s.keys.toString())){
                        continue;
                    }
                    visited.add(nx+","+ny+","+s.keys.toString());//mark visited

                    char ch = grid[nx].charAt(ny);
                    if(ch=='#')continue;
                    //Collect if key
                    StringBuilder new_keys = new StringBuilder(s.keys);
                    if(Character.isLowerCase(ch)){
                        new_keys.setCharAt(ch-'a', ch);
                    }
                    //LOCK
                    if(Character.isUpperCase(ch) && !s.canUnlock(ch)){
                        continue;
                    }
                    //good to offer
                    State new_state = new State(nx, ny, new_keys);

                    q.offer(new_state);
                }
                
            }
            steps++;
            
        }
        
        
        return -1;
    }
    
    private void findStartAndKeys(String[] grid){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char ch = grid[i].charAt(j);
                if(ch>='a' && ch<='f'){
                    num_keys = Math.max(num_keys, (ch-'a'+1));
                } 
                else if(ch=='@'){
                    startx = i;
                    starty = j;
                }
            }
        }
        
    }
    
}
