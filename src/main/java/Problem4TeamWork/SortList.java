package Problem4TeamWork;

import Problem3.ListNode;

public class SortList {
    // This could be used to make merging easier. Optional to use.
    private static final int SENTRY = Integer.MAX_VALUE;

    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        // break the list in half from middle
        ListNode mid = findMidAndBreak(head);

        // sort the first half of the list
        ListNode firstList = sortList(head);

        // sort the second half of the list
        ListNode secondList = sortList(mid);

        // merge the two sorted lists
        return mergeSortedSingleLinkedLists(firstList, secondList);
    }

    public static ListNode findMidAndBreak(ListNode head) {
        // TODO: homework for a team of up to 2 persons
        // TODO: list your team member names and the author of this function
        return null; // TODO: placeholder. Replace with your own code
    }

    public static ListNode mergeSortedSingleLinkedLists(ListNode list1, ListNode list2) {
        // TODO: homework for a team of up to 2 persons
        // TODO: list your team member names and the author of this function
        return null; // TODO: placeholder. Replace with your own code
    }
}
