package oop.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
//        demo1();
//        calanderDemo();
        localDemo();
    }

    public static void localDemo() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate parse = LocalDate.parse("2008-08-18");
        System.out.println(parse);
        parse = LocalDate.parse("2008-08-18T12:30:50", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(parse);
        parse = parse.minusDays(1);
        System.out.println(parse);
    }

    public static void calanderDemo() {
        Calendar c = Calendar.getInstance(); // 獲取對象
        c.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println(c.getTime()); // 獲取
        c.add(Calendar.DAY_OF_MONTH, -4); //做減法
        System.out.println(c.getTime()); // 獲取

        // 獲取年份
        System.out.println(c.get(Calendar.YEAR));

        c.set(Calendar.YEAR, 2023);
        System.out.println(c.getTime());

        c.set(2000, 0, 20);
        System.out.println(c.getTime());
    }

    public static void demo1() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        System.out.println(date1);
        System.out.println(date.after(date1));
        System.out.println(date.before(date1));
        Date date2 = date1; // date2 和 date1 指向同一個對象 // 不是複製操作
        date2.setTime(System.currentTimeMillis() - 1000 * 60 * 60 * 3);
        System.out.println(date2);
        System.out.println(date1);

        Date date3 = (Date) date1.clone(); // 複製date，基本上等於對象的複製
        date3.setTime(System.currentTimeMillis() - 1000 * 60 * 60 * 6); // 再減去6個小時
        System.out.println(date3);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(date));
//        2024年04月16日 21:11:53
        System.out.println(sdf.parse("2024年04月16日 21:11:53"));
        sdf.applyPattern("yyyy-MM-dd"); // 切換格式
        System.out.println(sdf.format(date));
    }
}
