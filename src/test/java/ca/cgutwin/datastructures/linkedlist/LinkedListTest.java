package ca.cgutwin.datastructures.linkedlist;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    @DisplayName("Appending a single element should update the list size and contents")
    void testAppendSingleElement() {
        // Append a single element to the list
        list.append("foo");

        // Check that the list size and contents are as expected
        assertEquals(1, list.size());

        assertEquals("foo", list.get(0));
    }

    @Test
    @DisplayName("Appending multiple elements should update the list size and contents")
    void testAppendMultipleElements() {
        // Append multiple elements to the list
        list.append("foo");
        list.append("bar");
        list.append("baz");

        // Check that the list size and contents are as expected
        Assertions.assertEquals(3, list.size());

        assertEquals("foo", list.get(0));
        assertEquals("bar", list.get(1));
        assertEquals("baz", list.get(2));
    }

    @Test
    @DisplayName("Searching for an existing value should return its index")
    void testSearchExistingValue() {
        list.append("foo");
        list.append("bar");
        list.append("baz");

        // Search for an existing value
        int index = list.search("bar");

        // Check that the index is as expected
        assertEquals(1, index);
    }

    @Test
    @DisplayName("Inserting an item at an index should place the item properly")
    void insertAt() {
        list.append("foo");
        list.append("bar");
        list.append("baz");

        // Search for an existing value
        list.insert("qux", 1);
        int index = list.search("qux");

        // Check that the index is as expected
        assertEquals(1, index);
    }

    @Test
    @DisplayName("Searching for a non-existing value should return -1")
    void testSearchNonExistingValue() {
        list.append("foo");
        list.append("bar");
        list.append("baz");

        // Search for a non-existing value
        int index = list.search("qux");

        // Check that the index is -1 (indicating that the value was not found)
        assertEquals(-1, index);
    }
}