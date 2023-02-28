/******************************************************************************************************************************************************
-------------------------------
QUESTION NO-652
-------------------------------
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

---------------------------------------------------------------------------------------

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]

----------------------------------------------------------------------------------------

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

    private String preOrder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "@";  

        String alataf = cur.val + ",";

        alataf += preOrder(cur.left, map, res) + ",";
        alataf += preOrder(cur.right, map, res);

        map.put(alataf, map.getOrDefault(alataf, 0) + 1);
        if (map.get(alataf) == 2) res.add(cur);
        return alataf;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();

        preOrder(root, new HashMap<>(), res);
        return res;
    }
}
