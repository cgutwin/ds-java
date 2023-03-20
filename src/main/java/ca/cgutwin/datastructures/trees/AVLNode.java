package ca.cgutwin.datastructures.trees;

public class AVLNode<T> extends Node<T> {
    int height;

    public AVLNode(T value, Node<T> left, Node<T> right, Node<T> parent) {
        super(value, left, right, parent);
    }

    public AVLNode(T value) {
        super(value);
    }

    public AVLNode<T> rotateLeft() {
        AVLNode<T> pivot = (AVLNode<T>) this.getRight();
        this.setRight(pivot.getLeft());

        if (pivot.getLeft() != null) {
            pivot.getLeft().setParent(this);
        }

        pivot.setLeft(this);
        pivot.setParent(this.getParent());
        this.setParent(pivot);

        updateHeight();
        pivot.updateHeight();

        return pivot;
    }

    public AVLNode<T> rotateRight() {
        AVLNode<T> pivot = (AVLNode<T>) this.getLeft();
        this.setLeft(pivot.getRight());

        if (pivot.getRight() != null) {
            pivot.getRight().setParent(this);
        }

        pivot.setRight(this);
        pivot.setParent(this.getParent());
        this.setParent(pivot);

        updateHeight();
        pivot.updateHeight();

        return pivot;
    }

    public void updateHeight() {
        int leftHeight = (getLeft() == null) ? 0 : ((AVLNode<T>) getLeft()).height;
        int rightHeight = (getRight() == null) ? 0 : ((AVLNode<T>) getRight()).height;

        height = Math.max(leftHeight, rightHeight) + 1;
    }
}
