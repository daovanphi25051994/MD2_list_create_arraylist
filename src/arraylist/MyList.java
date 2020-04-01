package arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
        return true;
    }

    public int size() {
        return this.size;
    }

    public void add(int index, E element) {
        if (index < size) {
            Object step = elements[index];
            elements[index] = element;
            size++;
            for (int i = index; i < size - 1; i++) {
                Object step1 = elements[index + 1];
                elements[index + 1] = step;
                step = step1;
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public E remove(int index) {
        if (index < size) {
            E objectDelete = (E) elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return objectDelete;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean contains(E object) {
        for (Object element : elements) {
            if (element == object) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E object) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == object) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void clear() {
        size = 0;
        Object[] emptyList = new Object[DEFAULT_CAPACITY];
        elements = emptyList;
    }

    public E[] clone(E[] newArray) {
        for (int i = 0; i < size; i++) {
            newArray[i] = (E) elements[i];
        }
        return newArray;
    }
}
