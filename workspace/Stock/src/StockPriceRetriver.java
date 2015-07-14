import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.util.ByteArrayBuffer;



public class StockPriceRetriver
{
	private static void retirveStockPrices()
	{
		//String BASE_URL = "https://query.yahooapis.com/v1/public/yql?q=show%20tables&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys" ;
		
		try 
		{
			/*URL url = new URL(BASE_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			InputStream in = conn.getInputStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document dc= parser.parse(in);
			System.out.println(dc);*/
			
			String URL = "http://finance.yahoo.com/d/quotes.csv?s=GOOG&f=snbaopl1";
			//URL iurl = new URL(URL);
			//String URL = 
			URL url = new URL(URL);
			InputStream stream = url.openStream();

            BufferedInputStream bis = new BufferedInputStream(stream);
            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while ((current = bis.read()) != -1) 
            {
                baf.append((byte) current);
            }
            String stockText = new String(baf.toByteArray());
            System.out.println(stockText);
            String split[] = stockText.split(",");
            for(int i = 0; i < split.length; i++)
            {
            	System.out.println(split[i]);
            }
            //System.out.println(stockText);
			/*HttpURLConnection uc = (HttpURLConnection)iurl.openConnection();
			uc.connect();
			String csvData = uc.getResponseMessage();
			System.out.println(csvData);
			if (uc.getContentType().equalsIgnoreCase("image/jpeg"))
			{
			  
			}*/
			
			//Document doc = parser.parse(new InputSource(in));
			//System.out.println(doc);
			//XmlObject xml = new XmlObject.Factory.parse(in);
			//BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			//String text = null;
			//System.out.println(in);
			//text = reader.toString();
			//System.out.println(text);
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		/*
		// Read in data one line at a time, until all data has been read and stored.
		while ((text = reader.readLine()) != null)	{
			// Replace " with empty string to clean up data text
			text = text.replace("\"", "");
			StringTokenizer st = new StringTokenizer(text, ",");
			
			// Create new Data object to store results
			CommodityData newData = new CommodityData(st.nextToken(), st.nextToken(), st.nextToken(),
					st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),	st.nextToken(), 
					st.nextToken(), st.nextToken());
			
			// Add data to resulting data list
			data.add(newData);
		}
		
		return data;
		*/
	}
	
	public static void main(String[] args)
	{
		
		
		
		System.out.println("Test\n");
		retirveStockPrices();
		/*https://query.yahooapis.com/v1/public/yql?q=show%20tables&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys*/
	}
}
