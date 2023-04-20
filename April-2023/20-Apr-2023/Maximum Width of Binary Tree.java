/******************************************************************************************************************************************************
--------------------
Level- Medium
Question NO- 662
--------------------
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted 
into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

___________________________________________________________________________________________________ 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

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
    public int widthOfBinaryTree(TreeNode root) {
        
         if (root == null) {
            return 0;
        }
        
        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(1);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftIndex = 0, rightIndex = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                int index = indexQueue.poll();
                
                if (i == 0) {
                    leftIndex = index;
                }
                if (i == levelSize - 1) {
                    rightIndex = index;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }
        
        return maxWidth;
    }
}
