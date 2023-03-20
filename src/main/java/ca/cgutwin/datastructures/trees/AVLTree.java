package ca.cgutwin.datastructures.trees;

public class AVLTree<T extends Comparable<T>> extends AbstractBinarySearchTree<T> {
    @Override
    protected AVLNode<T> newNode(T value, Node<T> left, Node<T> right, Node<T> parent) {
        return new AVLNode<>(value, left, right, parent);
    }

    @Override
    public AVLNode<T> insert(T item) {
        AVLNode<T> toInsert = (AVLNode<T>) super.insert(item);
        rebalance(toInsert);
        return toInsert;
    }

    @SuppressWarnings("ReassignedVariable")
    private void rebalance(AVLNode<T> node) {
        if (node == null) return;
        int bf = balanceFactor(node);

        if (bf > 1) {
            if (node.getLeft().getLeft() == null) {
                node.setLeft(((AVLNode<T>) node.getLeft()).rotateLeft());
            }
            node = node.rotateRight();
        } else if (bf < -1) {
            if (node.getRight().getRight() == null) {
                node.setRight(((AVLNode<T>) node.getRight()).rotateRight());
            }
            node = node.rotateLeft();
        }

        if (node.getParent() != null) {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node);
            } else {
                node.getParent().setRight(node);
            }
        } else {
            this.root = node;
        }

        node.updateHeight();
        rebalance((AVLNode<T>) node.getParent());
    }

    private int balanceFactor(AVLNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.getLeft()) - height(node.getRight());
        }
    }
}
