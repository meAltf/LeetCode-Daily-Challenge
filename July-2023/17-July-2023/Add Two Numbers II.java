/******************************************************************************************************************************************************
--------------------
Level- MEdium
Question NO-445
---------------------
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

___________________________________________________________________________________________________ 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        
        ListNode head = new ListNode(0);
        ListNode newNode=head;
        
        int carry=0;
        while(l1!=null || l2!=null || carry>0){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            ListNode node = new ListNode(sum%10);
            newNode.next=node;
            newNode=newNode.next;
        }
        return reverse(head.next);
    }
    private ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode nex=null;
        
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
  } 
};
