package com.Boonprakob.Thanaphon.dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class MySet <T>
{
    final Linklist<T>[] table;
    final int tableSize = 16;
    public MySet()
    {
        table = new Linklist[tableSize];
        for(int i = 0 ;i<tableSize;i++)
        {
            table[i] = new Linklist<>();
        }
    }
    int hashing(T key)
    {
        return (int) key%tableSize;
    }
    void add(T value)
    {
//        if (value.getClass().isPrimitive())
//        {
//            table[hashing(value)].append(value);
//        }
//        else
//        {
//            table[hashing(value)].append(value);
//        }
        //preventing duplicated value
        if (table[hashing(value)] == null)
        {
            table[hashing(value)].append(value);
        }
        else if (!table[hashing(value)].search(value))
        {
            table[hashing(value)].append(value);
        }
        else
        {
            System.out.println("Duplicated value detected!!!");
        }
    }
    void remove(T value)
    {
        if (!table[hashing(value)].search(value))
        {
            table[hashing(value)].deleteNode(value);
        }
        else
        {
            System.out.println("Node Not Found!!!");
        }
    }

}
