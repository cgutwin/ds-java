package ca.cgutwin.datastructures.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("ReassignedVariable")
public class LinkedList<T> {
    private int size = 0;
    private ListNode<T> head;

    public void append(T data) {
        ListNode<T> toAppend = new ListNode<>(data);

        if (head == null) head = toAppend;
        else {
            ListNode<T> current = head;
            Iterator<ListNode<T>> iterator = this.iterator();

            while (iterator.hasNext()) current = iterator.next();

            current.setNext(toAppend);
        }
        size++;
    }

    public void prepend(T data) {
        head = new ListNode<>(data, head);
        size++;
    }

    public void insert(T data, int index) {
        if (index >= size()) throw new IndexOutOfBoundsException("Index is larger than the list.");

        if (index == size()) append(data);
        else if (index == 0) prepend(data);
        else {
            ListNode<T> toInsert = new ListNode<>(data);
            ListNode<T> current = head;

            for (int i = 1; i < size(); i++) {
                if (i == index) {
                    toInsert.setNext(current.getNext());
                    current.setNext(toInsert);
                    break;
                }
                current = current.getNext();
            }
        }

        size++;
    }

    public void delete(T data) {
        if (head == null) throw new NoSuchElementException("List is empty");

        if (head.getData() == data) head = null;
        else {
            ListNode<T> current = head;
            while (current.getNext() != null) {
                if (current.getNext().getData() == data) {
                    ListNode<T> second = current.getNext();
                    ListNode<T> third = second.getNext();

                    second.setNext(null);
                    current.setNext(third);
                }
            }
        }

        size--;
    }

    public T get(int index) {
        if (head == null) throw new NoSuchElementException("List is empty");
        if (index == 0) return head.getData();

        Iterator<ListNode<T>> iterator = this.iterator();
        int i = 1;
        while (iterator.hasNext() && i < index) {
            i++;
            iterator.next();
        }

        return iterator.next().getData();
    }

    public int search(T value) {
        if (head == null) throw new NoSuchElementException("List is empty");

        boolean found = false;

        ListNode<T> current = head;

        int index = 0;
        while (current != null && !found) {
            if (current.getData() == value) found = true;
            else {
                current = current.getNext();
                index++;
            }
        }

        return found ? index : -1;
    }

    public int size() {
        return size;
    }

    public Iterator<ListNode<T>> iterator() {
        return new LinkedListIterator();
    }

    private static final class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> next) {
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<ListNode<T>> {
        ListNode<T> current;

        public LinkedListIterator() {
            this.current = LinkedList.this.head;
        }


        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public ListNode<T> next() {
            current = current.getNext();
            return current;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
