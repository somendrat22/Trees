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
    public ListNode getMid(ListNode head){
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return prev;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = getMid(head);
        if(prev == null){
            TreeNode root = new TreeNode(head.val);
            root.right = sortedListToBST(head.next);
            return root;
        }
        int rootData = prev.next.val;
        ListNode head2 = prev.next.next;
        TreeNode root = new TreeNode(rootData);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(head2);
        return root;
    }
}