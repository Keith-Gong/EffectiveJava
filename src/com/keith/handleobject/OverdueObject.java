package com.keith.handleobject;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Keith on 2015/10/5.
 */
public class OverdueObject {
    public static void main (String args[]) {

    }
}

class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack () {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    //While the object which is maintained by the array is popped, the reference is still alive. So we need improve that
    /*public Object pop () {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }*/

    public Object pop () {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements [size] = null;
        return result;
    }

    private void ensureCapacity () {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    protected Stack clone() throws CloneNotSupportedException {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
