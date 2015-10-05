package com.keith.handleobject;

/**
 * Created by Keith on 10/2/15.
 *
 * The advantage of static factory method
 * 1.They have a meaningful name
 * 2.Only return one object
 * 3.Able to return a child type
 *
 */
public class BooleanTest {
    private BooleanTest () {}
    public static Boolean BooleanTest (boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
