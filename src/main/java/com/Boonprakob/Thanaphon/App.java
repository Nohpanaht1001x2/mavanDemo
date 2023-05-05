package com.Boonprakob.Thanaphon;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException
    {
        System.out.println("Hello World!");
        System.out.println("Hello World! but second line!");
        FileWriter fileWriter = new FileWriter("text.txt");
        for (String s:args)
        {
            fileWriter.write(s+"\n");
        }
        fileWriter.write("กาก้าวไกล กาๆไปเหอะ");
        fileWriter.close();
    }
}
