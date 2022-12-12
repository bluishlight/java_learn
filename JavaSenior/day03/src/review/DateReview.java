package review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateReview {
    public static void main(String[] args) {
        // 法1
        Long time1 = System.currentTimeMillis();
        System.out.println(time1);
        // 法2
        Date date2= new Date();
        System.out.println(date2);
        System.out.println(date2.getTime());
        System.out.println(date2.getDate());
        System.out.println(new Date(1668562495830L));
        // 法3 SimpleDateFormat
        SimpleDateFormat sdf  = new SimpleDateFormat();
        String code = sdf.format(new Date());
        System.out.println("code "+code);
        try{
            Date d3 = sdf.parse(code);
            System.out.println("d3 "+d3);
        }catch (ParseException e){

        }

        // 方法4 Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        int x = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("x"+x);
        // 法5


    }
}

