package ex005_Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PersonTest {
    // Fields names
    private static final String LAST_NAME_FIELD = "lastName";
    private static final String FIRST_NAME_FIELD = "firstName";
    private static final String EMPLOYEE_ID_FIELD = "employeeId";
    private static final String MONTH_EMPLOYEE_REWARD_FIELD = "reward";

    @Test
    public void should_returnTwoFields() {
        Person p = new Person();
        p.setFirstName("Brandon");
        p.setLastName("Jeong");

        Field[] allFields = p.getClass().getDeclaredFields();

        try {
            for (Field field : allFields) {
                Object value = field.get(p);
                Class<?> type = field.getType();

                if (type == String.class) {
                    field.set(p, "QM");
                }
            }

            System.out.println(p.getFirstName() + ' ' + p.getLastName());
        }
        catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, allFields.length);

        assertTrue(Arrays.stream(allFields).anyMatch(field ->
                field.getName().equals(LAST_NAME_FIELD)
                        && field.getType().equals(String.class))
        );
        assertTrue(Arrays.stream(allFields).anyMatch(field ->
                field.getName().equals(FIRST_NAME_FIELD)
                        && field.getType().equals(String.class))
        );

    }

}