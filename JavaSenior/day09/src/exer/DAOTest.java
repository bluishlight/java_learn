package exer;

import java.util.Collection;

public class DAOTest {
    public static void main(String[] args) {
        DAO<String, Integer> dao = new DAO<>();
        dao.add("dio",12);
        dao.add("jojo",18);
        System.out.println(dao);
        System.out.println(""+ dao.get("dio"));
        dao.change("dio",220);
        System.out.println(dao);
//        dao.delete("dio");
        dao.add("skadi",10);
        dao.add("tide",88);
        Collection<Integer> list = dao.toList();
        System.out.println(list);
        System.out.println(dao);

    }
}
