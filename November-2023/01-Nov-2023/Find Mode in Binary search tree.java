/**

Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [1,null,2,2]
Output: [2]


Example 2:

Input: root = [0]
Output: [0]

**/

// Here is the solution 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    HashMap<Integer, Integer> map=new HashMap<>();
    int max=0;

    private void findModeH(TreeNode root) {
        if(root==null) return;

        if(map.containsKey(root.val)){
            map.put(root.val,map.get(root.val)+1);
        }else{
            map.put(root.val,1);
        }

        max=Math.max(max,map.get(root.val));

        findModeH(root.left);
        findModeH(root.right);
    }    

    public int[] findMode(TreeNode root) {

        findModeH(root);

        List<Integer> arr=new ArrayList<>();

        for(int key : map.keySet()){
            if(map.get(key)==max){
                arr.add(key);
            }
        }
        
        int ans[] = new int[arr.size()];
        for(int i=0; i<ans.length; i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}
