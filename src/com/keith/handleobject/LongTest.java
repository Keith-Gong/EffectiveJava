package com.keith.handleobject;

/**
 * Created by Keith on 2015/10/5.
 */
public class LongTest {
    public static void main (String args[]) {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
