/*
 * DO NOT MAKE ANY CHANGES
 */

import Problem3.ListNode;
import Problem3.SingleLinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TestUtils {
    public static ListNode arrayToListWithDummy(int[] data) {
        if (data == null) {
            return null;
        }
        ListNode head = new ListNode();  // dummy node
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
        }

        return head;
    }

    public static int[] listWithoutDummyToArray(ListNode list) {
        List<Integer> result = new ArrayList<>();
        while (list != null) {
            result.add(list.val);
            list = list.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void assertSingleLinkedListBothWays(SingleLinkedList l1, SingleLinkedList l2, boolean check, int caseId) {
        String caseIdStr = String.format("case %d", caseId);
        if (check) {
            assertEquals(caseIdStr, l1, l2);
            assertEquals(caseIdStr, l2, l1);
        } else {
            assertNotEquals(caseIdStr, l1, l2);
            assertNotEquals(caseIdStr, l2, l1);
        }
    }

    @Test
    public void listWithoutDummyToArray() {
        // TODO
    }

    @Test
    public void testArrayToListWithDummy() {
        int[][] inputs = {
                null,
                {},
                {1},
                {1, 2},
                {3, 3},
                {1, 4, 2},
                {3, 4, 5, 6, 7},
        };

        for (int[] input : inputs) {
            String caseId = String.format("case %s failed", Arrays.toString(input));
            ListNode list = arrayToListWithDummy(input);
            if (input == null) {
                assertNull(caseId, list);
                continue;
            }

            ListNode ptr = list;
            for (int i = 0; i < input.length; i++) {
                ptr = ptr.next;
                assertEquals(caseId, input[i], ptr.val);
            }
            assertNull(caseId, ptr.next);
        }
    }

    public static ListNode arrayToListWithoutDummy(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        ListNode head = null;
        ListNode ptr = null;
        for (int val : input) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                ptr = head;
                continue;
            }
            ptr.next = newNode;
            ptr = newNode;
        }
        return head;
    }

    @Test
    public void testArrayToListWithoutDummy() {
        int[][] inputs = {
                null,
                {},
                {1},
                {1, 2},
                {3, 3},
                {1, 4, 2},
                {3, 4, 5, 6, 7},
        };

        for (int[] input : inputs) {
            String caseId = String.format("case %s failed", Arrays.toString(input));
            ListNode list = arrayToListWithoutDummy(input);
            if (input == null) {
                assertNull(caseId, list);
                continue;
            }

            ListNode ptr = list;
            for (int i = 0; i < input.length; i++) {
                assertEquals(caseId, input[i], ptr.val);
                ptr = ptr.next;
            }
            assertNull(caseId, ptr);
        }
    }
}
