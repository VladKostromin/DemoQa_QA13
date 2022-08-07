import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MethodTests {
    public static void main(String[] args) throws ParseException {
        dateSelector("11 5 1989");
    }

    public static void dateSelector(String dateOfBirth) throws ParseException {
//        String splitter[] = dateOfBirth.split(" ");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DATE, Integer.parseInt(splitter[0]));
//        calendar.set(Calendar.MONTH, Integer.parseInt(splitter[1]) - 1);
//        calendar.set(Calendar.YEAR, Integer.parseInt(splitter[2]));
//        Date date = calendar.getTime();
//        SimpleDateFormat format = new SimpleDateFormat("LLLL", Locale.ENGLISH);
//        String dateResult = format.format(date);
//        System.out.println(dateResult);

    }

}
