package ca.cgutwin.datastructures.stacks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class VectorStackTest {
    VectorStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new VectorStack<>();
    }

    @AfterEach
    void tearDown() {
        stack.clear();
    }

    @Test
    @DisplayName("Test push operation")
    void push() {
        stack.push("element");
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Test pop operation")
    void pop() {
        stack.push("element");
        String popped = stack.pop();
        assertEquals("element", popped);
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Test peek operation")
    void peek() {
        stack.push("element");
        String peeked = stack.peek();
        assertEquals("element", peeked);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("pop throws NoSuchElementException when stack is empty")
    void testPopException() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("peek throws NoSuchElementException when stack is empty")
    void testPeekException() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    @DisplayName("Test size operation")
    void size() {
        assertEquals(0, stack.size());
        stack.push("element");
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("Test isEmpty operation")
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("element");
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Test clear operation")
    void clear() {
        stack.push("element");
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
    }
}