import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class WebDataRetriver {

	public static void main(String args[]) throws Exception{
		String url = "https://w.amazon.com/index.php/FC_Customer_Returns/Version_3.0/Questionnaire_Defects";
		URL myurl = new URL(url);
	    HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
	    InputStream is = con.getInputStream();
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader in = new BufferedReader(isr);
	    
	    String inputLine;
	    
	    while ((inputLine = in.readLine()) != null)
	    {
	      System.out.println(inputLine);
	    }
	 
	    in.close();
	}
}
