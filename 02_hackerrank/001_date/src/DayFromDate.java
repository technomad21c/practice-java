import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DayFromDate {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 3, 3);
		System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
		
	}
}
