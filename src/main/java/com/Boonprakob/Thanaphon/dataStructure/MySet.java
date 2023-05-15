package com.Boonprakob.Thanaphon.dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class MySet<T> implements Iterable{
    final Linklist<T>[] table;
    final int tableSize = 16;

    public MySet() {
        table = new Linklist[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new Linklist<>();
        }
    }

    @Override
    public String toString() {
        StringBuilder element = new StringBuilder();
        for (Linklist row : table) {
            Iterator listIter = row.iterator();
            try{
                while (listIter.hasNext()) {
                    element.append(listIter.next()+" ");
                }
            }catch (NullPointerException e)
            {
//                    element.append("");
            }
        }
        return "{" + element.toString().stripTrailing().replace(' ',',') + "}";
    }

    int hashing(T key) {
        return (int) key % tableSize;
    }

    void add(T value) {
//        if (value.getClass().isPrimitive())
//        {
//            table[hashing(value)].append(value);
//        }
//        else
//        {
//            table[hashing(value)].append(value);
//        }
        //preventing duplicated value
        if (table[hashing(value)] == null) {
            table[hashing(value)].append(value);
        } else if (!table[hashing(value)].search(value)) {
            table[hashing(value)].append(value);
        } else {
//            System.out.println("Duplicated value detected!!!");
        }
    }

    void remove(T value) {
        if (!table[hashing(value)].search(value)) {
            table[hashing(value)].deleteNode(value);
        } else {
            System.out.println("Node Not Found!!!");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int row = 0;
            Iterator<T> linkListiter = table[row].iterator();
            T dummy;
            @Override
            public boolean hasNext() {
                return row<tableSize-1;
            }

            @Override
            public T next() {
                while (!linkListiter.hasNext() && row < tableSize-1){
                    row++;
                    linkListiter =  table[row].iterator();

                }
                dummy = linkListiter.next();
                return dummy;
            }
        };
    }
}
