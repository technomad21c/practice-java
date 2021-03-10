package ex005_Reflection;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PersonReflection {

    public void run() {
        Person p = new Person();
        p.setFirstName("Brandon");
        p.setLastName("Jeong");

        Field[] allFields = p.getClass().getDeclaredFields();

        try {
            for (Field field : allFields) {
                Object value = field.get(p);
                Class<?> type = field.getType();

                String str = (String) value.toString();

                if (field.getName().equals("firstName")) {
                    field.set(p, "QM");
                }
            }
            p.lastName = "Canada";
            System.out.println(p.getFirstName() + ' ' + p.getLastName());
        }
        catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        String str = "Hello";
        Long i = null;
        String str2 = null;
        Boolean primary = null;

        if (isNull(str)) System.out.println("STR is NULL");
        if (isNull(i)) System.out.println("LONG is NULL");
        if (isNull(str2)) System.out.println("STR2 is NULL");
//        if (primary || true) System.out.println("Boolean is NULL");

        try {
            String sDate1 = "31-MAR-21";
            Date date1 = new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
            System.out.println(sDate1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LocalDate date2 = LocalDate.parse("12-Sep-2014", DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(date2);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MMM-dd");
        String date3 = sf.format(new Date());
        System.out.println(date3);

    }

    private boolean isNull(Object obj) {
        if (obj == null)
            return true;
        else return false;
    }
}
