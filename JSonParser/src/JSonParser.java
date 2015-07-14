import java.io.IOException;
import java.net.URL;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.google.common.base.Strings;


public class JSonParser {
	
	private static String FileName = "fileName";
	private static String Title = "title";
	private static String Content = "content";

	public static void main(String[] args) throws IOException {
		try {
			String temp = parser();
		} catch (JsonParseException e) {
			System.out.println("Error while parsing the Json");
		}
		
	}
	
	private static String parser() throws JsonParseException, IOException {
		String url = "http://localhost:8080/ServletTest";
		String fileName = null;
		String title = null;
		String content = null;
		URL Url = null;
		Url = new URL(url);
//		HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
//		connection.setRequestMethod("GET");
//		connection.setRequestProperty("Content-length", "0");
//        connection.setUseCaches(true);
//        connection.setAllowUserInteraction(true);
//        connection.setDefaultUseCaches(true);
//		connection.connect();
//		
//		int status = connection.getResponseCode();
//		
//		switch(status) {
//			case 200:
//			case 201:
//				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                StringBuilder sb = new StringBuilder();
//                String line;
//                while ((line = br.readLine()) != null) {
//                    sb.append(line+"\n");
//                }
//                br.close();
//                return sb.toString();
//		}
//		connection.getInputStream();
		JsonFactory factory = new JsonFactory();
		JsonParser parser = null;
		parser = factory.createJsonParser(Url);
        //System.out.println(parser);
        
        while(!parser.isClosed()) {
        	JsonToken token = null;
        	token = parser.nextToken();
//        	System.out.println(parser.getText());
//        	System.out.println(token);
        	if(token == null)
        		break;
        	if(JsonToken.START_OBJECT.equals(token)) {
        		token = parser.nextToken();
        		if(token == null)
            		break;
        		while(JsonToken.FIELD_NAME.equals(token)) {
        			System.out.print(parser.getText()+": ");
        			if("fileName".equals(parser.getText())) {
        				token = parser.nextToken();
        				if(!Strings.isNullOrEmpty(parser.getText()))
        						fileName = parser.getText();
        				else
        					fileName = "File name not found";
        			} else if("title".equals(parser.getText())) {
        				token = parser.nextToken();
        				if(!Strings.isNullOrEmpty(parser.getText()))
        						title = parser.getText();
        				else
        					title = "Title not found";
        			} else if("content".equals(parser.getText())) {
        				token = parser.nextToken();
        				if(!Strings.isNullOrEmpty(parser.getText()))
        						content = parser.getText();
        				else
        					content = "Content not found";
        			} 
        			token = parser.nextToken();
        			System.out.println(parser.getText());
        			token = parser.nextToken();
        		}
        	}
        }
        System.out.println(fileName);
        System.out.println(title);
        System.out.println(content);
		return content;
	}
}
