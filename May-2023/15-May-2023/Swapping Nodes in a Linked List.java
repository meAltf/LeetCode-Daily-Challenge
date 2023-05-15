/******************************************************************************************************************************************************
--------------------
Level- MEdium
Question NO- 1721
--------------------
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

___________________________________________________________________________________________________ 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
        public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head, flag = head;

        // Iterate till 1st swapping point
        for(int i = 0; i < k-1; i++){
            fast = fast.next;
        }

        // save it future swap
        flag = fast;

        // Iterate both variable till end 
        while(fast.next!= null){
            fast = fast.next;
            slow = slow.next;        
        }

        // Automatically slow var will be pointing to 2nd swapping Node
        // so swap values :)
        int temp = slow.val;
        slow.val = flag.val;
        flag.val = temp;
        return head;
    }
}
