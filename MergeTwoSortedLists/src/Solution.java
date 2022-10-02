import org.w3c.dom.Node;

public class Solution {
    public static void main(String[] args) {

        // Create test lists:
        // list1 = [1, 2, 4]
        ListNode list1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        list1.next = l12;
        l12.next = l13;

        // list1 = [1, 3, 4]
        ListNode list2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        list2.next = l22;
        l22.next = l23;

//        System.out.println(list2.val);
//        ListNode l = list2.next;
//        System.out.println(l.val);

        ListNode res = mergeTwoLists(list1, list2);

        while (true) {
            if (res == null) {
                break;
            }

            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();

        list1 = null;
        list2 = null;
        res = mergeTwoLists(list1, list2);

        while (true) {
            if (res == null) {
                break;
            }

            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();

        list1 = null;
        list2 = new ListNode(0);
        res = mergeTwoLists(list1, list2);

        while (true) {
            if (res == null) {
                break;
            }

            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (true) {
            // If any of the input lists are null, break out:
            if (list1 == null) {
                tail.next = list2;
                break;
            }

            if (list2 == null) {
                tail.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                tail.next = list1;  // get the value of list1 into tail
                list1 = list1.next; // remove the element we just copied to tail from list1
            } else {
                tail.next = list2;
                list2 = list2.next;  // remove the element we just copied to tail from list2
            }
            // Executing this doesn't change head. head and tail are in the same memory location before
            // this line is executed. Each time the line is executed it moves tail to another memory location. But
            // those memory positions correspond to memory location in a next field in some linked list in head. That's
            // how head is build up, step-by-step.
            tail = tail.next;
        }

        return head.next;
    }
}

