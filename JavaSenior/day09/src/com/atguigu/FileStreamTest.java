package com.atguigu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileStreamTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("day09/hello.txt");

        System.out.println(file1.getAbsolutePath());
        FileReader fr = new FileReader(file1);
        char[] cbuf = new char[10];
        int len;
        while(( len = fr.read(cbuf))!=-1){
            System.out.println(cbuf);
        }
        fr.close();
    }
}
