/******************************************************************************************************************************************************
---------------------
Level- EAsy
---------------------

Given a binary tree and a budget. Assume you are at the root of the tree(level 1), you need to maximise the count of leaf nodes you can visit in your budget 
if the cost of visiting a leaf node is equal to the level of that leaf node.
___________________________________________________________________________________________________

Example 1:

Input: 
                  10
                /    \
               8      2
             /      /   \
            3      3     6
                    \
                     4
and budget = 8
Output: 2
Explanation:
Cost For visiting Leaf Node 3: 3
Cost For visiting Leaf Node 4: 4
Cost For visiting Leaf Node 6: 3
In budget 8 one can visit Max 2 Leaf Nodes.
Example 2:

Input: 
         1
       /   \
      2     3
     / \   / \
    4   5 6   7
and budget = 5
Output: 1
Explanation: We can only visit either node 4 or 5.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    public int getCount(Node node, int bud)
    {
        //code here  
         Queue<Node> st=new LinkedList<>();
        Queue<Integer> levels=new LinkedList<>();
        st.add(node);
        //int level=1;
        levels.add(1);
        int count=0;
        while(!levels.isEmpty()){
            Node temp=st.remove();
            int level=levels.remove();
            if(temp.left==null && temp.right==null){
                if(bud-level>=0){
                    bud=bud-level;
                    count++;
                    
                }
                else
                    break;
            }
            else{
                if(temp.left!=null){
                    st.add(temp.left);
                    levels.add(level+1);
                }
                if(temp.right!=null){
                    st.add(temp.right);
                    levels.add(level+1);
                }
                
            }
        }
        return count;
    }
}
