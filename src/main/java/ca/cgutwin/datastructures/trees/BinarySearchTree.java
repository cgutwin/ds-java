package ca.cgutwin.datastructures.trees;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinarySearchTree<T> {
    @Override
    protected Node<T> newNode(T value, Node<T> left, Node<T> right, Node<T> parent) {
        return new Node<>(value, left, right, parent);
    }
}
