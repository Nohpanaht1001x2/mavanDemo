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
            @Override
            public boolean hasNext() {
                while (!linkListiter.hasNext() && row<tableSize-1){   //check if the cursor has reach the last node and there is a next row exist
                    //linkListiter.hasNext : check if the row is null/next node of cursor is null
                    //hasNext() : check if the iterator NOT reach the last row; true if NOT reach the last ,false with vice versa
                    row++;
                    linkListiter =  table[row].iterator();
                }
                if (row == tableSize -1 && !linkListiter.hasNext()){
                    return false;
                }
                return row<tableSize-1;
            }

            @Override
            public T next() {

                return linkListiter.next();
            }
        };
    }
}
