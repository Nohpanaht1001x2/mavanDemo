package com.Boonprakob.Thanaphon.dataStructure;

import java.util.Iterator;

public class TestLinklist {
    public static void main(String[] args) {
//        testList();
//        testSet();
        testSetIterator();
    }

    static public void testSet() {
        MySet a = new MySet();
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                a.add(i);
                a.add(i);
            }
//            System.out.println("wow");
        }
        System.out.println(a);
    }

    static public void testList() {
        Linklist<Integer> b = new Linklist<>();
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                b.append(i);
                b.append(i);
            }
        }
        Iterator<Integer> it = b.iterator();
//        while (it.hasNext()) {
//            System.out.print(it.next()+" ");
//        }
        System.out.println("\n"+b);
    }
    static public void testSetIterator()
    {
        MySet a = new MySet();
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                a.add(i);
                a.add(i);
            }
        }
        Iterator iter = a.iterator();
        while (iter.hasNext())
            System.out.print(iter.next()+" ");
    }
}
