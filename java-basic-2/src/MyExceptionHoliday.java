import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MyExceptionHoliday {
    private static final List<Integer> holidays = Arrays.asList(3,4,5,6,11,12,18,19,25,26);
    public static void main(String[] args) {
        MyExceptionHoliday myE = new MyExceptionHoliday();
    }

    MyExceptionHoliday() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
			System.out.println("何日ですか?");
			String line = reader.readLine();
			int day = Integer.parseInt(line);
			System.out.println("日付" + day + "日ですね。");

			test(day);

		}
		catch(IOException e) {
			System.out.println(e);
		} catch (NoHolidayException e) {
			e.printStackTrace();
		}
    }

    void test(int day) throws NoHolidayException{
		if(holidays.contains(day)) {
            throw new NoHolidayException();
        }
	}
}
