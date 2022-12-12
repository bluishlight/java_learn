package com.atguigu.exer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class TestSDF {
    public static void main(String[] args){
        // 方法 1
        long time = System.currentTimeMillis();
        System.out.println(time);
        // 方法 2
        Date date0 = new Date();
        System.out.println(date0.getTime());

        java.sql.Date date4= new java.sql.Date(time); //传入长整形 实现格式转换
        System.out.println("date4 "+date4);
        // 方法 3 SimpleDateFormat
        SimpleDateFormat sdf  = new SimpleDateFormat();
        // date -> 字符串
        Date  date1 = new Date();
        String str1 = sdf.format(date1);
        System.out.println(str1);
        // 字符串-> date
        String str2 = "22-11-16 上午9:56";
        try {
            Date  date2 = sdf.parse(str2);
            System.out.println(date2);
        }catch(ParseException e){

        }
        // 方法4 Calendar
        Calendar calendar = Calendar.getInstance();
        int days =  calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        calendar.set(Calendar.DAY_OF_YEAR, 333);
        days =  calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        calendar.add(Calendar.DAY_OF_YEAR, -3);
        days =  calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        // 方法 5 jdk8 LocalDateTime
        LocalDate ld1 = LocalDate.now();
        System.out.println("ld1 "+ld1);
        LocalTime lt1 = LocalTime.now();
        System.out.println("lt1 "+lt1);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("ldt "+ldt);
        // 自定义时间
        LocalDateTime ldt1 = LocalDateTime.of(2022,11,15,13,43);
        System.out.println("ldt1 "+ldt1+"--"+ ldt1.getMonth());

        LocalDateTime ldt2 = ldt1.withDayOfMonth(1); // 此方法不改变原值
        System.out.println("ldt1 "+ldt1);
        System.out.println("ldt2 "+ldt2);
        LocalDateTime ldt3 = ldt1.plusMonths(3);
        System.out.println("ldt3 "+ldt3);
        // 方法 6 Instant
        Instant instant = Instant.now(); // 本初子午线时间
        System.out.println("instant "+instant);// 注意时差
        OffsetDateTime offsetDateTime =instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime"+offsetDateTime);
        instant.toEpochMilli(); // 1970毫秒数
        Instant instant2 =  Instant.ofEpochMilli(1668491978534L);
        System.out.println("instant2 "+instant2);// 注意时差

        // 方法7
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        LocalDateTime ldt
        String str_ldt = formatter.format(ldt);
        System.out.println("str_ldt "+str_ldt);
        TemporalAccessor parse = formatter.parse("2022-11-15T14:21:08.350");
        System.out.println(parse);

        //7.2 本地化相关格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        // 7.3 自定义格式
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd ? hh:mm:ss");
        String str4 =formatter3.format(LocalDateTime.now());
        System.out.println(str4);

    }
}
