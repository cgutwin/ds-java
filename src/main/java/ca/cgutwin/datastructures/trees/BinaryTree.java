package ca.cgutwin.datastructures.trees;

public interface BinaryTree<T> {
    Node<T> insert(T data);

    void remove(T data);

    boolean contains(T data);

    int size();

    int height();

//    public Iterator<T> iterator();
}
