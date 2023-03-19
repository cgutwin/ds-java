package ca.cgutwin.datastructures.trees;

public interface BinaryTree<T> {
    public void insert(T data);

    public void remove(T data);

    public boolean contains(T data);

    public int size();

    public int height();

//    public Iterator<T> iterator();
}
