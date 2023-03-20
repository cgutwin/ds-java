package ca.cgutwin.datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AVLTreeTest {
    private AVLTree<Integer> tree;

    @BeforeEach
    @DisplayName("Create a new Binary Search Tree instance")
    void init() {
        tree = new AVLTree<>();
    }

    @Test
    void insert() {
        tree.insert(10);
        tree.insert(2);
        tree.insert(3);
        tree.insert(8);
        tree.insert(5);
        tree.insert(1);
    }
}