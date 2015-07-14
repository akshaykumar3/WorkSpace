
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToXml 
{
	static ArrayList<String> tagList = new ArrayList<String>();
	static File excel =  new File ("/Users/kumaksha/Desktop/Electronics questionnaire translations ES.xlsx");
	static int count = 0;
	
	private static void converter() throws IOException 
	{
		
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheetAt(0);
        
        int rowNum = ws.getLastRowNum() + 1;
        int colNum = ws.getRow(0).getLastCellNum();
        PrintWriter pw = new PrintWriter("/Users/kumaksha/Desktop/Output.txt", "UTF-8");
        int count = 0;
        int tagListCounter = 0;
        try
        {
        	for(int i = 1; i <rowNum; i++)
        	{
        		XSSFRow row = ws.getRow(i);
//        		XSSFCell cell = row.getCell(6);
//                if(null != cell)
//                	continue;
//                cell = row.getCell(5);
//                if("N/A".equals(value))
//                	continue;
        		pw.println("\t<string>");
        		tagListCounter = 0;
        		for (int j = 0; j < colNum; j++)
        		{
                	if(j > 3 && j < 8)
                		continue;
                	XSSFCell cell = row.getCell(j);
                    String value = cell.toString();
                    String content = "\t\t<"+tagList.get(tagListCounter)+">"+value+"</"+tagList.get(tagListCounter)+">";
                    System.out.println(content);
                    pw.println(content);
//                    if(j == 4) {
//                    	count++;
//                    	System.out.print (count+". The tag is " + value);
//                    }
//                    if(j == 5) {
//                    	System.out.println("\tThe translation is " + value);
//                    }
                    tagListCounter++;
                }
        		//pw.println("\t\t<marketplace>default</marketplace>");
        		pw.println("\t</string>");
        		pw.flush();
        		count++;
                
        	}
        	System.out.println(count);
        }catch(Exception e)
        {
        	System.out.println("Count is: "+count);
        }
        
    }
	
	public static void converter1() throws FileNotFoundException, IOException {
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(excel));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
	    HSSFSheet sheet = wb.getSheetAt(0);
	    HSSFRow row;
	    HSSFCell cell;
	    int rows = sheet.getPhysicalNumberOfRows();
	    int cols = 0; // No of columns
	    int tmp = 0;

	    // This trick ensures that we get the data properly even if it doesn't start from first few rows
	    for(int i = 0; i < 10 || i < rows; i++) {
	        row = sheet.getRow(i);
	        if(row != null) {
	            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
	            System.out.println("tmp: "+tmp+"\tcols: "+cols);
	            if(tmp > cols) 
	            	cols = tmp;
	        }
	    }
	    
	    PrintWriter pw = new PrintWriter("/Users/kumaksha/Desktop/Output.txt", "UTF-8");
	    
	    try
	    {
	    for(int r = 0; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		            for(int c = 0; c < cols; c++) 
		            {
		            	if(c == 1)
		            		continue;
		                cell = row.getCell(c);
		                if(cell != null) {
		                	String value = cell.toString();
		                    String content = "\t\t<"+tagList.get(c)+">"+value+"</"+tagList.get(c)+">";
		                    pw.println(content);
		                    System.out.println ("the value is " + value);
		                }
		            }
		            pw.println("\t\t<marketplace>default</marketplace>");
	        		pw.println("\t</string>");
	        		pw.flush();
	                count++;
		        }
		    }
	    System.out.println(count);
	    } catch(Exception e){
	    	System.out.println("Count is: "+count);
	    }
	}
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Test");
		
		tagList.add("tag");
		tagList.add("marketplace");
		tagList.add("stringSet");
		tagList.add("locale");
		tagList.add("text");
		
		converter();
		//converter1();
	}
}
