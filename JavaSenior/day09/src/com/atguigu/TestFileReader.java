package com.atguigu;

import java.io.*;

public class TestFileReader {
    public static void main(String[] args) {
        FileReader fr = null;
        File file = new File("day09/hello.txt");
        File file2 = new File("day09/hello1.txt");
        System.out.println(file.getAbsolutePath());
        try {
            fr = new FileReader(file);
//            int data;
//            while((data= fr.read())!=-1) {
//                System.out.print((char)data);
//            }
            // 写法2
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf))!=-1){
//                for(int i=0;i<len;i++){
//                    System.out.print(cbuf[i]);
//                }
                System.out.print(new String(cbuf, 0, len));
            }

            // 写
            FileWriter fw = new FileWriter(file2,true);
            fw.write("i have an icecream\n");
            fw.write("wow");
            fw.close();


        }catch (FileNotFoundException e){

        }catch (IOException e){

        }finally {
            try {
                if(fr!= null){
                    fr.close();
                }
            }catch (IOException e){


            }

        }
    }
}
