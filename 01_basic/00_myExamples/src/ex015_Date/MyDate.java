package ex015_Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyDate {
    public void run()  {
        String str = "2021/02/01 17:37:23";
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDate date = LocalDate.parse(str, fm);
        System.out.println(date);

    }
}
