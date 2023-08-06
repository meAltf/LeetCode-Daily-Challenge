/**************************************************
-----------------------
Level- MEdium
Question No-95
-------------------------
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

_________________________________ 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]

_________________________________

***************************************************/

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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return f(1, n, dp);
    }
    private List<TreeNode> f(int low, int high, List<TreeNode>[][] dp){
        List<TreeNode> bst = new ArrayList<>();
        if (low > high){
            bst.add(null);
            return bst;
        }
        if (dp[low][high] != null)
            return dp[low][high];

        for (int i = low; i <= high; i++){
            List<TreeNode> leftSubTree = f(low, i - 1, dp);
            List<TreeNode> rightSubTree = f(i + 1, high, dp);
            for (TreeNode left : leftSubTree){
                for (TreeNode right : rightSubTree){
                    bst.add(new TreeNode(i, left, right));
                }
            }
        }
        return dp[low][high] = bst;
    }
}
