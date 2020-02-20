package osgi.service.printer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrinterImpl implements Printer {

	public void print(String message)
	{
		String time = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(time + " : " + message);
	}
}
