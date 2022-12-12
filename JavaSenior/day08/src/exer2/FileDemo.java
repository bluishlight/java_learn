package exer2;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:/project/workspace/workspace_idea1/JavaSenior/day08/hello.txt");
        File destFile = new File(file.getParent(), "haha.txt");
        try{
            boolean newFile = destFile.createNewFile();
            if(newFile){
                System.out.println("成功了");
            }
        }catch (IOException E){

        }

    }
}
