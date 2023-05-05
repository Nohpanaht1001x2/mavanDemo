package com.Boonprakob.Thanaphon;

import java.io.File;
import java.io.FileReader;
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
        File file = new File("/home/thanaphon/text.txt");
        FileWriter fileWriter = new FileWriter(file);
        for (String s:args)
        {
            fileWriter.write(s+"\n");
        }
        fileWriter.write(String.format("%s%n","กาก้าวไกล กาๆไปเหอะ" ));
        fileWriter.flush();
        fileWriter.close();
        FileReader fileReader = new FileReader(file);
        char[] c = new char[(int)file.length()-36]; // hard-code, will fix later
        fileReader.read(c);
        System.out.println(file.length());
        System.out.println(c);
        fileReader.close();
    }
}
