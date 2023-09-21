package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class Test4 {

	public static void main(String[] args) {

		String dateString = "2/15:47:35";
		SimpleDateFormat df = new SimpleDateFormat("dd/HH:mm:");

		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = null;

		try {
			date = df.parse(dateString);

			System.out.println("date" + date);

			long time = date.getTime();
			long epoch = Instant.now().getEpochSecond();

			System.out.println(epoch);

			LocalDate ld = Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDate();
			System.out.println(ld);

			LocalDateTime ldt = Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();
			System.out.println(ldt);

			/*
			 * TargetTime = CurrentTime.getEpochSeconds() + TimerTimeSeconds;
			 * 
			 * Dann als Minutentimer:
			 * 
			 * 
			 */

			System.out.println(time);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
