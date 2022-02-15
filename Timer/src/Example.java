import java.sql.Date;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.spi.CalendarNameProvider;

import javax.xml.crypto.Data;

public class Example {


	public static void main(String[] args) {
	
		Timer timer= new Timer();
		TimerTask timerTask= new TimerTask() {
	
			int counter=10;
			@Override
			public void run() {
				
				if(counter >= 0) {
					
					System.out.println(counter--);
				}
				
				else {
				
				System.out.println("happy new year");
				timer.cancel();
				}
			}
			   
		};
		
		Calendar date=Calendar.getInstance();
	
	date.set(Calendar.YEAR, 2022);
	date.set(Calendar.MONTH, Calendar.JANUARY);
	date.set(Calendar.DAY_OF_MONTH, 18);
	date.set(Calendar.HOUR_OF_DAY,22 );
	date.set(Calendar.MINUTE, 00);
	date.set(Calendar.SECOND, 00);
	date.set(Calendar.MILLISECOND, 0);
		
	timer.schedule(timerTask, date.getTime(),1000);
	
	}

}
