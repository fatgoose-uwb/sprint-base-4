/*
 * DO NOT MAKE ANY CHANGES
 */

import Common.TreeNode;
import Problem5.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Problem5Test {
    @Test
    public void testBothEmptyTree() {
        BinaryTree<Integer> tree1 = new BinaryTree<>(null);
        BinaryTree<Integer> tree2 = new BinaryTree<>(null);

        assertEquals(tree1, tree2);
    }

    @Test
    public void testOneNullTree() {
        BinaryTree<Integer> tree1 = new BinaryTree<>(new TreeNode<>(1));
        BinaryTree<Integer> tree2 = new BinaryTree<>(null);

        assertNotEquals(tree1, tree2);
        assertNotEquals(tree2, tree1);
    }

    @Test
    public void testBothNonNullSameTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(getTreeXInNodes());

        assertEquals(tree, tree);
    }

    @Test
    public void testBothNonEmptySameValueTree() {
        // two separate trees have the same valued nodes
        BinaryTree<Integer> tree1 = new BinaryTree<>(getTreeXInNodes());
        BinaryTree<Integer> tree2 = new BinaryTree<>(getTreeXInNodes());

        assertEquals(tree1, tree2);
        assertEquals(tree2, tree1);
    }

    @Test
    public void testBothNonEmptyAlmostSameValueTreeDifferByOneNode() {
        BinaryTree<Integer> tree1 = new BinaryTree<>(getTreeXInNodes());
        BinaryTree<Integer> tree2 = new BinaryTree<>(getTreeXXInNodes());

        assertNotEquals(tree1, tree2);
        assertNotEquals(tree2, tree1);
    }

    @Test
    public void testBothNonEmptyVeryDifferentTrees() {
        BinaryTree<Integer> tree1 = new BinaryTree<>(getTreeXInNodes());
        BinaryTree<Integer> tree2 = new BinaryTree<>(getTreeYInNodes());

        assertNotEquals(tree1, tree2);
        assertNotEquals(tree2, tree1);
    }

    //      1
    //     / \
    //    2   3
    //   / \   \
    //  4   5   6
    private static TreeNode<Integer> getTreeXInNodes() {
        TreeNode<Integer> root = getCommonSubTreeNode();
        root.right.right = new TreeNode<>(6);
        return root;
    }

    //      1
    //     / \
    //    2   3
    //   / \   \
    //  4   5   7
    private static TreeNode<Integer> getTreeXXInNodes() {
        TreeNode<Integer> root = getCommonSubTreeNode();
        root.right.right = new TreeNode<>(7);
        return root;
    }

    private static TreeNode<Integer> getCommonSubTreeNode() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right = new TreeNode<>(3);
        return root;
    }

    //             1
    //            /  \
    //           2    3
    //          /  \    \
    //         4    -2    6
    //        /    /
    //       9    8
    //      /
    //     9
    private static TreeNode<Integer> getTreeYInNodes() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.left.left = new TreeNode<>(9);
        root.left.left.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(-2);
        root.left.right.left = new TreeNode<>(8);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        return root;
    }
}