package com.keith.handleobject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Keith on 2015/10/5.
 */
public class RedundantObject {
    public static void main (String args[]) {

    }
}

/*
    Not necessary, cause each object will instantiate one Calendar, one TimeZone, two Date object.
 */
class Person {
    private final Date birthDate;

    Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer () {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

}

/*
    Improve that
 */
class Person1 {
    private final Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    Person1(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoom () {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
}
