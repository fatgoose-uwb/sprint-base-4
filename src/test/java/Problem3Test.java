/*
 * DO NOT MAKE ANY CHANGES
 */

import Problem3.ListNode;
import Problem3.SingleLinkedList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Problem3Test {
    @Test
    public void testReversingLinkedList() {
        int[][] inputs = {
                {},
                {1},
                {1, 2},
                {3, 3},
                {1, 4, 2},
                {3, 4, 5, 6, 7},
        };
        int[][] expected = {
                {},
                {1},
                {2, 1},
                {3, 3},
                {2, 4, 1},
                {7, 6, 5, 4, 3},
        };
        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = new SingleLinkedList(inputs[i]);
            SingleLinkedList reversed = new SingleLinkedList(expected[i]);
            list.reverse();
            assertEquals(reversed, list);
        }
    }

    @Test
    public void testEquals() {
        int[][] list1 = {
                null,
                null,
                {},
                {1},
                {1},
                {1, 2},
                {2, 2},
                {1, 2, 3},
                {1, 2, 3},
                {-1, 2, 3},
        };
        int[][] list2 = {
                null,
                {},
                {},
                {},
                {1},
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3},
        };
        boolean[] expect = {
                true, true, true, false, true, true, false, false, true, false,
        };

        assertEquals(list1.length, list2.length);
        assertEquals(list1.length, expect.length);

        for (int i = 0; i < list1.length; i++) {
            SingleLinkedList l1 = new SingleLinkedList(list1[i]);
            SingleLinkedList l2 = new SingleLinkedList(list2[i]);
            TestUtils.assertSingleLinkedListBothWays(l1, l2, expect[i], i);
        }
    }

    @Test
    public void testArrayToListConstructor() {
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
            SingleLinkedList list = new SingleLinkedList(input);
            if (input == null || input.length == 0) {
                assertNull(caseId, list.getHead().next);
                assertEquals(0, list.getSize());
                continue;
            }

            assertEquals(input.length, list.getSize());

            ListNode ptr = list.getHead();
            for (int val : input) {
                ptr = ptr.next;
                assertEquals(caseId, val, ptr.val);
            }
        }
    }
}