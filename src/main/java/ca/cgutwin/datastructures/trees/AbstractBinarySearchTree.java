package ca.cgutwin.datastructures.trees;

public abstract class AbstractBinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

    protected int size;
    public Node<T> root;

    protected abstract Node<T> newNode(T value, Node<T> left, Node<T> right, Node<T> parent);

    @Override
    public Node<T> insert(T data) {
        return insert(root, null, data);
    }

    private Node<T> insert(Node<T> node, Node<T> parent, T data) {
        if (root == null) {
            root = newNode(data, null, null, null);
            size++;
            return root;
        }

        if (node == null) {
            Node<T> toInsert = newNode(data, null, null, parent);
            if (data.compareTo(parent.getValue()) < 0) parent.setLeft(toInsert);
            else parent.setRight(toInsert);

            size++;

            return toInsert;
        }

        int c = data.compareTo(node.getValue());
        if (c < 0) return insert(node.getLeft(), node, data);
        else if (c > 0) return insert(node.getRight(), node, data);
        else node.setValue(data);

        return node;
    }

    @Override
    public void remove(T data) {
        root = remove(root, null, data);
    }

    @SuppressWarnings("ReassignedVariable")
    private Node<T> remove(Node<T> node, Node<T> parent, T data) {
        if (node == null) return null;

        int c = data.compareTo(node.getValue());
        if (c < 0) node.setLeft(remove(node.getLeft(), node, data));
        else if (c > 0) node.setRight(remove(node.getRight(), node, data));
        else {
            if (node.getRight() == null) {
                if (parent == null) root = node.getLeft();
                else if (node == parent.getLeft()) parent.setRight(node.getLeft());
                else parent.setLeft(node.getLeft());

                size--;
                return node.getLeft();
            }
            if (node.getLeft() == null) {
                if (parent == null) root = node.getRight();
                else if (node == parent.getLeft()) parent.setLeft(node.getRight());
                else parent.setRight(node.getRight());

                size--;
                return node.getRight();
            }

            Node<T> t = node;
            node = min(t.getRight());
            node.setRight(removeMin(t.getRight()));
            node.setLeft(t.getLeft());
            node.getLeft().setParent(node);
            node.setParent(t.getParent());
            size--;
        }

        return node;
    }

    private Node<T> removeMin(Node<T> node) {
        if (node.getLeft() == null) return node.getRight();
        node.setLeft(removeMin(node.getLeft()));
        size--;
        return node;
    }

    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data) {
        if (node == null) return false;

        int c = data.compareTo(node.getValue());
        if (c < 0) return contains(node.getLeft(), node.getValue());
        else if (c > 0) return contains(node.getRight(), node.getValue());

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

    public int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private Node<T> min(Node<T> node) {
        if (node.getLeft() == null) return node;
        return min(node.getLeft());
    }
}
