package com.Boonprakob.Thanaphon.dataStructure;

public class TestLinklist
{
    public static void main(String[] args)
    {
        MySet a = new MySet();
        for(int i = 0 ;i<100;i++)
        {
            if (i%2 == 0)
                a.add(i);
                a.add(i);
                a.add(i);
//            System.out.println("wow");
        }
        System.out.println(a);
    }
}
