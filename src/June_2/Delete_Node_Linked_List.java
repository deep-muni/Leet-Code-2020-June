/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]

 */

package June_2;

public class Delete_Node_Linked_List {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args){
        ListNode node_9 = new ListNode(9, null);
        ListNode node_1 = new ListNode(1, node_9);
        ListNode node_5 = new ListNode(5, node_1);
        ListNode node_4 = new ListNode(4, node_5);

        System.out.println("Before");
        printList(node_4);

        deleteNode(node_5);

        System.out.println("\n\nAfter");
        printList(node_4);

    }

}
