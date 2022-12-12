package exer1;

import java.io.File;
import java.util.Date;
import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆凌"));
        dao.save("1003",new User(1003,25,"蔡依林"));
        dao.update("1003",new User(1003,30,"方文山"));
        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);
        File file = new File("day08/hello.txt");
        long time = file.lastModified();
        System.out.println(file.getAbsolutePath());
        System.out.println(file.length());

        System.out.println( time);
        System.out.println(new Date(time));
    }

}
