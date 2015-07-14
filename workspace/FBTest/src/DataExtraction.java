import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import facebook4j.conf.ConfigurationBuilder;

public class DataExtraction {
	
	public static int countDiffDay(Calendar c1, Calendar c2) {
	    int returnInt = 0;
	    while (!c1.after(c2)) {
	      c1.add(Calendar.DAY_OF_MONTH, 1);
	      returnInt++;
	    }

	    if (returnInt > 0) {
	      returnInt = returnInt - 1;
	    }

	    return returnInt;
	}
	    
	    public static void main(String[] args) throws Exception{
//		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(); 
//		configurationBuilder.setDebugEnabled(true); 
//		configurationBuilder.setOAuthAppId("709060335824643"); 
//		configurationBuilder.setOAuthAppSecret("xxxxx"); 
//		configurationBuilder.setOAuthAccessToken("CAACEdEose0cBAPCFPoZBZCF1ZCwqEZBpRgOZC5IixpAaiRMRUQrF720NjRJhFtK6VoaxWyRJXB62j3Irl6xr8F11w4T5LqMCRZBjZAt8wTgKWVCV7yLl1iyduZBk8Dm5Kl96RaQYnezKjuPiKkoX12BiLR9igzdqjno3PumHo0ZChVQEWxFavzDbjKx3gFicZAOZCKyNaB2QgQ95sYT4m3lZBwYlZBwIb0NYKUA8ZD"); 
//		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    System.out.println(Boolean.TRUE.toString());
		int day;
		Date date1 = new Date();
		System.out.println(date1);
		Date date2 = new Date(24L*60L*1000L);
		System.out.println(date2);
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		if(cal1.before(cal2))
		{
			day = countDiffDay(cal1, cal2);
			System.out.println("Test 1 : "+day);
		}
		else
		{
			day = countDiffDay(cal2, cal1);
			System.out.println("Test 2 : "+day);
		}
		//System.out.println(date);
	}
}
