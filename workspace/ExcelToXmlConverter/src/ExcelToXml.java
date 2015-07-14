
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToXml 
{
	static ArrayList<String> tagList = new ArrayList<String>();
	
	private static void converter() throws IOException 
	{
		tagList.add("tag");
		tagList.add("English");
		tagList.add("text");
		tagList.add("stringSet");
		tagList.add("locale");
        File excel =  new File ("/Users/kumaksha/Desktop/PRG_CZ.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheetAt(0);
        
        int rowNum = ws.getLastRowNum() + 1;
        int colNum = ws.getRow(0).getLastCellNum();
        PrintWriter pw = new PrintWriter("/Users/kumaksha/Desktop/Output.txt", "UTF-8");
        int count = 0;
        try
        {
        	for(int i = 1; i <rowNum; i++)
        	{
        		XSSFRow row = ws.getRow(i);
        		pw.println("\t<string>");
        		for (int j = 0; j < colNum; j++)
        		{
                	if(j == 1)
                		continue;
                    XSSFCell cell = row.getCell(j);
                    String value = cell.toString();
                    String content = "\t\t<"+tagList.get(j)+">"+value+"</"+tagList.get(j)+">";
                    pw.println(content);
                    System.out.println ("the value is " + value);
                }
        		pw.println("\t\t<marketplace>default</marketplace>");
        		pw.println("\t</string>");
        		pw.flush();
                count++;
        	}
        }catch(NullPointerException e)
        {
        	System.out.println("Count is: "+count);
        }
        
    }
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Test");
		converter();
	}
}
