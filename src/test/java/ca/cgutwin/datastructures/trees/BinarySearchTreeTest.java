package ca.cgutwin.datastructures.trees;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree;

    @BeforeEach
    @DisplayName("Create a new Binary Search Tree instance")
    void init() {
        tree = new BinarySearchTree<>();
    }

    @Test
    @DisplayName("Test insertion of data into Binary Search Tree")
    void testInsert() {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        assertEquals(5, tree.size());

        tree.insert(5);
        tree.insert(null);
        assertEquals(5, tree.size());
    }

    @Test
    @DisplayName("Test removal of data from Binary Search Tree")
    void testRemove() {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        assertEquals(5, tree.size());

        tree.remove(2);
        assertEquals(4, tree.size());

        tree.remove(10);
        assertEquals(4, tree.size());
    }

    @Test
    @DisplayName("Test calculation of height of Binary Search Tree")
    void testHeight() {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        assertEquals(3, tree.height());

        assertEquals(0, new BinarySearchTree<>().height());
    }
}
