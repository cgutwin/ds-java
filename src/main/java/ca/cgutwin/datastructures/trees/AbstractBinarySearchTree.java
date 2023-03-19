package ca.cgutwin.datastructures.trees;

public abstract class AbstractBinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
    protected static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        public Node(T value, Node<T> left, Node<T> right, Node<T> parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    protected int size;
    protected Node<T> root;

    @Override
    public void insert(T data) {
//        if (data == null) throw new IllegalArgumentException("");
        if (data == null) return;

        root = insert(root, null, data);
    }

    private Node<T> insert(Node<T> node, Node<T> parent, T data) {
        if (node == null) {
            size++;
            return new Node<>(data, null, null, parent);
        }

        int c = data.compareTo(node.value);
        if (c < 0) node.left = insert(node.left, node, data);
        else if (c > 0) node.right = insert(node.right, node, data);
        else node.value = data;

        return node;
    }

    @Override
    public void remove(T data) {
        root = remove(root, null, data);
    }

    @SuppressWarnings("ReassignedVariable")
    private Node<T> remove(Node<T> node, Node<T> parent, T data) {
        if (node == null) return null;

        int c = data.compareTo(node.value);
        if (c < 0) node.left = remove(node.left, node, data);
        else if (c > 0) node.right = remove(node.right, node, data);
        else {
            if (node.right == null) {
                if (parent == null) root = node.left;
                else if (node == parent.left) parent.right = node.left;
                else parent.left = node.left;

                size--;
                return node.left;
            }
            if (node.left == null) {
                if (parent == null) root = node.right;
                else if (node == parent.left) parent.left = node.right;
                else parent.right = node.right;

                size--;
                return node.right;
            }

            Node<T> t = node;
            node = min(t.right);
            node.right = removeMin(t.right);
            node.left = t.left;
            node.left.parent = node;
            node.parent = t.parent;
            size--;
        }

        return node;
    }

    private Node<T> removeMin(Node<T> node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        size--;
        return node;
    }

    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data) {
        if (node == null) return false;

        int c = data.compareTo(node.value);
        if (c < 0) return contains(node.left, node.value);
        else if (c > 0) return contains(node.right, node.value);

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private Node<T> min(Node<T> node) {
        if (node.left == null) return node;
        return min(node.left);
    }
}
