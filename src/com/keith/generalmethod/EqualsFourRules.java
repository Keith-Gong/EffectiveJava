package com.keith.generalmethod;

import java.awt.*;

/**
 * Created by Keith on 2015/10/5.
 */

/*
    1.reflexivity
    2.symmetry
    3.transitivity
    4.consistent
 */
public class EqualsFourRules {
    public static void main (String args[]) {

        //symmetry
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(caseInsensitiveString.equals(s));
        System.out.println(s.equals(caseInsensitiveString));

        //transitivity
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));
    }
}

//symmetry
final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString (String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

    //violates symmetry

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        if (obj instanceof String)
            return s.equalsIgnoreCase((String) obj);
        return false;
    }
}

//transitivity
class Point {
    private final int x;
    private final int y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        } else {
            Point point = (Point) obj;
            return point.x == x && point.y == y;
        }
    }
}

class ColorPoint extends Point {
    private final Color color;

    public ColorPoint (int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint))
            return false;
        return super.equals(obj) && ((ColorPoint)obj).color == color;
    }
}
