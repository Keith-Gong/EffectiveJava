package com.keith.generalmethod;

/**
 * Created by Keith on 2015/10/6.
 */
public class CloneNote {
    public static void main (String args[]) {

    }
}

class HashTable implements Cloneable {
    private Entry[] buckets;
    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry (Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        //disadvantage consumer a lot of stack
        /*Entry deepCopy () {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }*/

        Entry deepCopy () {
            Entry result = new Entry (key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next );
            }
            return result;
        }


    }

    /*@Override
    protected HashTable clone() throws CloneNotSupportedException {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }*/

    @Override
    public HashTable clone() throws CloneNotSupportedException {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
