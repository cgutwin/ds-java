package ca.cgutwin.datastructures.stacks;

interface Stack<T> {
    /**
     * @param element The element to push.
     */
    void push(T element);

    /**
     * Removes and returns the element from the top of the stack.
     *
     * @return The element at the top of the stack.
     */
    T pop();

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     */
    T peek();

    /**
     * @return The size of the stack.
     */
    int size();

    /**
     * @return If the stack is empty.
     */
    boolean isEmpty();

    /**
     * Clears the stack, removing all elements.
     */
    void clear();
}
