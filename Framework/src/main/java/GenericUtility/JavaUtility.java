package GenericUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	                         //GENERATE RANDOM NUMBER
	public int getRandomNumber()
	{
		Random ran=new Random();
		int random = ran.nextInt(5000);
		return random; }
		
		                     //CAPTURE SYSTEM DATE
		public String getSystemDate()
		{
			Date dateobj=new Date();
			SimpleDateFormat simple=new SimpleDateFormat("dd-MM-yyyy");
			String date = simple.format(dateobj);
			return date;
		}
		                    //GET REQUIRED DATE  (PAST OR FUTURE)
		public String getRequiredDateddMMYYYY(int days)
		{
			Date dateobj=new Date();
			SimpleDateFormat simple=new SimpleDateFormat("dd-MM-yyyy");
			String date = simple.format(dateobj);
			Calendar cal=simple.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, days);
			String reqDate = simple.format(cal.getTime());
			return reqDate;
			
		}
		
		//get current system date and time for screenshot
		
		public String getSystemDateAndTimeForScreenshot() {
			String dateAndTime=new Date().toString();
			String dateForSS=dateAndTime.replace(" ", "_").replace(":", "_");
			return dateForSS;
			
		}
		
	

}
