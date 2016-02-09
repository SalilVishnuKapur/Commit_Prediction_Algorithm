import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Excel_POI_demo {
static	double[][] values_initial=new double[5][3];
static 	double[][] values_final=new double[4][40];
static double[] width=new double[200];
static double k=0;
	public static void main(String[] args)
	{
		
		try {
		    
		    FileInputStream file = new FileInputStream(new File("C:\\Users\\Sushma\\Documents\\xlsx_test.xlsx"));
		     
		    //Get the workbook instance for XLS file 
		    HSSFWorkbook workbook = new HSSFWorkbook(file);

		    //Get first sheet from the workbook
		    HSSFSheet sheet = workbook.getSheetAt(1);
		     
		    //Iterate through each rows from first sheet
		    java.util.Iterator<Row> rowIterator = sheet.iterator();
		
			for(int i=0;i<5;i++)
			{
			if(i==0)
			{
			rowIterator.next();
			}
			else
			{
			 if(rowIterator.hasNext()) 
			{
			Row row = rowIterator.next();
			for(int j=0;j<3;j++)
			{
			//For each row, iterate through each columns
			 java.util.Iterator<Cell> cellIterator = row.cellIterator();
			if(j==0)
			{
			cellIterator.next();
			}
			else
			{
			 if(cellIterator.hasNext()) {

			      values_initial[i][j]=sheet.getRow(i).getCell(j).getNumericCellValue();
			      System.out.print(i+"       "+j+"  ");
			      System.out.println(values_initial[i][j]);
			      k++;
			}
			}

			}
			width[i]=k;
			k=0;
			}
			}
		
	            //FileOutputStream out = 
	              //  new FileOutputStream(new File("C:\\test.xls"));
	            //workbook.write(out);
	            //out.close();
	             
			
			}
			for(int i=1;i<5;i++)
			{
				for(int j=1;j<width[i]+1;j++)
				{
					
					System.out.println("length of first row"+i+" "+j+" "+width[i]);
					System.out.println(values_initial[i][j]);
					
			     }
			}
			file.close();
		}

		     catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
			
	}
}
