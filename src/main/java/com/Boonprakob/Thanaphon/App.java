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
        // File file = new File("/home/thanaphon/text.txt");   //absolute path, depend on local machine   
        String fileName = new String();
        fileName = "text.txt" ;
        File file = new File(fileName);  //linux   
        // File file = new File(System.getProperty("user.dir", "/"+fileName));  //windows      
        System.out.println(file.getAbsolutePath());
        try (FileWriter fileWriter = new FileWriter(file);FileReader fileReader = new FileReader(file);)
        {
            for (String s:args)
            {
                fileWriter.write(s+"\n");
            }
            fileWriter.write(String.format("%s%n","กาก้าวไกล กาๆไปเหอะ" ));
            fileWriter.flush();
            // fileWriter.close(); //close does not require since use try-with-resource with AutoCloseable
            
            char[] c = new char[(int)file.length()-36]; // hard-code, will fix later
            fileReader.read(c);
            System.out.println(file.length());
            System.out.println(c);
            // fileReader.close(); //close does not require since use try-with-resource with AutoCloseable
        }
        catch(Exception e)
        {
            System.out.println("there is a exception happen"+"\n"+e.getMessage());
        }
        
    }
}
